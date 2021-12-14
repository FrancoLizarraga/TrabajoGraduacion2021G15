/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.controladores;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.ModeloTablaAMGrupo;
import grupos.modelos.ModeloTablaGrupos;
import grupos.vistas.VentanaGrupos;
import interfaces.IControladorAMGrupo;
import interfaces.IControladorGrupos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class ControladorGrupos implements IControladorGrupos{
    private IControladorGrupos controlador;
    private VentanaGrupos ventana;
    
    private static ControladorGrupos instanciador;

    private ControladorGrupos() {
        ventana = new VentanaGrupos(this);
    }

    public static ControladorGrupos instanciar() {
        if (instanciador == null) {
            instanciador = new ControladorGrupos();
        }
        return instanciador;
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        ControladorAMGrupo cg = ControladorAMGrupo.instanciar();
        cg.verVentana().verTablaAMGrupo().setVisible(false); ////Para que se muestren los datos en la tabla.
        cg.verVentana().setTitle(IControladorAMGrupo.TITULO_NUEVO);
        cg.verVentana().verBtnModificarMiembros().setEnabled(false);
        cg.verVentana().verTxtNombre().setEnabled(true);
        cg.verVentana().setVisible(true);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        ControladorAMGrupo cg = ControladorAMGrupo.instanciar();
        GestorGrupos gestor = GestorGrupos.instanciar();
        if(this.verVentana().verTablaGrupos().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(ventana, "Para modificar un grupo primero debe seleccionarlo.");
        }
        else{
            /*Este bloque de codigo es para dejar en el campo de texto el nombre del grupo que se va a modificar*/
            JTable tablaGrupos = this.verVentana().verTablaGrupos();
            int filaSeleccionada = tablaGrupos.getSelectedRow();
            String nombreSeleccionado = tablaGrupos.getValueAt(filaSeleccionada, 0).toString();
            JTextField txtNombre = cg.verVentana().verTxtNombre();
            txtNombre.setText(nombreSeleccionado);
                //Voy a dejar la descripción también.
            String descripcionSeleccionada = tablaGrupos.getValueAt(filaSeleccionada, 1).toString();
            JTextField txtDescripcion = cg.verVentana().verTxtDescripcion();
            txtDescripcion.setText(descripcionSeleccionada);
            /*Hasta acá.*/
            /*Le doy el modelo de la tabla para ver los miembros del grupo seleccionado.*/
            cg.verVentana().verTablaAMGrupo().setModel(new ModeloTablaAMGrupo(gestor.verGrupo(nombreSeleccionado)));
            cg.verVentana().verTablaAMGrupo().setVisible(true); //Para que se muestren los datos en la tabla.
            
            cg.verVentana().setTitle(IControladorAMGrupo.TITULO_MODIFICAR);
            cg.verVentana().verTxtNombre().setEnabled(false);
            cg.verVentana().verBtnModificarMiembros().setEnabled(true);
            cg.verVentana().setVisible(true);
            
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        GestorGrupos gestor = GestorGrupos.instanciar();
        int filaSeleccionada = this.ventana.verTablaGrupos().getSelectedRow();

        if (filaSeleccionada != -1) {
            int opcion = JOptionPane.showOptionDialog(ventana, CONFIRMACION, "Borrar Grupo",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "No");
            if (opcion == JOptionPane.YES_OPTION) {
                String nombre = this.ventana.verTablaGrupos().getValueAt(filaSeleccionada, 0).toString();//obtengo de la tabla el NOMBRE del grupo.
                Grupo grupo = gestor.verGrupo(nombre);
                String mensaje = gestor.borrarGrupo(grupo);
                if(mensaje.equals("No se pudo borrar el grupo ya que hay autores con el mismo.")){
                    JOptionPane.showMessageDialog(ventana, mensaje);
                }
                else{
                    this.ventana.verTablaGrupos().setModel(new ModeloTablaGrupos()); //Refresca los datos en la tabla.
                    JOptionPane.showMessageDialog(ventana, "El grupo ha sido borrado.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(ventana, "Para borrar un grupo primero debe seleccionarlo.");
        }

        //Si el arrayList de grupos está vacío entonces deshabilita los botones de Borrar y Modificar.
        if (gestor.verGrupos().isEmpty()) {
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
        GestorGrupos gestor = GestorGrupos.instanciar();
        String nombre = this.ventana.verTxtNombre().getText().trim();
        List<Grupo> gruposIguales = new ArrayList<>();

        if (!nombre.isEmpty()) {
            gruposIguales = gestor.buscarGrupos(nombre);
            //MUESTRA LOS GRUPOS QUE TIENEN EL NOMBRE INGRESADO EN EL CAMPO DE TEXTO.
            this.ventana.verTablaGrupos().setModel(new ModeloTablaGrupos(gruposIguales));
        } else {
            this.ventana.verTablaGrupos().setModel(new ModeloTablaGrupos());
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        //FALTA ESTE METODO
        //NO SUPE QUÉ HACER EN ESTE...
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verBtnBuscar().doClick();
        }
    }

    public VentanaGrupos verVentana() {
        return ventana;
    }
    
    
}
