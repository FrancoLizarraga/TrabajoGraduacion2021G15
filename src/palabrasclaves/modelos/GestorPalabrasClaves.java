/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import publicaciones.modelos.GestorPublicaciones;

/**
 *
 * @author Usuario
 */
public class GestorPalabrasClaves implements IGestorPalabrasClaves{
    private ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
    
    private static GestorPalabrasClaves gestor;
    private GestorPalabrasClaves(){
        
    }
    public static GestorPalabrasClaves instanciar(){
        if(gestor==null)
            gestor = new GestorPalabrasClaves();
        return gestor;
    }

    @Override
    public String nuevaPalabraClave(String nombre) {
        if ((nombre != null) && (!nombre.isEmpty())){
            PalabraClave palabra = new PalabraClave(nombre);
            if(!this.palabrasClaves.contains(palabra)){
                this.palabrasClaves.add(palabra);
                return "Palabra clave creada y guardada";
            }
            else
                return "Ya existe una palabra clave con ese nombre";
        }
        else
            return "El nombre de la palabra clave debe ser una cadena no vacia.";
    }

    @Override
    public List<PalabraClave> verPalabrasClaves() {
        Collections.sort(this.palabrasClaves);
        
        return this.palabrasClaves;
    }

    @Override
    public PalabraClave verPalabraClave(String nombre) {
        for(PalabraClave p : this.palabrasClaves){
            if(p.toString().equals(nombre))
                return p;
        }
        return null;
    }

    @Override
    public String borrarPalabraClave(PalabraClave palabraClave) {
        GestorPublicaciones gp = GestorPublicaciones.instanciar();
        
        if(this.palabrasClaves.contains(palabraClave)){
            if(!gp.hayPublicacionesConEstaPalabraClave(palabraClave)){
                this.palabrasClaves.remove(palabraClave);
                return "Se ha borrado la palabra clave ya que no hay publicaciones con la misma.";
            }
            else
                return "No se pudo borrar la palabra calve ya que hay publicaciones con la misma.";
        }
        else
            return "No existe esta palabra clave.";
    }

    @Override
    public List<PalabraClave> buscarPalabrasClaves(String nombre) {
        List<PalabraClave> nuevasPalabrasClaves = new ArrayList<>();
        
        for(PalabraClave palabra: this.palabrasClaves){
            if(palabra.verNombre().toLowerCase().contains(nombre.toLowerCase())){
                if(palabra.verNombre().toLowerCase().compareTo(nombre.toLowerCase()) >= 0)
                    nuevasPalabrasClaves.add(palabra);
            }
        }
        Collections.sort(nuevasPalabrasClaves); //implementé la interfaz "comparable" a la clase PalabraClave.
        
        return nuevasPalabrasClaves;
    }

    @Override
    public boolean existeEstaPalabraClave(PalabraClave palabraClave) {
        for(PalabraClave t : this.palabrasClaves){ 
            if(t.equals(palabraClave)) //Falta ver la manera para ignorar las mayusculas, con el toLowerCase no me permite.
                return true;
        }
        return false;
    }
  
    
    
}
