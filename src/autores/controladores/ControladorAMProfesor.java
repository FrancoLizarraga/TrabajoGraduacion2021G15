/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.GestorAutores;
import autores.vistas.VentanaAMProfesor;
import interfaces.IControladorAMProfesor;
import interfaces.IGestorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author Usuario
 */
public class ControladorAMProfesor implements IControladorAMProfesor{
    private VentanaAMProfesor ventana;
    
    //INICIO PATRON SINGLETON.
    private static ControladorAMProfesor instanciador;
    private ControladorAMProfesor(){
        ventana = new VentanaAMProfesor(this);
    }
    public static ControladorAMProfesor instanciar(){
        if(instanciador == null)
            instanciador = new ControladorAMProfesor();
        return instanciador;   
    }
    //FIN PATRON SINGLETON.

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        IGestorAutores ga=GestorAutores.instanciar();
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        ventana.dispose();
    }

    @Override
    public void txtApellidosPresionarTecla(KeyEvent evt) {
        
    }

    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {
        
    }

    @Override
    public void txtDocumentoPresionarTecla(KeyEvent evt) {
        
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
       
    }

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {
        
    }

    public VentanaAMProfesor getVentana() {
        return ventana;
    }
    
    
}
