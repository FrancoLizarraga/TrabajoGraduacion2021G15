/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;

public class Profesor extends Autor {

    private Cargo cargo;
    private ArrayList<MiembroEnGrupo> miembrosEnGrupo; // QUIZAS DEBA SER UN "LIST" COMO EN EN PUBLICACION.

    public Profesor(int dni, String apellidos, String nombres, String clave, Cargo cargo) {
        super(dni, apellidos, nombres, clave);
        this.cargo = cargo;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Cargo: " + cargo);
    }

    public Cargo verCargo() {
        return cargo;
    }

    public void asignarCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
