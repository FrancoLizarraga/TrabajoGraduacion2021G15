/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.controladores;

import grupos.modelos.ModeloTablaModificarMiembros;
import grupos.vistas.VentanaModificarMiembros;
import interfaces.IControladorModificarMiembros;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Usuario
 */
public class ControladorModificarMiembros implements IControladorModificarMiembros{
    private VentanaModificarMiembros ventana;
    
    private static ControladorModificarMiembros instanciador;

    private ControladorModificarMiembros() {
        ventana = new VentanaModificarMiembros(this);
    }

    public static ControladorModificarMiembros instanciar() {
        if (instanciador == null) {
            instanciador = new ControladorModificarMiembros();
        }
        return instanciador;
    }

    @Override
    public void btnTodosClic(ActionEvent evt) {
        JTable tabla = this.ventana.verTablaModificar();
        ModeloTablaModificarMiembros mtpc = (ModeloTablaModificarMiembros)tabla.getModel();
        ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, mtpc.getRowCount() - 1);
    }

    @Override
    public void btnNingunoClic(ActionEvent evt) {
        JTable tabla = this.ventana.verTablaModificar();
        ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    @Override
    public void btnAceptarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    public VentanaModificarMiembros verVentana() {
        return ventana;
    }
    
}
