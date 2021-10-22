/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
import java.util.ArrayList;
import java.util.Objects;

public class Grupo {

    private String nombre;
    private String descripcion;
    private ArrayList<MiembroEnGrupo> miembrosEnGrupo = new ArrayList<>();

    public Grupo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public void mostrar() {
        System.out.println("Nombre: " + nombre + "\t\tDescripcion: " + descripcion);
        System.out.println("\tSus miembros con sus respectivos roles son:");
        for(MiembroEnGrupo m : miembrosEnGrupo){
            System.out.println("Autor: " + m.verAutor().verApellidos() + ", " + m.verAutor().verNombres() + "\tRol: " + m.verRol());
        }
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.nombre.toLowerCase(), other.nombre.toLowerCase())) {
            return false;
        }
        return true;
    }
    
    public void verMiembros(){
        System.out.println("\tMiembros:");
        for(MiembroEnGrupo m : miembrosEnGrupo){
            System.out.println(m.verAutor().verApellidos() + ", " + m.verAutor().verNombres());
        }
    }
    
    public void agregarMiembro(Autor autor, Rol rol){
        MiembroEnGrupo miembro = new MiembroEnGrupo(autor, this, rol);
        if(!tieneMiembros())
            miembrosEnGrupo.add(miembro);
        else{
            if(!miembrosEnGrupo.contains(miembro)){
                miembrosEnGrupo.add(miembro);
                autor.agregarGrupo(this, rol);
            }
        }
    }
    
    public void quitarMiembro(Autor miembro){
        
    }
    
    public boolean esSuperAdministradores(){
        if(this.nombre.equals("Super Administradores"))
            return true;
        else 
            return false;
    }
    
    public boolean tieneMiembros(){
        if(miembrosEnGrupo.size() == 0)
            return false;
        else
            return true;
    }
}
