/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.controladores;

import autores.modelos.Alumno;
import autores.modelos.GestorAutores;
import autores.modelos.ModeloTablaAlumnos;
import autores.modelos.ModeloTablaProfesores;
import autores.modelos.Profesor;
import autores.vistas.VentanaAMAlumno;
import interfaces.IControladorAMAlumno;
import interfaces.IGestorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class ControladorAMAlumno implements IControladorAMAlumno {

    private VentanaAMAlumno ventana;

    //INICIO PATRON SINGLETON..
    private static ControladorAMAlumno instanciador;  //Variable de clase

    private ControladorAMAlumno() {                   //Constructor privado.
        ventana = new VentanaAMAlumno(this);
    }

    public static ControladorAMAlumno instanciar() {  //Metodo de clase
        if (instanciador == null) {
            instanciador = new ControladorAMAlumno();
        }
        return instanciador;
    }
    //FIN PATRON SINGLETON.

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        try {
            IGestorAutores ga = GestorAutores.instanciar();
            int dni;
            String apellidos = ventana.verTxtApellidos().getText().trim();
            String nombres = ventana.verTxtNombres().getText().trim();
            String cx = this.ventana.verTxtCX().getText().trim();
            String clave = new String(ventana.verTxtClave().getPassword());
            String claveRepetida = new String(ventana.verTxtClaveRepetida().getPassword());
            String mensaje;

            //creo una referencia a la ventana autores para poder usarla.
            ControladorVentanaAutores ca = ControladorVentanaAutores.instanciar();

            //Hago esto si se presiona en el boton "Nuevo"
            if (this.ventana.getTitle().equals("Nuevo Alumno")) {
                if (!this.ventana.verTxtDNI().getText().trim().isEmpty()) {
                    dni = Integer.parseInt(this.ventana.verTxtDNI().getText().trim());
                    if (!clave.equals(claveRepetida)) {
                        JOptionPane.showMessageDialog(ventana, "Las contraseñas no coinciden.");
                    } else {
                        mensaje = ga.nuevoAutor(dni, apellidos, nombres, cx, clave, claveRepetida);
                        if (mensaje.equals("Ya existe un alumno con ese dni o cx.")) {
                            JOptionPane.showMessageDialog(this.ventana, mensaje);
                        }
                        if (mensaje.equals("Los datos del alumno deben ser validos.")) {
                            JOptionPane.showMessageDialog(this.ventana, mensaje);
                        }
                        if (mensaje.equals("Alumno creado y guardado.")) {
                            JOptionPane.showMessageDialog(this.ventana, mensaje);
                            ca.verVentana().verTablaAlumno().setModel(new ModeloTablaAlumnos()); //muestra los datos en la tabla.
                            ca.verVentana().verBtnBorrarAlumno().setEnabled(true); //una vez cargado un alumno habilita el boton borrar. 
                            ca.verVentana().verBtnModificarAlumno().setEnabled(true); //una vez cargado un alumno habilita el boton modificar.
                            this.limpiar(); //hago que los campos de txt de la ventana quedan vacios.
                            ventana.dispose(); //cierro la ventana.
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this.ventana, "Los datos del alumno deben ser validos.");
                }
            }

            //Hago esto si se presiona en el boton "Modificar"
            if (this.ventana.getTitle().equals("Modificar Alumno")) {
                JTable tablaAlumno = ca.verVentana().verTablaAlumno();
                int filaSeleccionada = tablaAlumno.getSelectedRow();
                int dniSeleccionado = Integer.parseInt(tablaAlumno.getValueAt(filaSeleccionada, 0).toString());
                Alumno alumno = (Alumno) ga.verAutor(dniSeleccionado);

                if (!clave.equals(claveRepetida)) {
                    JOptionPane.showMessageDialog(ventana, "Las contraseñas no coinciden.");
                } else {
                    mensaje = ga.modificarAutor(alumno, apellidos, nombres, cx, clave, claveRepetida);
                    if (mensaje.equals("Los datos a modificar deben ser validos.")) {
                        JOptionPane.showMessageDialog(this.ventana, mensaje);
                    }
                    if(mensaje.equals("El cx ingresado ya se encuentra registrado.")){
                        JOptionPane.showMessageDialog(this.ventana, mensaje);
                    }
                    if (mensaje.equals("Los datos se han modificado.")) {
                        JOptionPane.showMessageDialog(this.ventana, mensaje);
                        ca.verVentana().verTablaAlumno().setModel(new ModeloTablaAlumnos()); //muestra los datos en la tabla.
                        this.limpiar(); //hago que los campos de txt de la ventana quedan vacios.
                        ventana.dispose(); //cierro la ventana.
                    }
                }
            }  
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this.ventana, "El documento debe ser un numero.");
        }
//        IGestorAutores ga = GestorAutores.instanciar();
//        int dni;
//        String apellidos = ventana.verTxtApellidos().getText().trim();
//        String nombres = ventana.verTxtNombres().getText().trim();
//        String cx = this.ventana.verTxtCX().getText().trim();
//        String clave = new String(ventana.verTxtClave().getPassword());
//        String claveRepetida = new String(ventana.verTxtClaveRepetida().getPassword());
//        String mensaje;
//
//        //creo una referencia a la ventana autores para poder usarla.
//        ControladorVentanaAutores ca = ControladorVentanaAutores.instanciar();
//
//        //Hago esto si se presiona en el boton "Nuevo"
//        if (this.ventana.getTitle().equals("Nuevo Alumno")) {
//            if (!this.ventana.verTxtDNI().getText().trim().isEmpty()) {
//                dni = Integer.parseInt(this.ventana.verTxtDNI().getText().trim());
//                if (!clave.equals(claveRepetida)) {
//                    JOptionPane.showMessageDialog(ventana, "Las contraseñas no coinciden.");
//                } else {
//                    mensaje = ga.nuevoAutor(dni, apellidos, nombres, cx, clave, claveRepetida);
//                    if (mensaje.equals("Ya existe un alumno con ese dni o cx.")) {
//                        JOptionPane.showMessageDialog(this.ventana, mensaje);
//                    }
//                    if (mensaje.equals("Los datos del alumno deben ser validos.")) {
//                        JOptionPane.showMessageDialog(this.ventana, mensaje);
//                    }
//                    if (mensaje.equals("Alumno creado y guardado.")) {
//                        JOptionPane.showMessageDialog(this.ventana, mensaje);
//                        ca.verVentana().verTablaAlumno().setModel(new ModeloTablaAlumnos()); //muestra los datos en la tabla.
//                        ca.verVentana().verBtnBorrarAlumno().setEnabled(true); //una vez cargado un alumno habilita el boton borrar. 
//                        ca.verVentana().verBtnModificarAlumno().setEnabled(true); //una vez cargado un alumno habilita el boton modificar.
//                        this.limpiar(); //hago que los campos de txt de la ventana quedan vacios.
//                        ventana.dispose(); //cierro la ventana.
//                    }
//                }
//            } else {
//                JOptionPane.showMessageDialog(this.ventana, "Los datos del alumno deben ser validos.");
//            }
//        }
//
//        //Hago esto si se presiona en el boton "Modificar"
//        if (this.ventana.getTitle().equals("Modificar Alumno")) {
//            JTable tablaAlumno = ca.verVentana().verTablaAlumno();
//            int filaSeleccionada = tablaAlumno.getSelectedRow();
//            int dniSeleccionado = Integer.parseInt(tablaAlumno.getValueAt(filaSeleccionada, 0).toString());
//            Alumno alumno = (Alumno) ga.verAutor(dniSeleccionado);
//
//            if (!clave.equals(claveRepetida)) {
//                JOptionPane.showMessageDialog(ventana, "Las contraseñas no coinciden.");
//            } else {
//                mensaje = ga.modificarAutor(alumno, apellidos, nombres, cx, clave, claveRepetida);
//                if (mensaje.equals("Los datos a modificar deben ser validos.")) {
//                    JOptionPane.showMessageDialog(this.ventana, mensaje);
//                }
//                if (mensaje.equals("Los datos se han modificado.")) {
//                    JOptionPane.showMessageDialog(this.ventana, mensaje);
//                    ca.verVentana().verTablaAlumno().setModel(new ModeloTablaAlumnos()); //muestra los datos en la tabla.
//                    this.limpiar(); //hago que los campos de txt de la ventana quedan vacios.
//                    ventana.dispose(); //cierro la ventana.
//                }
//            }
//        }
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
    public void txtCXPresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verTxtCX().transferFocus();
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

    public VentanaAMAlumno verVentana() { //Metodo auxiliar
        return ventana;
    }

    //Metodo auxiliar para limpiar los campos de texto de las ventana "Nuevo/Modificar".
    public void limpiar() {
        JTextField txtDNI = ventana.verTxtDNI();
        JTextField txtApellidos = ventana.verTxtApellidos();
        JTextField txtNombres = ventana.verTxtNombres();
        JTextField txtCX = ventana.verTxtCX();
        JPasswordField passClave = ventana.verTxtClave();
        JPasswordField passClaveRepetida = ventana.verTxtClaveRepetida();

        txtDNI.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtCX.setText("");
        passClave.setText("");
        passClaveRepetida.setText("");
    }

}
