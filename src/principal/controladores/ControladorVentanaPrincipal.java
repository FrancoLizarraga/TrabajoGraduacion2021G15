/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.controladores.ControladorVentanaAutores;
import grupos.controladores.ControladorGrupos;
import interfaces.IControladorGrupos;
import interfaces.IControladorPrincipal;
import interfaces.IControladorPublicaciones;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import publicaciones.controladores.ControladorPublicaciones;

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

    @Override
    public void btnPalabrasClavesClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnLugaresClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnIdiomasClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnTiposClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnGruposClic(ActionEvent evt) {
        ControladorGrupos cg = ControladorGrupos.instanciar();
        cg.verVentana().setTitle(IControladorGrupos.TITULO);
        cg.verVentana().setVisible(true); //HAGO QUE SI ABRE MAS DE UNA VEZ, SE VUELVA A MOSTRAR.
    }

    @Override
    public void btnPublicacionesClic(ActionEvent evt) {
        ControladorPublicaciones cp = ControladorPublicaciones.instanciar();
        cp.verVentana().setTitle(IControladorPublicaciones.TITULO);
        cp.verVentana().setVisible(true); //HAGO QUE SI ABRE MAS DE UNA VEZ, SE VUELVA A MOSTRAR.
    }
    
    
}
