/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.controladores;

import interfaces.IControladorAPalabraClave;
import interfaces.IGestorPalabrasClaves;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.ModeloTablaPlabarasClaves;
import palabrasclaves.vistas.VentanaAPalabraClave;

/**
 *
 * @author Usuario
 */
public class ControladorAPalabraClave implements IControladorAPalabraClave{
    private VentanaAPalabraClave ventana;
    
    private static ControladorAPalabraClave instanciador;

    private ControladorAPalabraClave() {
        ventana = new VentanaAPalabraClave(this);
    }

    public static ControladorAPalabraClave instanciar() {
        if (instanciador == null) {
            instanciador = new ControladorAPalabraClave();
        }
        return instanciador;
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        IGestorPalabrasClaves gestor = GestorPalabrasClaves.instanciar();
        ControladorPalabrasClaves controladorPalabras = ControladorPalabrasClaves.instanciar();
        String nombre = this.ventana.verTxtNombre().getText().trim();
        String mensaje = gestor.nuevaPalabraClave(nombre); 
        JOptionPane.showMessageDialog(this.ventana,mensaje);
        this.clear(); //METODO PARA LIMPIAR EL CAMPO DE TEXTO.
        controladorPalabras.verVentana().verTablaPalabrasClaves().setModel(new ModeloTablaPlabarasClaves());
        controladorPalabras.verVentana().verBtnBorrar().setEnabled(true); //una vez que se crea al menos una palabra clave, se habilita el boton borrar.
        this.ventana.dispose();
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verBtnGuardar().doClick();
        }
    }

    public VentanaAPalabraClave verVentana() {
        return ventana;
    }
    
    public void clear(){
        this.ventana.verTxtNombre().setText("");
    }
}
