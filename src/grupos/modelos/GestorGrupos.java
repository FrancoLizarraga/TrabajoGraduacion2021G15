/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.GestorAutores;
import interfaces.IGestorGrupos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class GestorGrupos implements IGestorGrupos{
    private List<Grupo> grupos = new ArrayList<>();
    
    private static GestorGrupos gestor;
    private GestorGrupos(){
        
    }
    public static GestorGrupos instanciar(){
        if(gestor==null)
            gestor = new GestorGrupos();
        return gestor;
    }

    @Override
    public String nuevoGrupo(String nombre, String descripcion) {
        if ((nombre != null) && (!nombre.isEmpty())) {
            Grupo grupox = new Grupo(nombre, descripcion);
            if (!this.grupos.contains(grupox)) {
                this.grupos.add(grupox);
                return "Grupo creado y guardado";
            } else {
                return "Ya existe un grupo con ese nombre";
            }
        } else {
            return "El nombre del grupo debe ser una cadena no vacia.";
        }
    }

    @Override
    public String modificarGrupo(Grupo grupo, String descripcion) {
        int i = 0;
        for (Grupo g : this.grupos) {
            if (g.equals(grupo)) {
                grupo.asignarDescripcion(descripcion);
                return "Descripcion del grupo cambiada";
            }
            i++;
        }
        return "No hay ningun grupo con este nombre";
    }

    @Override
    public List<Grupo> verGrupos() {
        Collections.sort(grupos);
        
        return this.grupos;
    }

    @Override
    public Grupo verGrupo(String nombre) {
        for (Grupo g : this.grupos) {
            if (g.verNombre().equals(nombre)) {
                return g;
            }
        }
        return null;
    }

    @Override
    public boolean existeEsteGrupo(Grupo grupo) {
        for (Grupo g : this.grupos) {
            if (g.equals(grupo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String borrarGrupo(Grupo grupo) {
        if(this.grupos.contains(grupo)){
            if(!grupo.tieneMiembros()){
                grupos.remove(grupo);
                return "Se ha borrado el grupo ya que no hay autores con el mismo.";
            }
            else
                return "No se pudo borrar el grupo ya que hay autores con el mismo.";
        }
        else
            return "No existe el grupo.";
    }

    @Override
    public List<Grupo> buscarGrupos(String nombre) {
        List<Grupo> nuevosGrupos = new ArrayList<>();
        
        for(Grupo grupo : this.grupos){
            if(grupo.verNombre().toLowerCase().contains(nombre.toLowerCase())){
                if(grupo.verNombre().toLowerCase().compareTo(nombre.toLowerCase()) >= 0)
                    nuevosGrupos.add(grupo);
            }
        }
        Collections.sort(nuevosGrupos); //implementé la interfaz "comparable" a la clase Grupo.
        
        return nuevosGrupos;
    }
    
    
    
}
