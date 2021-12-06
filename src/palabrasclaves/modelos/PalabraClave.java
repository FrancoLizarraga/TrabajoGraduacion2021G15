/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class PalabraClave implements Comparable<PalabraClave>{
    private String nombre;

    public PalabraClave(String nombre) {
        this.nombre = nombre;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre);
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
        final PalabraClave other = (PalabraClave) obj;
        if (!Objects.equals(this.nombre.toLowerCase(), other.nombre.toLowerCase())) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(PalabraClave p) {
        return this.nombre.compareTo(p.verNombre());
    }
    
    
}
