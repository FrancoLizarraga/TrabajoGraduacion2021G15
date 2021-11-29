/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import java.util.Objects;

public class Alumno extends Autor implements Comparable<Alumno>{
//    private int dni;
//    private String apellidos;
//    private String nombres;
//    private String clave;
    private String cx;

    public Alumno(int dni, String apellidos, String nombres, String clave, String cx) {
        super(dni, apellidos, nombres, clave);
//        this.dni = dni;
//        this.apellidos = apellidos;
//        this.nombres = nombres;
//        this.clave = clave;
        this.cx = cx;
    }
    
    public void mostrar(){
        super.mostrar();
        System.out.println("\tCx: " + cx);
//        System.out.println("\nApellidos y Nombres: " + apellidos +", " + nombres + "\nDNI: " + dni + "\tClave: " + clave + "\tCx: " + cx);
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
//    public void asinarNombres(String nombres) {
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

    public String verCx() {
        return cx;
    }

    public void asignarCx(String cx) {
        this.cx = cx;
    }

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 71 * hash + super.verDni();
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (super.equals(obj)){
//            if ()
//        }
//            
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Alumno other = (Alumno) obj;
//        if (super.verDni() != super.verDni()) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public int hashCode() {
        super.hashCode();
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.cx);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)){        //Primero llamo al equals de Autor para comparar el dni.
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Alumno other = (Alumno) obj;
            if (!Objects.equals(this.cx, other.cx)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Alumno a) {
        return super.verApellidos().compareTo(a.verApellidos());
    }

    
}
