/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Autor;
import autores.modelos.Profesor;
import java.util.Objects;

public class MiembroEnGrupo {
    private Autor autor; // Cambié de tipo "Profesor" a tipo "Autor" para tomar Profesores y Alumnos.
    private Grupo grupo;
    private Rol rol;

    public MiembroEnGrupo(Autor autor, Grupo grupo, Rol rol) {
        this.autor = autor;
        this.grupo = grupo;
        this.rol = rol;
    }

    public Rol verRol() {
        return rol;
    }

    public void asignarRol(Rol rol) {
        this.rol = rol;
    }

    public Grupo verGrupo() {
        return grupo;
    }

    public void asignarGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Autor verProfesor() {
        return autor;
    }

    public void asignarProfesor(Profesor profesor) {
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.autor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {               //Esto pide el punto 6?
        if (this == obj) {                            //No termino de entender el segundo apartado del punto 6
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MiembroEnGrupo other = (MiembroEnGrupo) obj;
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        return true;
    }
    
}
