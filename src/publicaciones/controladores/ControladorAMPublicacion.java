/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.controladores;

import grupos.modelos.Grupo;
import idiomas.modelos.Idioma;
import interfaces.IControladorAMPublicacion;
import interfaces.IControladorPrincipal;
import interfaces.IGestorPublicaciones;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import lugares.modelos.Lugar;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.ModeloComboGrupos;
import publicaciones.modelos.ModeloComboIdiomas;
import publicaciones.modelos.ModeloComboLugares;
import publicaciones.modelos.ModeloComboTipos;
import publicaciones.vistas.VentanaAMPublicacion;
import tipos.modelos.Tipo;

/**
 *
 * @author Usuario
 */
public class ControladorAMPublicacion implements IControladorAMPublicacion{
    private VentanaAMPublicacion ventana;
    
    //INICIO PATRON SINGLETON.
    private static ControladorAMPublicacion instanciador;

    private ControladorAMPublicacion() {
        ventana = new VentanaAMPublicacion(this);
    }

    public static ControladorAMPublicacion instanciar() {
        if (instanciador == null)
            instanciador = new ControladorAMPublicacion();
        return instanciador;
    }
    //FIN PATRON SINGLETON.

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        IGestorPublicaciones gestor = GestorPublicaciones.instanciar();
        
        String titulo = ventana.verTxtTitulo().getText().trim();
        String enlace = ventana.verTxtEnlace().getText().trim();
        Tipo tipo =((ModeloComboTipos) ventana.verComboTipos().getModel()).obtenerTipo();
        Idioma idioma = ((ModeloComboIdiomas) ventana.verComboIdiomas().getModel()).obtenerIdioma();
        Lugar lugar = ((ModeloComboLugares) ventana.verComboLugares().getModel()).obtenerLugar();
        Grupo grupo = ((ModeloComboGrupos) ventana.verComboGrupos().getModel()).obtenerGrupo();
//        String mensaje= gestor.nuevaPublicacion(titulo, grupo.vermiembroEnGrupo, LocalDate.EPOCH, tipo, idioma, lugar, palabrasClaves, enlace, enlace);
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnTodasLasPalabrasClavesClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnNingunaPalabraClaveClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btnAbrirClic(ActionEvent evt) {
        //Se ponen en español los nombres de los botones de la ventana de diálogo
        UIManager.put("FileChooser.openButtonText","Abrir");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText","Cancelar");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        UIManager.put("FileChooser.lookInLabelText", "Buscar en:");
        UIManager.put("FileChooser.fileNameLabelText", "Archivo:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Archivos del tipo:");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir un nivel");
        UIManager.put("FileChooser.homeFolderToolTipText", "Inicio");
        UIManager.put("FileChooser.newFolderToolTipText", "Carpeta nueva");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
        
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File(System.getProperty("user.home")));
        //se establece la carpeta personal del usuario para empezar la búsqueda
        selector.setDialogTitle(IControladorPrincipal.TITULO);
        selector.setAcceptAllFileFilterUsed(false); //no se muestra el filtro de todos los archivos
        
        int resultado = selector.showOpenDialog(null);
        
        if (resultado == JFileChooser.APPROVE_OPTION) { //se selecciona un archivo
            File selectedFile = selector.getSelectedFile();
            this.ventana.verTxtEnlace().setText(selectedFile.getAbsolutePath());
        }  
    }

    public VentanaAMPublicacion verVentana() {
        return ventana;
    }
    
}
