/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos.modelos;

import java.util.Objects;

public class Tipo implements Comparable<Tipo>{
    private String nombre;

    public Tipo(String nombre) {
        this.nombre = nombre;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.nombre);
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
        final Tipo other = (Tipo) obj;
        if (!Objects.equals(this.nombre.toLowerCase(), other.nombre.toLowerCase())) {
            return false;
        }
        return true;
    }

    public String toString() {
        return nombre;
    }

    @Override
    public int compareTo(Tipo t) {
        return this.nombre.compareTo(t.verNombre()); //Si this.nombre está antes, alfabeticamente, que nombre devuelve num <0
    }
    
    
}
