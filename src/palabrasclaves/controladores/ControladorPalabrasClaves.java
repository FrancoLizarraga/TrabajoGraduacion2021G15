/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.controladores;

import autores.modelos.Autor;
import interfaces.IControladorPalabrasClaves;
import interfaces.IGestorPalabrasClaves;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.ModeloTablaPlabarasClaves;
import palabrasclaves.modelos.PalabraClave;
import palabrasclaves.vistas.VentanaPalabrasClaves;

/**
 *
 * @author Usuario
 */
public class ControladorPalabrasClaves implements IControladorPalabrasClaves{
    private VentanaPalabrasClaves ventana;

    private static ControladorPalabrasClaves instanciador;

    private ControladorPalabrasClaves() {
        ventana = new VentanaPalabrasClaves(this);
    }

    public static ControladorPalabrasClaves instanciar() {
        if (instanciador == null) {
            instanciador = new ControladorPalabrasClaves();
        }
        return instanciador;
    }
    
    @Override
    public void btnNuevaClic(ActionEvent evt) {
        ControladorAPalabraClave controlador = ControladorAPalabraClave.instanciar();
        controlador.verVentana().setVisible(true);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        IGestorPalabrasClaves gestorPalabras = GestorPalabrasClaves.instanciar();
        int filaSeleccionada = this.ventana.verTablaPalabrasClaves().getSelectedRow();
        
        if (filaSeleccionada != -1) {
            int opcion = JOptionPane.showOptionDialog(ventana, CONFIRMACION, "Borrar Palabra Clave",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "No");
            if (opcion == JOptionPane.YES_OPTION) {
                PalabraClave palabra = (PalabraClave)this.ventana.verTablaPalabrasClaves().getValueAt(filaSeleccionada, 0);//obtengo la palabra clave
                gestorPalabras.borrarPalabraClave(palabra);

                this.ventana.verTablaPalabrasClaves().setModel(new ModeloTablaPlabarasClaves()); //muestra los datos en la tabla.
                JOptionPane.showMessageDialog(ventana, "La palabra clave ha sido borrada.");
            }
        } else {
            JOptionPane.showMessageDialog(ventana, "Para borrar una palabra clave primero debe seleccionarla.");
        }

        //Si el arrayList de palabrasclaves está vacio entonces deshabilita el boton de Borrar.
        if (gestorPalabras.verPalabrasClaves().isEmpty()) {
            this.ventana.verBtnBorrar().setEnabled(false);
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String filtro = this.ventana.verTxtNombre().getText().trim();
        if(filtro.isEmpty())
            this.ventana.verTablaPalabrasClaves().setModel(new ModeloTablaPlabarasClaves());
        else
            this.ventana.verTablaPalabrasClaves().setModel(new ModeloTablaPlabarasClaves(filtro));
    }
    
    //Sigo sin entender para qué es este método
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verBtnBuscar().doClick();
        }
    }

    public VentanaPalabrasClaves verVentana() {
        return ventana;
    }
    
    
}
