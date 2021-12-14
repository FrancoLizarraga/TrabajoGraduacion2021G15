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
import autores.modelos.ModeloTablaGruposAutor;
import autores.modelos.ModeloTablaProfesores;
import autores.modelos.Profesor;
import autores.vistas.VentanaAutores;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.ModeloTablaGrupos;
import interfaces.IControladorAutores;
import interfaces.IGestorAutores;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import publicaciones.modelos.GestorPublicaciones;

/**
 *
 * @author Usuario
 */
public class ControladorVentanaAutores implements IControladorAutores {

    private VentanaAutores ventana;

    //INICIO PATRON SINGLETON.
    private static ControladorVentanaAutores instanciador;

    private ControladorVentanaAutores() {
        ventana = new VentanaAutores(this);
    }

    public static ControladorVentanaAutores instanciar() {
        if (instanciador == null)
            instanciador = new ControladorVentanaAutores();
        return instanciador;
    }
    //FIN PATRON SINGLETON.

    @Override
    public void btnNuevoProfesorClic(ActionEvent evt) {
        ControladorAMProfesor cp = ControladorAMProfesor.instanciar();
        
        //ESTAS LINEAS SON NO MOSTRAR LA TABLA Y CONFIGURAR CÓMO QUIERO QUE APAREZCA LA VENTANA!!
        cp.verVentana().verLabelGrupos().setVisible(false); //Tomo el label "Grupos:" y la hago invisible.
        cp.verVentana().verScrollPane().setVisible(false);  //Tomo el scrollPane que contiene a la tabla y la hago invisible.
        cp.verVentana().setSize(500, 283);                  //Pongo el tamaño a la ventana, width: 500 && height: 283.
        cp.verVentana().setLocationRelativeTo(null);        //La centro a la ventana.
        //HASTA ACA
        
        cp.verVentana().setTitle(PROFESOR_NUEVO);
        cp.verVentana().verTxtDNI().setEnabled(true);
        cp.verVentana().setVisible(true);
        
        
    }

    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {
        ControladorAMAlumno ca = ControladorAMAlumno.instanciar();
        
        //ESTAS LINEAS SON NO MOSTRAR LA TABLA Y CONFIGURAR CÓMO QUIERO QUE APAREZCA LA VENTANA!!
        ca.verVentana().verLabelGrupos().setVisible(false); //Tomo el label "Grupos:" y la hago invisible.
        ca.verVentana().verScrollPane().setVisible(false);  //Tomo el scrollPane que contiene a la tabla y la hago invisible.
        ca.verVentana().setSize(500, 283);                  //Pongo el tamaño a la ventana, width: 500 && height: 283.
        ca.verVentana().setLocationRelativeTo(null);        //La centro a la ventana.
        //HASTA ACA
        ca.verVentana().setTitle(ALUMNO_NUEVO);
        ca.verVentana().verTxtDNI().setEnabled(true);
        ca.verVentana().setVisible(true);
    }

    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {
        ControladorAMProfesor cp = ControladorAMProfesor.instanciar(); //crea una instancia y muestra la ventana.
        if (this.ventana.verTablaProfesor().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(ventana, "Para modificar un profesor primero debe seleccionarlo.");
        } else {
            //ESTAS LINEAS SON MOSTRAR LA TABLA Y CONFIGURAR CÓMO QUIERO QUE APAREZCA LA VENTANA!!
            cp.verVentana().verLabelGrupos().setVisible(true); //Tomo el label "Grupos:" y la hago visible.
            cp.verVentana().verScrollPane().setVisible(true);  //Tomo el scrollPane que contiene a la tabla y la hago visible.
            cp.verVentana().setSize(500, 500);                 //Pongo el tamaño a la ventana, width: 500 && height: 500.
            cp.verVentana().setLocationRelativeTo(null);       //La centro a la ventana.
            //HASTA ACA!
            
            //ESTABLEZCO MODELO DE LA TABLA
            IGestorAutores ga = GestorAutores.instanciar();
            JTable tablaProfesor = this.ventana.verTablaProfesor();
            int filaSeleccionada = tablaProfesor.getSelectedRow(); //De la tabla profesor tomola fila que seleccioné.
            int dniSeleccionado = Integer.parseInt(tablaProfesor.getValueAt(filaSeleccionada, 0).toString()); //Tomo el dni del profesor seleccionado para buscar los datos del profesor.
            Profesor profesor = (Profesor) ga.verAutor(dniSeleccionado);
            cp.verVentana().verTablaGruposAutor().setModel(new ModeloTablaGruposAutor(profesor));
            //HASTA ACA!
            
            cp.verVentana().setTitle(PROFESOR_MODIFICAR); //le agrego el titulo
            cp.verVentana().setVisible(true); //la hago visible
            cp.verVentana().verTxtDNI().setEnabled(false); //Deshabilito el campo de txt de dni para no poder modificarlo.
        }
    }

    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {
        ControladorAMAlumno cp = ControladorAMAlumno.instanciar(); //crea una instancia y muestra la ventana.
        if (this.ventana.verTablaAlumno().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(ventana, "Para modificar un alumno primero debe seleccionarlo.");
        } else {
            //ESTAS LINEAS SON MOSTRAR LA TABLA Y CONFIGURAR CÓMO QUIERO QUE APAREZCA LA VENTANA!!
            cp.verVentana().verLabelGrupos().setVisible(true); //Tomo el label "Grupos:" y la hago visible.
            cp.verVentana().verScrollPane().setVisible(true);  //Tomo el scrollPane que contiene a la tabla y la hago visible.
            cp.verVentana().setSize(500, 500);                 //Pongo el tamaño a la ventana, width: 500 && height: 500.
            cp.verVentana().setLocationRelativeTo(null);       //La centro a la ventana.
            //HASTA ACA!
            
            //ESTABLEZCO MODELO DE LA TABLA
            IGestorAutores ga = GestorAutores.instanciar();
            JTable tablaAlumno = this.ventana.verTablaAlumno();
            int filaSeleccionada = tablaAlumno.getSelectedRow(); //De la tabla profesor tomola fila que seleccioné.
            int dniSeleccionado = Integer.parseInt(tablaAlumno.getValueAt(filaSeleccionada, 0).toString()); //Tomo el dni del profesor seleccionado para buscar los datos del profesor.
            Alumno alumno = (Alumno) ga.verAutor(dniSeleccionado);
            cp.verVentana().verTablaGruposAutor().setModel(new ModeloTablaGruposAutor(alumno));
            //HASTA ACA!
            cp.verVentana().setTitle(ALUMNO_MODIFICAR); //le agrego el titulo
            cp.verVentana().setVisible(true); //la hago visible
            cp.verVentana().verTxtDNI().setEnabled(false); //Deshabilito el campo de txt de dni para no poder modificarlo.
        }
    }

    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {
        GestorAutores ga = GestorAutores.instanciar();
        int filaSeleccionada = this.ventana.verTablaProfesor().getSelectedRow();

        if (filaSeleccionada != -1) {
            int opcion = JOptionPane.showOptionDialog(ventana, CONFIRMACION_PROFESOR, "Borrar profesor",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "No");
            if (opcion == JOptionPane.YES_OPTION) {
                int dni = Integer.parseInt(this.ventana.verTablaProfesor().getValueAt(filaSeleccionada, 0).toString());//obtengo el DNI de la tabla
                Autor profesor = ga.verAutor(dni);
                /*Veo si hay publicaciones con el autor para recien saber si lo borro o no.*/
                boolean mensaje = GestorPublicaciones.instanciar().hayPublicacionesConEsteAutor(profesor);
                if(!mensaje){
                    /*Quito al autor de los grupos a los cuales pertenece y luego lo borro al autor.*/
                    ga.quitarGrupos(profesor, profesor.devolverMiembros()); //Agregué este metodo en gestorAutores para borrar el autor.
                    ga.borrarAutor(profesor); //Agregué este metodo en gestorAutores para borrar el autor.
                    this.ventana.verTablaProfesor().setModel(new ModeloTablaProfesores()); //muestra los datos en la tabla.
                JOptionPane.showMessageDialog(ventana, "El profesor ha sido borrado.");
                }
                else{
                    JOptionPane.showMessageDialog(ventana, "No se pudo borrar el autor ya que hay publicaciones con el mismo.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(ventana, "Para borrar un profesor primero debe seleccionarlo.");
        }

        //Si el arrayList de profesores está vacio entonces deshabilita los botones de Borrar y Modificar.
        if (ga.verProfesores().isEmpty()) {
            this.ventana.verBtnBorrarProfesor().setEnabled(false);
            this.ventana.verBtnModificarProfesor().setEnabled(false);
        }
    }

    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {
        GestorAutores ga = GestorAutores.instanciar();
        int filaSeleccionada = this.ventana.verTablaAlumno().getSelectedRow();

        if (filaSeleccionada != -1) {
            int opcion = JOptionPane.showOptionDialog(ventana, CONFIRMACION_ALUMNO, "Borrar alumno",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "No");
            if (opcion == JOptionPane.YES_OPTION) {
                int dni = Integer.parseInt(this.ventana.verTablaAlumno().getValueAt(filaSeleccionada, 0).toString());//obtengo el DNI de la tabla
                Autor alumno = ga.verAutor(dni);
                /*Veo si hay publicaciones con el autor para recien saber si lo borro o no.*/
                boolean mensaje = GestorPublicaciones.instanciar().hayPublicacionesConEsteAutor(alumno);
                if(!mensaje){
                    /*Quito al autor de los grupos a los cuales pertenece y luego lo borro al autor.*/
                    ga.quitarGrupos(alumno, alumno.devolverMiembros()); //Agregué este metodo en gestorAutores para borrar el autor.
                    ga.borrarAutor(alumno); //Agregué este metodo en gestorAutores para borrar el autor.
                    this.ventana.verTablaAlumno().setModel(new ModeloTablaAlumnos()); //muestra los datos en la tabla.
                    JOptionPane.showMessageDialog(ventana, "El alumno ha sido borrado.");
                }
                else{
                    JOptionPane.showMessageDialog(ventana, "No se pudo borrar el autor ya que hay publicaciones con el mismo.");
                }
                
            }
        } else {
            JOptionPane.showMessageDialog(ventana, "Para borrar un alumno primero debe seleccionarlo.");
        }

        //Si el arrayList de profesores está vacio entonces deshabilita los botones de Borrar y Modificar.
        if (ga.verAlumnos().isEmpty()) {
            this.ventana.verBtnBorrarAlumno().setEnabled(false);
            this.ventana.verBtnModificarAlumno().setEnabled(false);
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

        if (!apellidos.isEmpty()) {
            for (Profesor p : ga.verProfesores()) {
                if (p.verApellidos().toLowerCase().contains(apellidos.toLowerCase())) {
                    if (p.verApellidos().toLowerCase().compareTo(apellidos.toLowerCase()) >= 0) {
                        apellidosIguales.add(p);
                    }
                }
            }

            //MUESTRA LOS PROFESORES QUE TIENEN EL APELLIDO INGRESADO EN EL CAMPO DE TEXTO.
            this.ventana.verTablaProfesor().setModel(new ModeloTablaProfesores(apellidosIguales));
        } else {
            this.ventana.verTablaProfesor().setModel(new ModeloTablaProfesores());
        }
    }

    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {
        GestorAutores ga = GestorAutores.instanciar();
        String apellidos = this.ventana.verTxtApellidosAlumno().getText().trim();
        ArrayList<Alumno> apellidosIguales = new ArrayList<>();

        if (!apellidos.isEmpty()) {
            for (Alumno a : ga.verAlumnos()) {
                if (a.verApellidos().toLowerCase().contains(apellidos.toLowerCase())) {
                    if (a.verApellidos().toLowerCase().compareTo(apellidos.toLowerCase()) >= 0) {
                        apellidosIguales.add(a);
                    }
                }
            }

            //MUESTRA LOS PROFESORES QUE TIENEN EL APELLIDO INGRESADO EN EL CAMPO DE TEXTO.
            this.ventana.verTablaAlumno().setModel(new ModeloTablaAlumnos(apellidosIguales));
        } else {
            this.ventana.verTablaAlumno().setModel(new ModeloTablaAlumnos());
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        //FALTA ESTE METODO
        //NO SUPE QUÉ HACER EN ESTE...
    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verBtnBuscarProfesor().doClick();
        }
    }

    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verBtnBuscarAlumno().doClick();
        }
    }

    public VentanaAutores verVentana() {
        return ventana;
    }

}
