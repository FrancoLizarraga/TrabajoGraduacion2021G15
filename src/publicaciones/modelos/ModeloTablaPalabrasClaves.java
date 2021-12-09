/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import autores.modelos.GestorAutores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;

/**
 *
 * @author Usuario
 */
public class ModeloTablaPalabrasClaves extends AbstractTableModel {

    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private List<PalabraClave> palabras = new ArrayList<>();

    //QUIEN SE ENCARGA DE ASIGNARLE EL NOMBRE
    public ModeloTablaPalabrasClaves() {
        this.nombresColumnas.add("Nombre");

        this.palabras = GestorPalabrasClaves.instanciar().verPalabrasClaves(); //ahora palabras ve el arrayList cargado en el gestor.

    }

    //CREO OTRO CONSTRUCTOR (LO SOBRECARGO) PARA PASARLE EL ARRAYLIST FILTRADO CON LOS APELLIDOS
//    public ModeloTablaPalabrasClaves(ArrayList<Alumno> filtroAlumnos) {
//        this.nombresColumnas.add("DNI");
//        this.nombresColumnas.add("Apellidos");
//        this.nombresColumnas.add("Nombres");
//        this.nombresColumnas.add("CX");
//
//        this.alumnos = filtroAlumnos; //ahora alumnos ve el arrayList filtrado en ControladorVentanaAutores.
//
//    }

    @Override
    public int getRowCount() {
        return this.palabras.size(); //cantidad de filas
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size(); //cantidad de columnas
    }

    //Se encarga de mostrar celda a celda el valor de los atributos de cada palabra clave.
    @Override
    public Object getValueAt(int fila, int columna) {
        PalabraClave palabra = this.palabras.get(fila);
        switch (columna) {
            case 0:
                return palabra.verNombre();
            default:
                return palabra.verNombre();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
}