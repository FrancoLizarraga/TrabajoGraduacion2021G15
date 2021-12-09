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
    private ArrayList<String> nombresColumnas = new ArrayList<>();
    private List<Autor> miembros = new ArrayList<>();
    private boolean[] editables = {false, true};
    
    //QUIEN SE ENCARGA DE ASIGNARLE EL NOMBRE
    public ModeloTablaModificarMiembros(VentanaModificarMiembros ventana) {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Rol");
        this.miembros = GestorAutores.instanciar().verAutores(); //ahora grpos ve el arrayList cargado en el gestor.

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editables[columnIndex]; //To change body of generated methods, choose Tools | Templates.
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
        Autor autor = this.miembros.get(fila);
        
//        ControladorModificarMiembros c = ControladorModificarMiembros.instanciar();
//        TableColumn columnaRol = c.verVentana().verTablaModificar().getColumnModel().getColumn(1);
//        JComboBox combo = new JComboBox();
//        combo.setModel(new ModeloComboRoles());
//        columnaRol.setCellEditor(new DefaultCellEditor(combo));
//        c.verVentana().verTablaModificar().getColumnModel().getColumn(1).get;
        switch (columna) {
            case 0:
                return autor.verApellidos() + ", " + autor.verNombres() + "(" + autor.verDni() + ")";
            case 1:
                return Rol.ADMINISTRADOR; //FALTA HACER ESTO.
            default:
                return autor.verApellidos();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
}