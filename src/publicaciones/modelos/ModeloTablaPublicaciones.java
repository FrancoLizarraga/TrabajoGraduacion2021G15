/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import autores.modelos.Autor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTablaPublicaciones extends AbstractTableModel {

    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private List<Publicacion> publicaciones = new ArrayList<>();

    //QUIEN SE ENCARGA DE ASIGNARLE EL NOMBRE
    public ModeloTablaPublicaciones() {
        this.nombresColumnas.add("Título");
        this.nombresColumnas.add("Autor");
        this.nombresColumnas.add("Año");

        this.publicaciones = GestorPublicaciones.instanciar().verPublicaciones(); //ahora publicaciones ve el arrayList cargado en el gestor.

    }

//    CREO OTRO CONSTRUCTOR (LO SOBRECARGO) PARA PASARLE EL ARRAYLIST FILTRADO CON LOS TIULOS.
    public ModeloTablaPublicaciones(List<Publicacion> filtroPublicaciones) {
        this.nombresColumnas.add("Título");
        this.nombresColumnas.add("Autor");
        this.nombresColumnas.add("Año");

        this.publicaciones = filtroPublicaciones; //ahora publicaciones ve el arrayList filtrado en ControladorPublicaciones.

    }

    @Override
    public int getRowCount() {
        return this.publicaciones.size(); //cantidad de filas
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size(); //cantidad de columnas
    }

    //Se encarga de mostrar celda a celda el valor de los atributos de cada publicacion.
    @Override
    public Object getValueAt(int fila, int columna) {
        Publicacion publicacion = this.publicaciones.get(fila);
        Autor autor = publicacion.verMiembro().verAutor();
        switch (columna) {
            case 0:
                return publicacion.verTitulo();
            case 1:
                return autor.verApellidos()+ ", " + autor.verNombres();
            case 2: 
                return publicacion.verFechaPublicacion().getYear();
            default:
                return publicacion.verFechaPublicacion().getYear();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
}