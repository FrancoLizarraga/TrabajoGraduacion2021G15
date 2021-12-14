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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.ModeloComboGrupos;
import publicaciones.modelos.ModeloTablaPalabrasClaves;
import publicaciones.modelos.ModeloTablaPublicaciones;
import publicaciones.modelos.Publicacion;
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
        try {
            ControladorAMPublicacion camp = ControladorAMPublicacion.instanciar();
            //Cada vez que haga clic en Nueva vuelve a buscar si hay un NUEVO PRIMER profesor para mostrar 
            //los grupos a los que peretenece ese PRIMER profesor ordenado alfabeticamente.
            camp.verVentana().verComboGrupos().setModel(new ModeloComboGrupos());

            /*Este bloque de código quita la selección de las filas en caso de que se haya creado una anteriormente.*/
            JTable tabla = camp.verVentana().verTablaPalabrasClaves();
            ModeloTablaPalabrasClaves mtpc = (ModeloTablaPalabrasClaves)tabla.getModel();
            ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
            modeloSeleccion.clearSelection();
            /*Hasta acá.*/
            camp.verVentana().setTitle(IControladorAMPublicacion.TITULO_NUEVA);
            camp.verVentana().verTxtTitulo().setEnabled(true); //HABILITO EL CAMPO DE TEXTO DE TITULO.
            camp.verVentana().setVisible(true); //HAGO QUE SI ABRE MAS DE UNA VEZ, SE VUELVA A MOSTRAR.
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(ventana, "Antes de crear una publicación debe crear al menos un Profesor.");
        }
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        ControladorAMPublicacion camp = ControladorAMPublicacion.instanciar();
        //Cada vez que haga clic en Modificar vuelve a buscar si hay un NUEVO PRIMER profesor para mostrar 
        //los grupos a los que peretenece ese PRIMER profesor ordenado alfabeticamente.
        camp.verVentana().verComboGrupos().setModel(new ModeloComboGrupos());
        
        if(this.verVentana().verTablaPublicaciones().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(ventana, "Para modificar una publicación primero debe seleccionarla.");
        }
        else{
            /*Este bloque de codigo es para dejar en el campo de texto el titulo de la publicación que se va a modificar*/
            JTable tablaPublicaciones = this.verVentana().verTablaPublicaciones();
            int filaSeleccionada = tablaPublicaciones.getSelectedRow();
            String tituloSeleccionado = tablaPublicaciones.getValueAt(filaSeleccionada, 0).toString();
            JTextField txtTitulo = camp.verVentana().verTxtTitulo();
            txtTitulo.setText(tituloSeleccionado);
            /*Hasta acá.*/
            
            /*Para seleccionar las palabras claves que tiene esta publicación*/
            GestorPublicaciones gestor = GestorPublicaciones.instanciar();
            JTable tabla = camp.verVentana().verTablaPalabrasClaves();
            ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
            ModeloTablaPalabrasClaves modeloTabla = (ModeloTablaPalabrasClaves)tabla.getModel();
            for(PalabraClave palabraClave : gestor.verPublicacion(tituloSeleccionado).verPalabrasClaves()) {
                for(int fila = 0; fila < modeloTabla.getRowCount(); fila++) {
                    PalabraClave pc = modeloTabla.verPalabraClave(fila);
                    if (palabraClave.equals(pc)) {
                        modeloSeleccion.addSelectionInterval(fila, fila);
                        break;
                    }
                }
            }
            /*Hasta acá*/
            
            camp.verVentana().setTitle(IControladorPublicaciones.PUBLICACION_MODIFICAR);
            camp.verVentana().verTxtTitulo().setEnabled(false);
            camp.verVentana().setVisible(true);
            
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        GestorPublicaciones gestor = GestorPublicaciones.instanciar();
         int filaSeleccionada = this.ventana.verTablaPublicaciones().getSelectedRow();

        if (filaSeleccionada != -1) {
            int opcion = JOptionPane.showOptionDialog(ventana, CONFIRMACION, "Borrar Publicación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "No");
            if (opcion == JOptionPane.YES_OPTION) {
                String titulo = this.ventana.verTablaPublicaciones().getValueAt(filaSeleccionada, 0).toString();//obtengo el TITULO de la publicacion desde la tabla.
                Publicacion publicacion = gestor.verPublicacion(titulo);
                gestor.borrarPublicacion(publicacion);
                this.ventana.verTablaPublicaciones().setModel(new ModeloTablaPublicaciones()); //muestra los datos en la tabla.
                JOptionPane.showMessageDialog(ventana, "La publicación ha sido borrada.");
            }
        } else {
            JOptionPane.showMessageDialog(ventana, "Para borrar una publicación primero debe seleccionarla.");
        }

        //Si el arrayList de publicaciones está vacio entonces deshabilita los botones de Borrar y Modificar.
        if (gestor.verPublicaciones().isEmpty()) {
            this.ventana.verBtnBorrar().setEnabled(false);
            this.ventana.verBtnModificar().setEnabled(false);
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        GestorPublicaciones gestor = GestorPublicaciones.instanciar();
        String titulo = this.ventana.verTxtTitulo().getText().trim();
        List<Publicacion> publicacionesIguales = new ArrayList<>();

        if (!titulo.isEmpty()) {
            publicacionesIguales = gestor.buscarPublicaciones(titulo);
            //MUESTRA EN LA TABLA LAS PUBLICACIONES QUE TIENEN EL TITULO INGRESADO EN EL CAMPO DE TEXTO.
            this.ventana.verTablaPublicaciones().setModel(new ModeloTablaPublicaciones(publicacionesIguales));
        } else {
            this.ventana.verTablaPublicaciones().setModel(new ModeloTablaPublicaciones());
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        //FALTA ESTE METODO
        //NO SUPE QUÉ HACER EN ESTE...
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verBtnBuscar().doClick();
        }
    }

    public VentanaPublicaciones verVentana() {
        return ventana;
    }
}
