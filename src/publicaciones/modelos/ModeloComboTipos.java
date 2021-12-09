/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import javax.swing.DefaultComboBoxModel;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;

/**
 *
 * @author Usuario
 */
public class ModeloComboTipos extends DefaultComboBoxModel{
    GestorTipos gt = GestorTipos.instanciar();
    public ModeloComboTipos(){
        for(Tipo tipo : gt.verTipos()){
            this.addElement(tipo);
        }
    }
    
    public Tipo obtenerTipo() {
        return (Tipo) this.getSelectedItem();
    }
}
