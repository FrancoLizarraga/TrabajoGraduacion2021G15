/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.controladores;

import autores.modelos.Autor;
import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.ModeloComboRoles;
import grupos.modelos.ModeloTablaAMGrupo;
import grupos.modelos.ModeloTablaModificarMiembros;
import grupos.vistas.VentanaModificarMiembros;
import interfaces.IControladorModificarMiembros;
import static interfaces.IControladorModificarMiembros.CONFIRMACION;
import static interfaces.IControladorModificarMiembros.TITULO;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Usuario
 */
public class ControladorModificarMiembros implements IControladorModificarMiembros{
    private VentanaModificarMiembros ventana;
    private Grupo grupoModificar;
    
    private static ControladorModificarMiembros instanciador;

    private ControladorModificarMiembros() {
        ventana = new VentanaModificarMiembros(this);
    }

    public static ControladorModificarMiembros instanciar() {
        if (instanciador == null) {
            instanciador = new ControladorModificarMiembros();
        }
        return instanciador;
    }
    
    /**
     * Metodo auxiliar para poder pasarle el grupo a modificar al constructor del modelo de la tabla.
     */
    public void auxiliar(Grupo grupoModificar){
        this.grupoModificar = grupoModificar;
        this.ventana.verTablaModificar().setModel(new ModeloTablaModificarMiembros(grupoModificar));
        JComboBox comboRol = new JComboBox();
        comboRol.setModel(new ModeloComboRoles());
        JTable tabla = this.ventana.verTablaModificar();
        TableColumn columnaRol = tabla.getColumnModel().getColumn(1);
        columnaRol.setCellEditor(new DefaultCellEditor(comboRol));
        this.ventana.verTablaModificar().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    
    @Override
    public void btnTodosClic(ActionEvent evt) {
        JTable tabla = this.ventana.verTablaModificar();
        ModeloTablaModificarMiembros mtpc = (ModeloTablaModificarMiembros)tabla.getModel();
        ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, mtpc.getRowCount() - 1);
    }

    @Override
    public void btnNingunoClic(ActionEvent evt) {
        JTable tabla = this.ventana.verTablaModificar();
        ListSelectionModel modeloSeleccion = tabla.getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    @Override
    public void btnAceptarClic(ActionEvent evt) {
        GestorGrupos gestor = GestorGrupos.instanciar();
        ControladorAMGrupo camp = ControladorAMGrupo.instanciar(); //Para poder refrescar la tabla.
        int opcion = JOptionPane.showOptionDialog(this.ventana, CONFIRMACION, TITULO,JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Si", "No"}, this);

        if (opcion == JOptionPane.YES_OPTION){
            /*Primero borro todos los grupos para que no me aparezcan los que estaban cargados anteriormente
            (En el caso de que no los hayan seleccionado de nuevo).*/
            gestor.quitarMiembros(this.grupoModificar, grupoModificar.verMiembros());
            /*Tomo los miebros seleccionados en la tabla.*/
            int[] filasSeleccionadas = this.ventana.verTablaModificar().getSelectedRows();
            ModeloTablaModificarMiembros modeloTabla = (ModeloTablaModificarMiembros)this.ventana.verTablaModificar().getModel();
            List<MiembroEnGrupo> miembroEnGrupos = this.grupoModificar.verMiembros();
            List<MiembroEnGrupo> miembrosSeleccionados = new ArrayList<>();
            for (int i = 0; i < filasSeleccionadas.length; i++) {
                //Carga la Lista con los miembros seleccionados en la tabla.
                miembrosSeleccionados.add(new MiembroEnGrupo(modeloTabla.verMiembroEnGrupo(filasSeleccionadas[i]).verAutor(), this.grupoModificar, modeloTabla.verMiembroEnGrupo(filasSeleccionadas[i]).verRol()));
            }
            /*Hasta acá.*/
            boolean rol = false;
            for(MiembroEnGrupo m: miembrosSeleccionados){
                if(m.verRol()==null)
                    rol=true;
            }

            if(!rol){
                gestor.agregarMiembros(this.grupoModificar, miembrosSeleccionados);
                /*Refresco los valores de la tabla de VentanaAMGrupo y cierro la ventana actual.*/
                camp.verVentana().verTablaAMGrupo().setModel(new ModeloTablaAMGrupo(grupoModificar));
                this.ventana.dispose(); 
            }
            else 
                JOptionPane.showMessageDialog(ventana, "Todos los miembros seleccionados deben tener asignado un rol.");
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    public VentanaModificarMiembros verVentana() {
        return ventana;
    }
    
}
