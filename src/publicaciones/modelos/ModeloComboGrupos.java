/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuario
 */
public class ModeloComboGrupos extends DefaultComboBoxModel{
    GestorGrupos gestorG = GestorGrupos.instanciar();
    public ModeloComboGrupos(){
        for(Grupo grupo : gestorG.verGrupos()){
            this.addElement(grupo.verNombre());
        }
    }
    
    public Grupo obtenerGrupo() {
        return (Grupo) this.getSelectedItem();
    }
}
