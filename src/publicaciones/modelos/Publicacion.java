/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;


public class Publicacion {
    private String titulo;
    private MiembroEnGrupo miembro;
    private LocalDate fechaPublicacion;
    private Tipo tipo;
    private Idioma idioma;
    private Lugar lugar;
    private List<PalabraClave> palabrasClaves;
    private String enlace;
    private String resumen;

    public Publicacion(String titulo, MiembroEnGrupo miembro, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, List<PalabraClave> palabrasClaves, String enlace, String resumen) {
        this.titulo = titulo;
        this.miembro = miembro;
        this.fechaPublicacion = fechaPublicacion;
        this.tipo = tipo;
        this.idioma = idioma;
        this.lugar = lugar;
        this.palabrasClaves = palabrasClaves;
        this.enlace = enlace;
        this.resumen = resumen;
    }
    
    public void mostrar(){
        System.out.println("Titulo: " + titulo + "\nAutor: " + miembro.verProfesor().verApellidos() + "," + miembro.verProfesor().verNombres());
        System.out.println("Grupo: " + miembro.verGrupo().verNombre() + "\nRol: " + miembro.verRol() + "\nFecha de publicación: " + fechaPublicacion);
        System.out.println("Tipo: " + tipo + "\nIdioma: " + idioma + "\nLugar: " + lugar);
        System.out.println("Palabras claves \n---------------");
        for(PalabraClave palabra : palabrasClaves){
            System.out.println("\t"+palabra);
        }
        System.out.println("Enlace: " + enlace + "\nResumen: " + resumen);
    }

    public String verTitulo() {
        return titulo;
    }

    public void asignarTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate verFechaPublicacion() {
        return fechaPublicacion;
    }

    public void asignarFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String verEnlace() {
        return enlace;
    }

    public void asignarEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String verResumen() {
        return resumen;
    }

    public void asignarResumen(String resumen) {
        this.resumen = resumen;
    }

    public Lugar verLugar() {
        return lugar;
    }

    public void asignarLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Idioma verIdioma() {
        return idioma;
    }

    public void asignarIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Tipo verTipo() {
        return tipo;
    }

    public void asignarTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<PalabraClave> verPalabrasClaves() {
        return palabrasClaves;
    }

    public void asignarPalabrasClaves(ArrayList<PalabraClave> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public MiembroEnGrupo verMiembro() {
        return miembro;
    }

    public void asignarMiembro(MiembroEnGrupo miembro) {
        this.miembro = miembro;
    }
   
}
