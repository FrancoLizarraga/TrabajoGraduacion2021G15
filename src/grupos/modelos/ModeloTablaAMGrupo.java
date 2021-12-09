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
public class ModeloTablaAMGrupo extends AbstractTableModel{
    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private List<Grupo> miembros = new ArrayList<>();
    
    //QUIEN SE ENCARGA DE ASIGNARLE EL NOMBRE
    public ModeloTablaAMGrupo() {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Rol");

        this.miembros = GestorGrupos.instanciar().verGrupos(); //ahora grpos ve el arrayList cargado en el gestor.

    }
    @Override
    public int getRowCount() {
        return this.miembros.size();  //cantidad de filas
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size(); //cantidad de columnas
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Grupo grupo = this.miembros.get(fila);
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
