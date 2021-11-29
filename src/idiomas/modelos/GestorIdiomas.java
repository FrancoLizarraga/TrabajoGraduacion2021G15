/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idiomas.modelos;

import interfaces.IGestorIdiomas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import publicaciones.modelos.GestorPublicaciones;

/**
 *
 * @author Usuario
 */
public class GestorIdiomas implements IGestorIdiomas{
    private List<Idioma> idiomas = new ArrayList<>();
    
    private static GestorIdiomas gestor;
    private GestorIdiomas(){
        
    }
    public static GestorIdiomas instanciar(){
        if(gestor==null)
            gestor = new GestorIdiomas();
        return gestor;
    }
    
    @Override
    public String nuevoIdioma(String nombre) {
        if ((nombre != null) && (!nombre.isEmpty())){
            Idioma idiomax = new Idioma(nombre);
            if(!this.idiomas.contains(idiomax)){
                this.idiomas.add(idiomax);
                return "Idioma creado y guardado";
            }
            else
                return "Ya existe un idioma con ese nombre";
        }
        else
            return "El nombre del idioma debe ser una cadena no vacia.";
    }

    @Override
    public List<Idioma> verIdiomas() {
        Collections.sort(idiomas);
        
        return this.idiomas;
    }

    @Override
    public Idioma verIdioma(String nombre) {
        for(Idioma i : this.idiomas){
            if(i.toString().equals(nombre))
                return i;
        }
        return null;
    }

    @Override
    public String borrarIdioma(Idioma idioma) {
        GestorPublicaciones gp = GestorPublicaciones.instanciar();
        
        if(this.idiomas.contains(idioma)){
            if(!gp.hayPublicacionesConEsteIdioma(idioma)){
                this.idiomas.remove(idioma);
                return "Se ha borrado el idioma ya que no hay publicaciones con el mismo.";
            }
            else
                return "No se pudo borrar el idioma ya que hay publicaciones con el mismo.";
        }
        else
            return "No existe este idioma.";
    }

    @Override
    public List<Idioma> buscarIdiomas(String nombre) {
        List<Idioma> nuevosIdiomas = new ArrayList<>();
        
        for(Idioma idioma : this.idiomas){
            if(idioma.verNombre().toLowerCase().contains(nombre.toLowerCase())){
                if(idioma.verNombre().toLowerCase().compareTo(nombre.toLowerCase()) >= 0)
                    nuevosIdiomas.add(idioma);
            }
        }
        Collections.sort(nuevosIdiomas); //implementé la interfaz "comparable" a la clase Idioma.
        
        return nuevosIdiomas;
    }

    @Override
    public boolean existeEsteIdioma(Idioma idioma) {
        for(Idioma i : this.idiomas){ 
            if(i.equals(idioma)) //Falta ver la manera para ignorar las mayusculas, con el toLowerCase no me permite.
                return true;
        }
        return false;
    }
    
    
}
