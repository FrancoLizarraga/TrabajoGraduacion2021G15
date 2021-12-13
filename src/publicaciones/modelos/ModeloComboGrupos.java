/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import autores.modelos.GestorAutores;
import autores.modelos.Profesor;
import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuario
 */
public class ModeloComboGrupos extends DefaultComboBoxModel{
    GestorGrupos gestorG = GestorGrupos.instanciar(); //Para poder ver el grupo (Con el nombre seleccionado) y devolverlo.
    GestorAutores ga = GestorAutores.instanciar();    //Para poder ver el primer profesor odernado alfabeticamente.
    Profesor primerProfesor  = ga.verProfesores().get(0);
    
    public ModeloComboGrupos(){
        List<Grupo> grupos = new ArrayList<>(); //List para cargar todos los grupos del profesor.
        //Primero cargo el ArrayList con los grupos del primer profesor ordenado alfabeticamente.
        for (MiembroEnGrupo m : primerProfesor.devolverMiembros()) {
            grupos.add(m.verGrupo());
        }
        
        for(Grupo grupo : grupos){
            this.addElement(grupo.verNombre());
        }
    }
    
    public Grupo obtenerGrupo() {
        Grupo grupo = gestorG.verGrupo(this.getSelectedItem().toString());
        return grupo;
    }
}
