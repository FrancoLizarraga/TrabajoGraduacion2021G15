/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import static interfaces.IControladorPrincipal.CONFIRMACION;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import palabrasclaves.controladores.ControladorPalabrasClaves;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author Usuario
 */
public class ControladorVentanaPrincipal implements IControladorPrincipal{
    private IControladorPrincipal controlador;
    private VentanaPrincipal ventana;

    private static ControladorVentanaPrincipal instanciador;

    private ControladorVentanaPrincipal() {
        ventana = new VentanaPrincipal(this);
    }

    public static ControladorVentanaPrincipal instanciar() {
        if (instanciador == null) {
            instanciador = new ControladorVentanaPrincipal();
        }
        return instanciador;
    }

    @Override
    public void btnPalabrasClavesClic(ActionEvent evt) {
        ControladorPalabrasClaves controlador=ControladorPalabrasClaves.instanciar();
        controlador.verVentana().setVisible(true);
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int opcion = JOptionPane.showOptionDialog(ventana, CONFIRMACION, "Salir",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "No");
        if (opcion == JOptionPane.YES_OPTION) {
            this.ventana.dispose();
        }
    }

    public VentanaPrincipal verVentana() {
        return ventana;
    }
    
    
}
