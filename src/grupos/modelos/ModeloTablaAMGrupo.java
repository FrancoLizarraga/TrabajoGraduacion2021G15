/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTablaAMGrupo extends AbstractTableModel{
    private GestorGrupos gestor = GestorGrupos.instanciar();
    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private List<MiembroEnGrupo> miembroEnGrupo = new ArrayList<>();
    
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
        this.miembroEnGrupo = gestor.verGrupo(grupoParaModificar.verNombre()).verMiembros();
    }
    @Override
    public int getRowCount() {
        return this.miembroEnGrupo.size();  //Cantidad de filas.
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size(); //Cantidad de columnas.
    }

    /*Este metodo se encarga de mostrar los datos en la tabla, celda por celda*/
    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo miembro = this.miembroEnGrupo.get(fila);
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
