/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.controladores;

import grupos.vistas.VentanaModificarMiembros;
import interfaces.IControladorModificarMiembros;
import java.awt.event.ActionEvent;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnNingunoClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnAceptarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public VentanaModificarMiembros verVentana() {
        return ventana;
    }
    
}
