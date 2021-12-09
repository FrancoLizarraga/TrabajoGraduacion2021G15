/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import javax.swing.DefaultComboBoxModel;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;

/**
 *
 * @author Usuario
 */
public class ModeloComboLugares extends DefaultComboBoxModel{
    GestorLugares gl = GestorLugares.instanciar();
    public ModeloComboLugares(){
        for(Lugar lugar : gl.verLugares()){
            this.addElement(lugar);
        }
    }
    
    public Lugar obtenerLugar() {
        return (Lugar) this.getSelectedItem();
    }
}
