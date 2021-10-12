/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos.modelos;

import autores.modelos.Profesor;
import java.util.List;
import palabrasclaves.modelos.PalabraClave;

public class MiembroEnGrupo {
    private Profesor profesor;
    private Grupo grupo;
    private Rol rol;

    public MiembroEnGrupo(Profesor profesor, Grupo grupo, Rol rol) {
        this.profesor = profesor;
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

    public Profesor verProfesor() {
        return profesor;
    }

    public void asignarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
}
