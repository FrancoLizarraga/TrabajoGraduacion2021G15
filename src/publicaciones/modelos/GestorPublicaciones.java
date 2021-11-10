/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import interfaces.IGestorPublicaciones;
import java.time.LocalDate;
import java.util.ArrayList;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

/**
 *
 * @author Usuario
 */
public class GestorPublicaciones implements IGestorPublicaciones{
    private ArrayList<Publicacion> publicaciones = new ArrayList<>();
    
    private static GestorPublicaciones gestor;
    private GestorPublicaciones(){
        
    }
    public static GestorPublicaciones instanciar(){
        if(gestor==null)
            gestor = new GestorPublicaciones();
        return gestor;
    }

    @Override
    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo,
            Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {
        
        if ((titulo != null) && (!titulo.isEmpty()) && (miembroEnGrupo != null) && (fechaPublicacion != null)
                && (tipo != null) && (!tipo.toString().isEmpty()) && (idioma != null) && (!idioma.toString().isEmpty())
                && (lugar != null) && (!lugar.toString().isEmpty()) && (palabrasClaves != null) && (!palabrasClaves.isEmpty())
                && (enlace != null) && (!enlace.isEmpty()) && (resumen != null) && (!resumen.isEmpty())){
            Publicacion publicacionx = new Publicacion(titulo, miembroEnGrupo, fechaPublicacion, tipo, idioma, lugar, palabrasClaves, enlace, resumen);
            
            if(!this.publicaciones.contains(publicacionx)){
                this.publicaciones.add(publicacionx);
                return "Publicación creada y guardada.";
            }
            else 
                return "Ya existe una publicación con este titulo.";
        }
        else
            return "Los datos de la publicación deben ser validos.";
    }

    @Override
    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {
        int i=0;
        if ((publicacion != null) && (miembroEnGrupo != null) && (fechaPublicacion != null)
                && (tipo != null) && (!tipo.toString().isEmpty()) && (idioma != null) && (!idioma.toString().isEmpty())
                && (lugar != null) && (!lugar.toString().isEmpty()) && (palabrasClaves != null) && (!palabrasClaves.isEmpty())
                && (enlace != null) && (!enlace.isEmpty()) && (resumen != null) && (!resumen.isEmpty())){
            for(Publicacion p : this.publicaciones){
                if(p.equals(publicacion)){
                    Publicacion publicacionx;
                    publicacionx = publicaciones.get(i);
                    publicacionx.asignarEnlace(enlace);
                    publicacionx.asignarFechaPublicacion(fechaPublicacion);
                    publicacionx.asignarIdioma(idioma);
                    publicacionx.asignarLugar(lugar);
                    publicacionx.asignarMiembro(miembroEnGrupo);
                    publicacionx.asignarPalabrasClaves(palabrasClaves);
                    publicacionx.asignarResumen(resumen);
                    publicacionx.asignarTipo(tipo);
                    
                    return "Los datos se han modificado.";
                }
                i++;
            }
            return "No existe dicha publicación.";
        }
        else
            return "Los datos a modificar deben ser validos.";
    }

    @Override
    public boolean hayPublicacionesConEstaPalabraClave(PalabraClave palabraClave) {
        for(Publicacion p : this.publicaciones){
            if(p.verPalabrasClaves().contains(palabraClave))
                return true;
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteLugar(Lugar lugar) {
        for(Publicacion p : this.publicaciones){
            if(p.verLugar().equals(lugar))
                return true;
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteIdioma(Idioma idioma) {
        for(Publicacion p : this.publicaciones){
            if(p.verIdioma().equals(idioma))
                return true;
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteTipo(Tipo tipo) {
        for(Publicacion p : this.publicaciones){
            if(p.verTipo().equals(tipo))
                return true;
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteAutor(Autor autor) {
        for(Publicacion p : this.publicaciones){
            if(p.verMiembro().verAutor().equals(autor))
                return true;
        }
        return false;
    }

    @Override
    public boolean existeEstaPublicacion(Publicacion publicacion) {
        for(Publicacion p : this.publicaciones){
            if(p.equals(publicacion))
                return true;
        }
        return false;
    }

    @Override
    public ArrayList<Publicacion> verPublicaciones() {
        return this.publicaciones;
    }

    @Override
    public Publicacion verPublicacion(String titulo) {
        for(Publicacion p : this.publicaciones){
            if(p.verTitulo().equals(titulo))
                return p;
        }
        return null;
    }
    
}
