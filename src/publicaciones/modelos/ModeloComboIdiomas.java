/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.Idioma;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuario
 */
public class ModeloComboIdiomas extends DefaultComboBoxModel{
    GestorIdiomas gi = GestorIdiomas.instanciar();
    public ModeloComboIdiomas(){
        for(Idioma idioma : gi.verIdiomas()){
            this.addElement(idioma);
        }
    }
    
    public Idioma obtenerIdioma() {
        return (Idioma) this.getSelectedItem();
    }
}
