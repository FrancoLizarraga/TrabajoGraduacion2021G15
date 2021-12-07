/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTablaGrupos extends AbstractTableModel{
    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private List<Grupo> grupos = new ArrayList<>();
    
    //QUIEN SE ENCARGA DE ASIGNARLE EL NOMBRE
    public ModeloTablaGrupos() {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Descripción");

        this.grupos = GestorGrupos.instanciar().verGrupos(); //ahora grpos ve el arrayList cargado en el gestor.

    }
    //CREO OTRO CONSTRUCTOR (LO SOBRECARGO) PARA PASARLE EL ARRAYLIST FILTRADO CON LOS APELLIDOS
    public ModeloTablaGrupos(ArrayList<Grupo> listaFiltrada) {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Descripción");

        this.grupos = listaFiltrada; //ahora grupos ve el arrayList filtrado en ControladorGrupos.

    }
    @Override
    public int getRowCount() {
        return this.grupos.size();  //cantidad de filas
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size(); //cantidad de columnas
    }

    //Se encarga de mostrar celda a celda el valor de los atributos de cada grupo.
    @Override
    public Object getValueAt(int fila, int columna) {
        Grupo grupo = this.grupos.get(fila);
        switch (columna) {
            case 0:
                return grupo.verNombre();
            case 1:
                return grupo.verDescripcion();
            default:
                return grupo.verDescripcion();
        }
    }

    @Override
    public String getColumnName(int columna) {
       return this.nombresColumnas.get(columna);
    }
    
}
