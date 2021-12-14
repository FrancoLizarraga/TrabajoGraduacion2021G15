/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTablaAMGrupo extends AbstractTableModel{
    private GestorGrupos gestor = GestorGrupos.instanciar();
    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private List<MiembroEnGrupo> miembrosEnGrupo = new ArrayList<>();
    
    //QUIEN SE ENCARGA DE ASIGNARLE EL NOMBRE.
    public ModeloTablaAMGrupo() {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Rol");
    }
    
    //CREO OTRO CONSTRUCTOR (LO SOBRECARGO) PARA PASARLE EL GRUPO A MODIFICAR.
    public ModeloTablaAMGrupo(Grupo grupoParaModificar) {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Rol");
        
        /*Le asigno los miembros del grupo a modificar.*/
        this.miembrosEnGrupo = gestor.verGrupo(grupoParaModificar.verNombre()).verMiembros();
        //Ordeno la lista de miembros para que coincida con los autores de la columna, como en GestorAutores.
        Comparator<MiembroEnGrupo> comparador =(MiembroEnGrupo miembro1, MiembroEnGrupo miembro2) -> 
                (miembro1.verAutor().verApellidos().concat(miembro1.verAutor().verNombres())).toLowerCase().
                compareTo(miembro2.verAutor().verApellidos().concat(miembro2.verAutor().verNombres()).toLowerCase());
        
        Collections.sort(this.miembrosEnGrupo,comparador);
    }
    @Override
    public int getRowCount() {
        return this.miembrosEnGrupo.size();  //Cantidad de filas.
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size(); //Cantidad de columnas.
    }

    /*Este metodo se encarga de mostrar los datos en la tabla, celda por celda*/
    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo miembro = this.miembrosEnGrupo.get(fila);
        Autor autor = miembro.verAutor();
        switch (columna) {
            case 0:
                return autor.verApellidos() + ", " + autor.verNombres();
            case 1:
                return miembro.verRol(); //Toma el rol del autor actual.
            default:
                return miembro.verRol();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
    
}
