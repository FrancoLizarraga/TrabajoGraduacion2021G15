/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.controladores;

import grupos.vistas.VentanaGrupos;
import interfaces.IControladorAMGrupo;
import interfaces.IControladorGrupos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class ControladorGrupos implements IControladorGrupos{
    private IControladorGrupos controlador;
    private VentanaGrupos ventana;
    
    private static ControladorGrupos instanciador;

    private ControladorGrupos() {
        ventana = new VentanaGrupos(this);
    }

    public static ControladorGrupos instanciar() {
        if (instanciador == null) {
            instanciador = new ControladorGrupos();
        }
        return instanciador;
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        ControladorAMGrupo cg = ControladorAMGrupo.instanciar();
        cg.verVentana().setTitle(IControladorAMGrupo.TITULO_NUEVO);
        cg.verVentana().verBtnModificarMiembros().setEnabled(false);
        cg.verVentana().verTxtNombre().setEnabled(true);
        cg.verVentana().setVisible(true);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        ControladorAMGrupo cg = ControladorAMGrupo.instanciar();
        if(this.verVentana().verTablaGrupos().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(ventana, "Para modificar un grupo primero debe seleccionarlo.");
        }
        else{
            /*Este bloque de codigo es para dejar ene l campo de texto el nombre del grupo que se va a modificar*/
            JTable tablaGrupos = this.verVentana().verTablaGrupos();
            int filaSeleccionada = tablaGrupos.getSelectedRow();
            String nombreSeleccionado = tablaGrupos.getValueAt(filaSeleccionada, 0).toString();
            JTextField txtNombre = cg.verVentana().verTxtNombre();
            txtNombre.setText(nombreSeleccionado);
            /*HASTA ACÁ*/
            
            cg.verVentana().setTitle(IControladorAMGrupo.TITULO_MODIFICAR);
            cg.verVentana().verTxtNombre().setEnabled(false);
            cg.verVentana().verBtnModificarMiembros().setEnabled(true);
            cg.verVentana().setVisible(true);
            
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public VentanaGrupos verVentana() {
        return ventana;
    }
    
    
}
