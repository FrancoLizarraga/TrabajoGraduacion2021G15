/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTablaGruposAutor extends AbstractTableModel{
    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private List<MiembroEnGrupo> miembros = new ArrayList<>();
    
    //QUIEN SE ENCARGA DE ASIGNARLE EL NOMBRE
    public ModeloTablaGruposAutor(Autor autor) {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Rol");

        this.miembros = autor.devolverMiembros();

    }
    
    @Override
    public int getRowCount() {
        return this.miembros.size();  //cantidad de filas
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size(); //cantidad de columnas
    }

    //Se encarga de mostrar celda a celda el valor de los atributos de cada grupo.
    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo miembro = this.miembros.get(fila);
        switch (columna) {
            case 0:
                return miembro.verGrupo().verNombre();
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
    
}