/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import autores.modelos.ModeloTablaAlumnos;
import autores.modelos.ModeloTablaProfesores;
import autores.modelos.Profesor;
import autores.vistas.VentanaAutores;
import interfaces.IControladorAutores;
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
        ControladorAMAlumno ca = ControladorAMAlumno.instanciar();
        ca.verVentana().setTitle(ALUMNO_NUEVO);
        ca.verVentana().verTxtDNI().setEnabled(true);
        ca.verVentana().setVisible(true);
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
        ControladorAMAlumno cp = ControladorAMAlumno.instanciar(); //crea una instancia y muestra la ventana.
        if(this.ventana.verTablaAlumno().getSelectedRow() == -1) 
            JOptionPane.showMessageDialog(ventana,"Para modificar un alumno primero debe seleccionarlo.");
        else{
            cp.verVentana().setTitle(ALUMNO_MODIFICAR); //le agrego el titulo
            cp.verVentana().setVisible(true); //la hago visible
            cp.verVentana().verTxtDNI().setEnabled(false); //Deshabilito el campo de txt de dni para no poder modificarlo.
        }
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
        GestorAutores ga= GestorAutores.instanciar();
        int filaSeleccionada = this.ventana.verTablaAlumno().getSelectedRow();
        
        if(filaSeleccionada != -1){
            int opcion = JOptionPane.showOptionDialog(ventana,CONFIRMACION_ALUMNO,"Borrar alumno",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Sí", "No"}, "No");
            if(opcion == JOptionPane.YES_OPTION){
                int dni = Integer.parseInt(this.ventana.verTablaAlumno().getValueAt(filaSeleccionada, 0).toString());//obtengo el DNI de la tabla
                Autor alumno = ga.verAutor(dni);
                
                ga.borrarAutor(alumno); //Agregué este metodo en gestorAutores para borrar el autor.
                this.ventana.verTablaAlumno().setModel(new ModeloTablaAlumnos()); //muestra los datos en la tabla.
                JOptionPane.showMessageDialog(ventana,"El alumno ha sido borrado.");
            }
        }
        else{
            JOptionPane.showMessageDialog(ventana,"Para borrar un alumno primero debe seleccionarlo.");
        }
        
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        ventana.dispose();
    }

    @Override
    public void btnBuscarProfesorClic(ActionEvent evt) {
        GestorAutores ga = GestorAutores.instanciar();
        String apellidos = this.ventana.verTxtApellidosProfesor().getText().trim();
        ArrayList<Profesor> apellidosIguales = new ArrayList<>();
        
        if(!apellidos.isEmpty()){
            for(Profesor p : ga.verProfesores()){
                if(p.verApellidos().toLowerCase().contains(apellidos.toLowerCase())){
                    if(p.verApellidos().compareTo(apellidos)>= 0)
                        apellidosIguales.add(p);
                }
            }
        
            //MUESTRA LOS PROFESORES QUE TIENEN EL APELLIDO INGRESADO EN EL CAMPO DE TEXTO.
            this.ventana.verTablaProfesor().setModel(new ModeloTablaProfesores(apellidosIguales));
        }
        else
            this.ventana.verTablaProfesor().setModel(new ModeloTablaProfesores());
    }

    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {
        GestorAutores ga = GestorAutores.instanciar();
        String apellidos = this.ventana.verTxtApellidosAlumno().getText().trim();
        ArrayList<Alumno> apellidosIguales = new ArrayList<>();
        
        if(!apellidos.isEmpty()){
            for(Alumno a : ga.verAlumnos()){
                if(a.verApellidos().toLowerCase().contains(apellidos.toLowerCase())){
                    if(a.verApellidos().compareTo(apellidos)>= 0)
                        apellidosIguales.add(a);
                }
            }
        
            //MUESTRA LOS PROFESORES QUE TIENEN EL APELLIDO INGRESADO EN EL CAMPO DE TEXTO.
            this.ventana.verTablaAlumno().setModel(new ModeloTablaAlumnos(apellidosIguales));
        }
        else
            this.ventana.verTablaAlumno().setModel(new ModeloTablaAlumnos());
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        //FALTA ESTE METODO
        //NO SUPE QUÉ HACER EN ESTE...
    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER)
            ventana.verBtnBuscarProfesor().doClick();
    }

    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER)
            ventana.verBtnBuscarAlumno().doClick();
    }
    

    public VentanaAutores verVentana() {
        return ventana;
    }
    
    
}
