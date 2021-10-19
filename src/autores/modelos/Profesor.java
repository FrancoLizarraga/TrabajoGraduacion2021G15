/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import grupos.modelos.MiembroEnGrupo;
import java.util.ArrayList;

public class Profesor extends Autor{
//    private int dni;
//    private String apellidos;
//    private String nombres;
//    private String clave;
    private Cargo cargo;
    private ArrayList<MiembroEnGrupo> miembrosEnGrupo; // QUIZAS DEBA SER UN "LIST" COMO EN EN PUBLICACION.

    public Profesor(int dni, String apellidos, String nombres, String clave, Cargo cargo) {
        super(dni, apellidos, nombres, clave);
//        this.dni = dni;
//        this.apellidos = apellidos;
//        this.nombres = nombres;
//        this.clave = clave;
        this.cargo = cargo;
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("\tCargo: " + cargo);
//        System.out.println("\nApellidos y Nombres: " + apellidos +", " + nombres + "\nDNI: " + dni + "\tClave: " + clave + "\tCargo: " + cargo);
    }
    
//    public int verDni() {
//        return dni;
//    }
//
//    public void asignarDni(int dni) {
//        this.dni = dni;
//    }
//
//    public String verApellidos() {
//        return apellidos;
//    }
//
//    public void asignarApellidos(String apellidos) {
//        this.apellidos = apellidos;
//    }
//
//    public String verNombres() {
//        return nombres;
//    }
//
//    public void asignarNombres(String nombres) {
//        this.nombres = nombres;
//    }
//
//    public String verClave() {
//        return clave;
//    }
//
//    public void asignarClave(String clave) {
//        this.clave = clave;
//    }

    public Cargo verCargo() {
        return cargo;
    }

    public void asignarCargo(Cargo cargo) {
        this.cargo = cargo;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 79 * hash + super.verDni(); //cambié el "this.dni" por "super.verDni"
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Profesor other = (Profesor) obj;
//        if (super.verDni() != super.verDni()) {  //cambié el "this.dni" por "super.verDni" en la comparación
//            return false;
//        }
//        return true;
//    }
    
    //¿Por qué no mostraba cuando estaba definido aqui el método equals/hashcode? Tuve que definirlo en Autor
    //para poderlo mostrar.
    
}