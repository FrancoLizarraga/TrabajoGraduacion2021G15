/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import autores.modelos.ModeloComboCargos;
import autores.modelos.ModeloTablaProfesores;
import autores.modelos.Profesor;
import autores.vistas.VentanaAMProfesor;
import interfaces.IControladorAMProfesor;
import interfaces.IGestorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import publicaciones.controladores.ControladorAMPublicacion;
import publicaciones.modelos.ModeloComboGrupos;

/**
 *
 * @author Usuario
 */
public class ControladorAMProfesor implements IControladorAMProfesor {

    private VentanaAMProfesor ventana;

    //INICIO PATRON SINGLETON.
    private static ControladorAMProfesor instanciador;  //Variable de clase

    private ControladorAMProfesor() {                   //Constructor privado.
        ventana = new VentanaAMProfesor(this);
    }

    public static ControladorAMProfesor instanciar() {  //Metodo de clase
        if (instanciador == null) {
            instanciador = new ControladorAMProfesor();
        }
        return instanciador;
    }
    //FIN PATRON SINGLETON.

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        //Capturo la excepcion con el bloque try/catch por si el usuario ingresa en el dni una letra.
        try {
            IGestorAutores ga = GestorAutores.instanciar();
            int dni;
            String apellidos = ventana.verTxtApellidos().getText().trim();
            String nombres = ventana.verTxtNombres().getText().trim();
            Cargo cargo = ((ModeloComboCargos) this.ventana.verComboCargos().getModel()).obtenerCargo();
            String clave = new String(ventana.verTxtClave().getPassword());
            String claveRepetida = new String(ventana.verTxtClaveRepetida().getPassword());
            String mensaje;

            //creo una referencia a la ventana autores para poder usarla.
            ControladorVentanaAutores ca = ControladorVentanaAutores.instanciar();

            //Hago esto si se presiona en el boton "Nuevo"
            if (this.ventana.getTitle().equals("Nuevo Profesor")) {
                if (!this.ventana.verTxtDNI().getText().trim().isEmpty()) {
                    dni = Integer.parseInt(this.ventana.verTxtDNI().getText().trim());
                    if (!clave.equals(claveRepetida)) {
                        JOptionPane.showMessageDialog(ventana, "Las contraseñas no coinciden.");
                    } else {
                        mensaje = ga.nuevoAutor(dni, apellidos, nombres, cargo, clave, claveRepetida);
                        if (mensaje.equals("Ya existe un profesor con ese dni.")) {
                            JOptionPane.showMessageDialog(this.ventana, mensaje);
                        }
                        if (mensaje.equals("Los datos del profesor deben ser validos.")) {
                            JOptionPane.showMessageDialog(this.ventana, mensaje);
                        }
                        if (mensaje.equals("Profesor creado y guardado.")) {
                            JOptionPane.showMessageDialog(this.ventana, mensaje);
                            ca.verVentana().verTablaProfesor().setModel(new ModeloTablaProfesores()); //muestra los datos en la tabla.
                            ca.verVentana().verBtnBorrarProfesor().setEnabled(true); //una vez cargado un profesor habilita el boton borrar. 
                            ca.verVentana().verBtnModificarProfesor().setEnabled(true); //una vez cargado un profesor habilita el boton modificar.
                            this.limpiar(); //hago que los campos de txt de la ventana quedan vacios.
                            ventana.dispose(); //cierro la ventana.
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this.ventana, "Los datos del profesor deben ser validos.");
                }
            }

            //Hago esto si se presiona en el boton "Modificar"
            if (this.ventana.getTitle().equals("Modificar Profesor")) {
                JTable tablaProfesor = ca.verVentana().verTablaProfesor();
                int filaSeleccionada = tablaProfesor.getSelectedRow();
                int dniSeleccionado = Integer.parseInt(tablaProfesor.getValueAt(filaSeleccionada, 0).toString());
                Profesor profesor = (Profesor) ga.verAutor(dniSeleccionado);

                if (!clave.equals(claveRepetida)) {
                    JOptionPane.showMessageDialog(ventana, "Las contraseñas no coinciden.");
                } else {
                    mensaje = ga.modificarAutor(profesor, apellidos, nombres, cargo, clave, claveRepetida);
                    if (mensaje.equals("Los datos a modificar deben ser validos.")) {
                        JOptionPane.showMessageDialog(this.ventana, mensaje);
                    }
                    if (mensaje.equals("Los datos se han modificado.")) {
                        JOptionPane.showMessageDialog(this.ventana, mensaje);
                        ca.verVentana().verTablaProfesor().setModel(new ModeloTablaProfesores()); //muestra los datos en la tabla.
                        this.limpiar(); //hago que los campos de txt de la ventana quedan vacios.
                        ventana.dispose(); //cierro la ventana.
                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this.ventana, "El documento debe ser un numero.");
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.limpiar();
        ventana.dispose();
    }

    @Override
    public void txtApellidosPresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar(); //toma la tecla presionada.
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verTxtApellidos().transferFocus();
        }
    }

    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verTxtNombres().transferFocus();
        }
    }

    @Override
    public void txtDocumentoPresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verTxtDNI().transferFocus();
        }
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verTxtClave().transferFocus();
        }
    }

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verBotonGuardar().doClick();
        }
    }

    public VentanaAMProfesor verVentana() { //Metodo auxiliar.
        return ventana;
    }

    //Metodo auxiliar para limpiar los campos de texto de las ventana "Nuevo/Modificar".
    public void limpiar() {
        JTextField txtDNI = ventana.verTxtDNI();
        JTextField txtApellidos = ventana.verTxtApellidos();
        JTextField txtNombres = ventana.verTxtNombres();
        JPasswordField passClave = ventana.verTxtClave();
        JPasswordField passClaveRepetida = ventana.verTxtClaveRepetida();

        txtDNI.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        passClave.setText("");
        passClaveRepetida.setText("");
    }

    //NUEVO PARA EL PARCIAL 2
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
