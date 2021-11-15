/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.ModeloTablaProfesores;
import autores.vistas.VentanaAutores;
import interfaces.IControladorAMProfesor;
import interfaces.IControladorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

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
        cp.verVentana().setTitle(PROFESOR_NUEVO);
        cp.verVentana().verTxtDNI().setEnabled(true);
        cp.verVentana().setVisible(true);
    }

    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {
        
    }

    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {
        ControladorAMProfesor cp = ControladorAMProfesor.instanciar(); //crea una instancia y muestra la ventana.
        if(this.ventana.verTablaProfesor().getSelectedRow() == -1)
            JOptionPane.showMessageDialog(ventana,"Para modificar un profesor debe seleccionarlo primero.");
        else{
            cp.verVentana().setTitle(PROFESOR_MODIFICAR); //le agrego el titulo
            cp.verVentana().setVisible(true); //la hago visible
            cp.verVentana().verTxtDNI().setEnabled(false); //Deshabilito el campod de txt de dni para no poder modificarlo.
        }
    }

    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {
        
    }

    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {
        
        
    }

    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {
        
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        ventana.dispose();
    }

    @Override
    public void btnBuscarProfesorClic(ActionEvent evt) {
        
    }

    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {
        
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        
    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
        
    }

    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {
        
    }

    public VentanaAutores getVentana() {
        return ventana;
    }
    
    
}
