/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.vistas.VentanaAutores;
import interfaces.IControladorAMProfesor;
import interfaces.IControladorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 *
 * @author Usuario
 */
public class ControladorVentanaAutores implements IControladorAutores{
    private VentanaAutores ventana;
    
    //INICIO PATRON SINGLETON.
    private static ControladorVentanaAutores instanciador;
    private ControladorVentanaAutores(){
        ventana = new VentanaAutores(this);
    }
    public static ControladorVentanaAutores instanciar(){
//        System.out.println("Pase el instanciar  en ventana autores");
        if(instanciador == null)
            instanciador = new ControladorVentanaAutores();
        return instanciador;
    }
    //FIN PATRON SINGLETON.
    
    @Override
    public void btnNuevoProfesorClic(ActionEvent evt) {
        ControladorAMProfesor cp = ControladorAMProfesor.instanciar();
        cp.getVentana().setVisible(true);
    }

    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        ventana.dispose();
    }

    @Override
    public void btnBuscarProfesorClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public VentanaAutores getVentana() {
        return ventana;
    }
    
    
}
