/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTablaProfesores extends AbstractTableModel {

    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();

    //QUIEN SE ENCARGA DE ASIGNARLE EL NOMBRE
    public ModeloTablaProfesores() {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("Cargo");

        this.profesores = GestorAutores.instanciar().verProfesores(); //ahora profesores ve el arrayList cargado en el gestor.

    }

    //CREO OTRO CONSTRUCTOR PARA PASARLE EL ARRAYLIST FILTRADO CON LOS APELLIDOS
    public ModeloTablaProfesores(ArrayList<Profesor> filtroProfesores) {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("Cargo");

        this.profesores = filtroProfesores; //ahora profesores ve el arrayList filtrado en ControladorVentanaAutores.

    }

    @Override
    public int getRowCount() {
        return this.profesores.size(); //cantidad de filas
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size(); //cantidad de columnas
    }

    //Se encarga de mostrar celda a celda el valor de los atributos de cada profesor.
    @Override
    public Object getValueAt(int fila, int columna) {
        Profesor profesor = this.profesores.get(fila);
        switch (columna) {
            case 0:
                return profesor.verDni();
            case 1:
                return profesor.verApellidos();
            case 2:
                return profesor.verNombres();
            case 3:
                return profesor.verCargo();
            default:
                return profesor.verCargo();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

}
