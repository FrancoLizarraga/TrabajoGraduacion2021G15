/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import grupos.modelos.Grupo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IGestorGrupos {
    public String nuevoGrupo(String nombre, String descripcion);
    public String modificarGrupo(Grupo grupo, String descripcion);
//    public ArrayList<Grupo> verGrupos();
    public Grupo verGrupo(String nombre);
    public boolean existeEsteGrupo(Grupo grupo);
    
    public String borrarGrupo(Grupo grupo);
    public List<Grupo> buscarGrupos(String nombre);
    public List<Grupo> verGrupos();
//    public boolean existeEsteGrupo(Grupo grupo); YA LO TENIA DEL ANTERIOR TP...
    
}
