/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.controladores;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.ModeloTablaGrupos;
import grupos.modelos.ModeloTablaModificarMiembros;
import grupos.vistas.VentanaAMGrupo;
import interfaces.IControladorAMGrupo;
import interfaces.IControladorGrupos;
import interfaces.IGestorGrupos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Usuario
 */
public class ControladorAMGrupo implements IControladorAMGrupo{
    private IControladorGrupos controlador;
    private VentanaAMGrupo ventana;
    
    private static ControladorAMGrupo instanciador;

    private ControladorAMGrupo() {
        ventana = new VentanaAMGrupo(this);
    }

    public static ControladorAMGrupo instanciar() {
        if (instanciador == null) {
            instanciador = new ControladorAMGrupo();
        }
        return instanciador;
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        IGestorGrupos gestorGrupos = GestorGrupos.instanciar();
        String nombre = this.ventana.verTxtNombre().getText().trim();
        String descripcion = this.ventana.verTxtDescripcion().getText().trim();
        String mensaje;
        
        //creo una referencia a la ventana grupos para poder usarla.
        ControladorGrupos cg = ControladorGrupos.instanciar();
        
        //Hago esto si se presiona en el boton "Nuevo"
        if(this.ventana.getTitle().equals(TITULO_NUEVO)){
            mensaje = gestorGrupos.nuevoGrupo(nombre, descripcion);
            if(mensaje.equals("El nombre del grupo debe ser una cadena no vacia.")){
                JOptionPane.showMessageDialog(this.ventana, mensaje);
            }
            if(mensaje.equals("Ya existe un grupo con ese nombre")){
                JOptionPane.showMessageDialog(this.ventana, mensaje);
            }
            if(mensaje.equals("Grupo creado y guardado")){
                JOptionPane.showMessageDialog(this.ventana, mensaje);
                cg.verVentana().verTablaGrupos().setModel(new ModeloTablaGrupos()); //muestra los datos en la tabla.
                cg.verVentana().verBtnBorrar().setEnabled(true); //una vez cargado un grupo habilita el boton borrar. 
                cg.verVentana().verBtnModificar().setEnabled(true); //una vez cargado un grupo habilita el boton modificar.
                this.limpiar(); //hago que los campos de txt de la ventana quedan vacios.
                ventana.dispose(); //cierro la ventana.
            }
        }
        
        //Hago esto si se presiona en el boton "Modificar"
        if(this.ventana.getTitle().equals(TITULO_MODIFICAR)){
            JTable tablaGrupos = cg.verVentana().verTablaGrupos();
            int filaSeleccionada = tablaGrupos.getSelectedRow();
            String nombreSeleccionado = tablaGrupos.getValueAt(filaSeleccionada, 0).toString();
            Grupo grupox = gestorGrupos.verGrupo(nombreSeleccionado);
            
            mensaje = gestorGrupos.modificarGrupo(grupox, descripcion);
            if(mensaje.equals("No hay ningun grupo con este nombre")){
                JOptionPane.showMessageDialog(this.ventana, mensaje);
            }else{
                JOptionPane.showMessageDialog(this.ventana, mensaje);
                cg.verVentana().verTablaGrupos().setModel(new ModeloTablaGrupos()); //muestra los datos en la tabla.
                this.limpiar(); //hago que los campos de txt de la ventana quedan vacios.
                ventana.dispose(); //cierro la ventana.
            }
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.limpiar();
        this.ventana.dispose();
    }

    @Override
    public void btnModificarMiembrosClic(ActionEvent evt) {
        ControladorModificarMiembros controlador = ControladorModificarMiembros.instanciar();
        //Creo una referencia a la ventana grupos para poder sacar el nombre del grupo y ponerlo de titulo en la ventana.
        ControladorGrupos cg = ControladorGrupos.instanciar();
        JTable tablaGrupos = cg.verVentana().verTablaGrupos();
        int filaSeleccionada = tablaGrupos.getSelectedRow();
        String nombreSeleccionado = tablaGrupos.getValueAt(filaSeleccionada, 0).toString();
        /*Busco el grupo que se seleccionó y le paso al constructor del modelo de la tabla*/
        Grupo grupoParaModificarMiembros = GestorGrupos.instanciar().verGrupo(nombreSeleccionado);
        controlador.auxiliar(grupoParaModificarMiembros);
        /*Hasta acá.*/
        
        /*Para seleccionar los miembros que pertenecen a este grupo*/
        JTable tabla = controlador.verVentana().verTablaModificar();
        ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
        ModeloTablaModificarMiembros modeloTabla = (ModeloTablaModificarMiembros)tabla.getModel();
        for(MiembroEnGrupo miembro : grupoParaModificarMiembros.verMiembros()) {
            for(int fila = 0; fila < modeloTabla.getRowCount(); fila++) {
                MiembroEnGrupo m = modeloTabla.verMiembroEnGrupo(fila);
                if (miembro.equals(m)) {
                    modeloSeleccion.addSelectionInterval(fila, fila);
                    break;
                }
            }
        }
        /*Hasta acá*/
        
        controlador.verVentana().setTitle(nombreSeleccionado);
        controlador.verVentana().setVisible(true);
        
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verLabelDescripcion().transferFocus();
        }
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verBtnGuardar().doClick();
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        //FALTA ESTE METODO
        //NO SUPE QUÉ HACER EN ESTE...
    }

    public VentanaAMGrupo verVentana() {
        return ventana;
    }
    
    //Metodo auxiliar para limpiar los campos de texto de las ventana "Nuevo/Modificar".
    public void limpiar() {
        JTextField txtNombre = ventana.verTxtNombre();
        JTextField txtDescripcion = ventana.verTxtDescripcion();

        txtNombre.setText("");
        txtDescripcion.setText("");
    }
}
