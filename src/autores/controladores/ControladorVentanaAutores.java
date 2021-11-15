/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import autores.modelos.ModeloTablaProfesores;
import autores.modelos.Profesor;
import autores.vistas.VentanaAutores;
import interfaces.IControladorAutores;
import interfaces.IGestorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
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
            JOptionPane.showMessageDialog(ventana,"Para modificar un profesor primero debe seleccionarlo.");
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
        GestorAutores ga= GestorAutores.instanciar();
        int filaSeleccionada = this.ventana.verTablaProfesor().getSelectedRow();
        
        if(filaSeleccionada != -1){
            int opcion = JOptionPane.showOptionDialog(ventana,CONFIRMACION_PROFESOR,"Borrar profesor",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Sí", "No"}, "No");
            if(opcion == JOptionPane.YES_OPTION){
                int dni = Integer.parseInt(this.ventana.verTablaProfesor().getValueAt(filaSeleccionada, 0).toString());//obtengo el DNI de la tabla
                Autor profesor = ga.verAutor(dni);
                
                ga.borrarAutor(profesor); //Agregué este metodo en gestorAutores para borrar el autor.
                this.ventana.verTablaProfesor().setModel(new ModeloTablaProfesores()); //muestra los datos en la tabla.
                JOptionPane.showMessageDialog(ventana,"El profesor ha sido borrado.");
            }
        }
        else{
            JOptionPane.showMessageDialog(ventana,"Para borrar un profesor primero debe seleccionarlo.");
        }
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
