/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTablaAlumnos extends AbstractTableModel {

    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private ArrayList<Alumno> alumnos = new ArrayList<>();

    //QUIEN SE ENCARGA DE ASIGNARLE EL NOMBRE
    public ModeloTablaAlumnos() {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("CX");

        this.alumnos = GestorAutores.instanciar().verAlumnos(); //ahora profesores ve el arrayList cargado en el gestor.

    }

    //CREO OTRO CONSTRUCTOR (LO SOBRECARGO) PARA PASARLE EL ARRAYLIST FILTRADO CON LOS APELLIDOS
    public ModeloTablaAlumnos(ArrayList<Alumno> filtroAlumnos) {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("CX");

        this.alumnos = filtroAlumnos; //ahora alumnos ve el arrayList filtrado en ControladorVentanaAutores.

    }

    @Override
    public int getRowCount() {
        return this.alumnos.size(); //cantidad de filas
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size(); //cantidad de columnas
    }

    //Se encarga de mostrar celda a celda el valor de los atributos de cada alumno.
    @Override
    public Object getValueAt(int fila, int columna) {
        Alumno alumno = this.alumnos.get(fila);
        switch (columna) {
            case 0:
                return alumno.verDni();
            case 1:
                return alumno.verApellidos();
            case 2:
                return alumno.verNombres();
            case 3:
                return alumno.verCx();
            default:
                return alumno.verCx();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
}
