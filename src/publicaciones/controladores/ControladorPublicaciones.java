/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.controladores;

import interfaces.IControladorAMPublicacion;
import interfaces.IControladorPublicaciones;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import publicaciones.vistas.VentanaPublicaciones;

/**
 *
 * @author Usuario
 */
public class ControladorPublicaciones implements IControladorPublicaciones{
    private VentanaPublicaciones ventana;
    
    //INICIO PATRON SINGLETON.
    private static ControladorPublicaciones instanciador;

    private ControladorPublicaciones() {
        ventana = new VentanaPublicaciones(this);
    }

    public static ControladorPublicaciones instanciar() {
        if (instanciador == null)
            instanciador = new ControladorPublicaciones();
        return instanciador;
    }
    //FIN PATRON SINGLETON.
    
    @Override
    public void btnNuevaClic(ActionEvent evt) {
        ControladorAMPublicacion camp = ControladorAMPublicacion.instanciar();
        camp.verVentana().setTitle(IControladorAMPublicacion.TITULO_NUEVA);
        camp.verVentana().setVisible(true); //HAGO QUE SI ABRE MAS DE UNA VEZ, SE VUELVA A MOSTRAR.
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void txtTituloPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public VentanaPublicaciones verVentana() {
        return ventana;
    }
    
    
}
