/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import interfaces.IGestorGrupos;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GestorGrupos implements IGestorGrupos{
    private ArrayList<Grupo> grupos = new ArrayList<>();
    
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
        if ((nombre != null) && (!nombre.isEmpty())){
            Grupo grupox = new Grupo(nombre, descripcion);
            if(!this.grupos.contains(grupox)){
                this.grupos.add(grupox);
                return "Grupo creado y guardado";
            }
            else
                return "Ya existe un grupo con ese nombre";
        }
        else
            return "El nombre del grupo debe ser una cadena no vacia.";
    }
    
    @Override
    public String modificarGrupo(Grupo grupo, String descripcion) {
        int i=0;
        for(Grupo g : this.grupos){
            if(g.equals(grupo)){
//                this.grupos.get(i).asignarDescripcion(descripcion);
                grupo.asignarDescripcion(descripcion);
                return "Descripcion del grupo cambiada";
            }
            i++;
        }
        return "No hay ningun grupo con este nombre";
    }

    @Override
    public ArrayList<Grupo> verGrupos() {
        return this.grupos;
    }

    @Override
    public Grupo verGrupo(String nombre) {
        for(Grupo g : this.grupos){
            if(g.verNombre().equals(nombre))
                return g;
        }
        return null;
    }

    @Override
    public boolean existeEsteGrupo(Grupo grupo) {
        for(Grupo g : this.grupos){
            if(g.equals(grupo))
                return true;
        }
        return false;
        //PODRIA SER OTRA FORMA
//        int bandera=0;
//        for(Grupo g : this.grupos){
//            if(g.equals(grupo))
//                bandera++;
//        }
//        if(bandera != 0)
//            return true;
//        else
//            return false;
    }
    
}
