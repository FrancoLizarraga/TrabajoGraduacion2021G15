/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.modelos;

import interfaces.IGestorLugares;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import publicaciones.modelos.GestorPublicaciones;

/**
 *
 * @author Usuario
 */
public class GestorLugares implements IGestorLugares{
    private List<Lugar> lugares = new ArrayList<>();
    
    private static GestorLugares gestor;
    private GestorLugares(){
        
    }
    public static GestorLugares instanciar(){
        if(gestor==null)
            gestor = new GestorLugares();
        return gestor;
    }

    @Override
    public String nuevoLugar(String nombre) {
        if ((nombre != null) && (!nombre.isEmpty())) {
            Lugar lugarx = new Lugar(nombre);
            if (!this.lugares.contains(lugarx)) {
                this.lugares.add(lugarx);
                return "Lugar creado y guardado";
            } else {
                return "Ya existe un lugar con ese nombre";
            }
        } else {
            return "El nombre del lugar debe ser una cadena no vacia.";
        }
    }

    @Override
    public List<Lugar> verLugares() {
        Collections.sort(lugares);
        
        return this.lugares;
    }

    @Override
    public Lugar verLugar(String nombre) {
        for (Lugar l : this.lugares) {
            if (l.toString().equals(nombre)) {
                return l;
            }
        }
        return null;
    }

    @Override
    public String borrarLugar(Lugar lugar) {
        GestorPublicaciones gp = GestorPublicaciones.instanciar();
        
        if(this.lugares.contains(lugar)){
            if(!gp.hayPublicacionesConEsteLugar(lugar)){
                this.lugares.remove(lugar);
                return "Se ha borrado el lugar ya que no hay publicaciones con el mismo.";
            }
            else
                return "No se pudo borrar el lugar ya que hay publicaciones con el mismo.";
        }
        else
            return "No existe este lugar.";
    }

    @Override
    public List<Lugar> buscarLugares(String nombre) {
        List<Lugar> nuevosLugares = new ArrayList<>();
        
        for(Lugar lugar : this.lugares){
            if(lugar.verNombre().toLowerCase().contains(nombre.toLowerCase())){
                if(lugar.verNombre().toLowerCase().compareTo(nombre.toLowerCase()) >= 0)
                    nuevosLugares.add(lugar);
            }
        }
        Collections.sort(nuevosLugares); //implementé la interfaz "comparable" a la clase Lugar.
        
        return nuevosLugares;
    }

    @Override
    public boolean existeEsteLugar(Lugar lugar) {
        for(Lugar l : this.lugares){ 
            if(l.equals(lugar)) //Falta ver la manera para ignorar las mayusculas, con el toLowerCase no me permite.
                return true;
        }
        return false;
    }
    
    
}
