/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.controladores;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.ModeloTablaGrupos;
import idiomas.modelos.Idioma;
import interfaces.IControladorAMPublicacion;
import interfaces.IControladorPrincipal;
import interfaces.IControladorPublicaciones;
import interfaces.IGestorPublicaciones;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableModel;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.ModeloComboGrupos;
import publicaciones.modelos.ModeloComboIdiomas;
import publicaciones.modelos.ModeloComboLugares;
import publicaciones.modelos.ModeloComboTipos;
import publicaciones.modelos.ModeloTablaPalabrasClaves;
import publicaciones.modelos.ModeloTablaPublicaciones;
import publicaciones.modelos.Publicacion;
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
        GestorPublicaciones gestor = GestorPublicaciones.instanciar();
        ControladorPublicaciones cp = ControladorPublicaciones.instanciar(); //Para actualizar los datos de la tabla,etc.
        GestorAutores ga = GestorAutores.instanciar(); //Para ver los grupos del primer autor.
        //Hago un bloque try/catch para asegurrme que ingrese una fecha válida y, si no lo hace
        //O asegurar que le asigne al menos un grupo al profesor logueado.
        try {
            JTable tabla = this.ventana.verTablaPalabrasClaves();
            String titulo = ventana.verTxtTitulo().getText().trim();
            String enlace = ventana.verTxtEnlace().getText().trim();
            String resumen = ventana.verTxtResumen().getText().trim();
            Tipo tipo =((ModeloComboTipos) ventana.verComboTipos().getModel()).obtenerTipo();
            Idioma idioma = ((ModeloComboIdiomas) ventana.verComboIdiomas().getModel()).obtenerIdioma();
            Lugar lugar = ((ModeloComboLugares) ventana.verComboLugares().getModel()).obtenerLugar();
            Grupo grupo = ((ModeloComboGrupos) ventana.verComboGrupos().getModel()).obtenerGrupo();
            String mensaje;

            /*Lee la fecha indicada.*/
            Date d = ventana.verDateChooser().getCalendar().getTime(); //dateChooser es el nombre del componente JDateChooser
            LocalDate fechaPublicacion = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            /*Hasta acá.*/

            /*Tomo las palabras claves seleccionadas en la tabla.*/
            int[] filasSeleccionadas = tabla.getSelectedRows();
            List<PalabraClave> palabrasClaves = GestorPalabrasClaves.instanciar().verPalabrasClaves();
            List<PalabraClave> palabrasClavesSeleccionadas = new ArrayList<>();
            for (int i = 0; i < filasSeleccionadas.length; i++) {
                //Carga la Lista con las palabras claves seleccionadas en la tabla.
                palabrasClavesSeleccionadas.add(palabrasClaves.get(filasSeleccionadas[i])); 
            }
            /*Hasta acá.*/

            /*Busco el primer profesor para tomarlo como autor en MiembroEnGrupo.*/
            Autor primerProfesor  = ga.verProfesores().get(0);
            String nombreProfesor = (primerProfesor.verApellidos()+ ", " + primerProfesor.verNombres());
            MiembroEnGrupo miembro = new MiembroEnGrupo(primerProfesor, grupo, primerProfesor.verRol(primerProfesor));
            /*Hasta acá.*/

            //Hago esto si se presiona en el boton "Nuevo"
            if(this.ventana.getTitle().equals(TITULO_NUEVA + " - " + nombreProfesor)){
                mensaje= gestor.nuevaPublicacion(titulo, miembro, fechaPublicacion, tipo, idioma, lugar,
                        palabrasClavesSeleccionadas, enlace, resumen);
                if(mensaje.equals("Los datos de la publicación deben ser validos.")){
                    JOptionPane.showMessageDialog(this.ventana, mensaje);
                }
                if(mensaje.equals("Ya existe una publicación con este titulo.")){
                    JOptionPane.showMessageDialog(this.ventana, mensaje);
                }
                if(mensaje.equals("Publicación creada y guardada.")){
                    JOptionPane.showMessageDialog(this.ventana, mensaje);
                    cp.verVentana().verTablaPublicaciones().setModel(new ModeloTablaPublicaciones()); //muestra los datos en la tabla.
                    cp.verVentana().verBtnBorrar().setEnabled(true); //una vez cargado una publicacion habilita el boton borrar. 
                    cp.verVentana().verBtnModificar().setEnabled(true); //una vez cargada una publicacion habilita el boton modificar.
                    this.limpiar(); //hago que los campos de txt de la ventana quedan vacios.
                    cp.verVentana().verBtnBorrar().setEnabled(true);
                    cp.verVentana().verBtnModificar().setEnabled(true);
                    ventana.dispose(); //cierro la ventana.
                }
            }
            //Hago esto si se presiona en el boton "Modificar"
            //Las interfaces no tienen escritas de igual manera el titulo "Modificar Publicacion", comparo en minusc.
            String tituloVentanaModificar = (IControladorPublicaciones.PUBLICACION_MODIFICAR + " - " + nombreProfesor);
            if(this.ventana.getTitle().toLowerCase().equals(tituloVentanaModificar.toLowerCase())){
                JTable tablaPublicaciones = cp.verVentana().verTablaPublicaciones();
                int filaSeleccionada = tablaPublicaciones.getSelectedRow();
                String tituloSeleccionado = tablaPublicaciones.getValueAt(filaSeleccionada, 0).toString();
                Publicacion publicacion = gestor.verPublicacion(tituloSeleccionado);
                
                mensaje = gestor.modificarPublicacion(publicacion, miembro, fechaPublicacion, tipo, idioma, lugar, 
                        palabrasClavesSeleccionadas, enlace, resumen);
                
                if(mensaje.equals("Los datos a modificar deben ser validos.")){
                    JOptionPane.showMessageDialog(this.ventana, mensaje);
                }else{
                    JOptionPane.showMessageDialog(this.ventana, mensaje);
                    cp.verVentana().verTablaPublicaciones().setModel(new ModeloTablaPublicaciones()); //muestra los datos en la tabla.
                    this.limpiar(); //Hago que los campos de txt de la ventana quedan vacios.
                    ventana.verBtnNinguna().doClick(); //No deja marcada ninguna fila antes de cerrar la ventana.
                    ventana.dispose(); //Cierro la ventana.
                }
            }
        } catch (NullPointerException e) {
            //Si captura la excepcion, muestra el mensaje.
            JOptionPane.showMessageDialog(this.ventana,"Debe ingresar una fecha valida o asignarle al menos un grupo al profesor logueado.");
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.limpiar(); //Hago que los campos de txt de la ventana quedan vacios.
        this.ventana.verBtnNinguna().doClick(); //No deja marcada ninguna fila antes de cerrar la ventana.
        this.ventana.dispose(); //Cierro la ventana.
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER) {
            ventana.verDateChooser().transferFocus();
        }
    }

    @Override
    public void btnTodasLasPalabrasClavesClic(ActionEvent evt) {
        JTable tabla = this.ventana.verTablaPalabrasClaves();
        ModeloTablaPalabrasClaves mtpc = (ModeloTablaPalabrasClaves)tabla.getModel();
        ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, mtpc.getRowCount() - 1);
    }

    @Override
    public void btnNingunaPalabraClaveClic(ActionEvent evt) {
        JTable tabla = this.ventana.verTablaPalabrasClaves();
        ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
        modeloSeleccion.clearSelection();
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
    
    //Metodo auxiliar para limpiar los campos de texto de las ventana "Nuevo/Modificar".
    public void limpiar() {
        JTextField txtNombre = ventana.verTxtTitulo();
        JTextField txtEnlace = ventana.verTxtEnlace();
        JTextArea txtResumen = ventana.verTxtResumen();

        txtNombre.setText("");
        txtEnlace.setText("");
        txtResumen.setText("");
    }
}
