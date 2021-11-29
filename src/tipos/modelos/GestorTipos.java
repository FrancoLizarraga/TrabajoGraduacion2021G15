/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos.modelos;

import interfaces.IGestorTipos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import publicaciones.modelos.GestorPublicaciones;

/**
 *
 * @author Usuario
 */
public class GestorTipos implements IGestorTipos{
    private List<Tipo> tipos = new ArrayList<>();
    
    private static GestorTipos gestor;
    private GestorTipos(){
        
    }
    public static GestorTipos instanciar(){
        if(gestor==null)
            gestor = new GestorTipos();
        return gestor;
    }

    @Override
    public String nuevoTipo(String nombre) {
        if ((nombre != null) && (!nombre.isEmpty())){
            Tipo tipo = new Tipo(nombre);
            if(!this.tipos.contains(tipo)){
                this.tipos.add(tipo);
                return "Tipo creado y guardado";
            }
            else
                return "Ya existe un tipo con ese nombre";
        }
        else
            return "El nombre del tipo debe ser una cadena no vacia.";
    }

//    @Override
//    public ArrayList<Tipo> verTipos() {
//        return this.tipos;
//    }

    @Override
    public Tipo verTipo(String nombre) {
        for(Tipo t : this.tipos){
            if(t.toString().equals(nombre))
                return t;
        }
        return null;
    }

    @Override
    public String borrarTipo(Tipo tipo) {
        GestorPublicaciones gp = GestorPublicaciones.instanciar();
        
        if(this.tipos.contains(tipo)){
            if(!gp.hayPublicacionesConEsteTipo(tipo)){
                this.tipos.remove(tipo);
                return "Se ha borrado el tipo ya que no hay publicaciones con el mismo.";
            }
            else
                return "No se pudo borrar el tipo ya que hay publicaciones con el mismo.";
        }
        else
            return "No existe este tipo.";
    }

    @Override
    public List<Tipo> buscarTipos(String nombre) {
        List<Tipo> nuevosTipos = new ArrayList<>();
        
        for(Tipo tipo : this.tipos){
            if(tipo.verNombre().toLowerCase().contains(nombre.toLowerCase())){
                if(tipo.verNombre().toLowerCase().compareTo(nombre.toLowerCase()) >= 0)
                    nuevosTipos.add(tipo);
            }
        }
        Collections.sort(nuevosTipos); //implementé la interfaz "comparable" a la clase Tipo.
        
        return nuevosTipos;
    }

    @Override
    public List<Tipo> verTipos() {
        Collections.sort(this.tipos);
        
        return this.tipos;
    }

    @Override
    public boolean existeEsteTipo(Tipo tipo) {
        for(Tipo t : this.tipos){ 
            if(t.equals(tipo))
                return true;
        }
        return false;
    }
    
    
    
}
