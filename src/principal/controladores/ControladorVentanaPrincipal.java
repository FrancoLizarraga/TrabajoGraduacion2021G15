/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.controladores.ControladorVentanaAutores;
import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author Usuario
 */
public class ControladorVentanaPrincipal implements IControladorPrincipal {

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
    public void btnAutoresClic(ActionEvent evt) {
        ControladorVentanaAutores ca = ControladorVentanaAutores.instanciar();
        ca.verVentana().setVisible(true); //HAGO QUE SI ABRE MAS DE UNA VEZ, SE VUELVA A MOSTRAR.
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int opcion = JOptionPane.showOptionDialog(ventana, CONFIRMACION, "Salir",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sí", "No"}, "No");
        if (opcion == JOptionPane.YES_OPTION) {
            this.ventana.dispose();
        }
    }

}
