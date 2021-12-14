/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import grupos.controladores.ControladorModificarMiembros;
import grupos.vistas.VentanaModificarMiembros;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Usuario
 */
public class ModeloTablaModificarMiembros extends AbstractTableModel{
    private GestorGrupos gestor = GestorGrupos.instanciar();
    private GestorAutores gestorAutores = GestorAutores.instanciar();
    private List<Autor> autores = gestorAutores.verAutores();
    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private List<MiembroEnGrupo> miembrosEnGrupo = new ArrayList<>();
    
    //Este vector le paso al metodo isCellEditable para poder mostrar el combo en la columna de los Roles.
    private boolean[] editables = {false, true};
    
    //QUIEN SE ENCARGA DE ASIGNARLE EL NOMBRE
    public ModeloTablaModificarMiembros(Grupo grupoParaModificarMiembros) {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Rol");
        
        Grupo grupoAuxiliar = new Grupo("Grupo Auxiliar","Descripcion Auxiliar");
        boolean mismoAutor=false;
        //Cargar Autores a los miembros con un Grupo Auxiliar 
        //(Si se selecciona se cambiar el Grupo Auxiliar por el Grupo a Modificar)
        for(Autor a: this.autores){
            for(int indiceMiembro=0;indiceMiembro<grupoParaModificarMiembros.verMiembros().size();indiceMiembro++){
                if((a.verApellidos().concat(a.verNombres())).equals((grupoParaModificarMiembros.verMiembros().get(indiceMiembro).verAutor().verApellidos().concat(grupoParaModificarMiembros.verMiembros().get(indiceMiembro).verAutor().verNombres())))){
                mismoAutor=true;
                    }
                }
            if(!mismoAutor){this.miembrosEnGrupo.add(new MiembroEnGrupo(a,grupoAuxiliar,null));}
            else{mismoAutor=false;}
            }
        //Agregar los miembros de Grupo a Modificar a los mimebros
        for(int indiceMiembro=0;indiceMiembro<grupoParaModificarMiembros.verMiembros().size();indiceMiembro++){
        this.miembrosEnGrupo.add(grupoParaModificarMiembros.verMiembros().get(indiceMiembro));
        }
        //Ordeno la lista de miembros para que coincida con los autores de la columna, como en GestorAutores.
        Comparator<MiembroEnGrupo> comparador =(MiembroEnGrupo miembro1, MiembroEnGrupo miembro2) -> 
                (miembro1.verAutor().verApellidos().concat(miembro1.verAutor().verNombres())).toLowerCase().
                compareTo(miembro2.verAutor().verApellidos().concat(miembro2.verAutor().verNombres()).toLowerCase());
        
        Collections.sort(this.miembrosEnGrupo,comparador);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editables[columnIndex]; 
    }
    
    @Override
    public int getRowCount() {
        return this.autores.size();  //Cantidad de filas.
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size(); //Cantidad de columnas.
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo miembro = this.miembrosEnGrupo.get(fila);
        Autor autor = gestorAutores.verAutores().get(fila);
        switch (columna) {
            case 0:
                return autor.verApellidos() + ", " + autor.verNombres() + " (" + autor.verDni() + ")";
            case 1:
                return miembro.verRol();
            default:
                return miembro.verRol();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
    
    @Override
    public void setValueAt(Object valor, int fila, int columna) {
        MiembroEnGrupo miembro=  this.miembrosEnGrupo.get(fila);
        Autor autor = this.autores.get(fila);
        switch(columna){
            case 0:
                String cadena=(String)valor;
                String[] cadenas=cadena.split(", ");
                autor.asignarApellidos(cadenas[0]);
                autor.asignarNombres(cadenas[1]);
            default:
                miembro.asignarRol((Rol)valor);
        }
        
    }
    
    public MiembroEnGrupo verMiembroEnGrupo(int posicion){
        return this.miembrosEnGrupo.get(posicion);
    }
}
