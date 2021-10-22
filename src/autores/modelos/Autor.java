/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public abstract class Autor {
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    private ArrayList<MiembroEnGrupo> miembrosEnGrupo = new ArrayList<>();
    
    public Autor(int dni, String apellidos, String nombres, String clave) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
    }

    public int verDni() {
        return dni;
    }

    public void asignarDni(int dni) {
        this.dni = dni;
    }

    public String verApellidos() {
        return apellidos;
    }

    public void asignarApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String verNombres() {
        return nombres;
    }

    public void asignarNombres(String nombres) {
        this.nombres = nombres;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String clave) {
        this.clave = clave;
    }
    
    public void mostrar(){
        System.out.println("[" + this.dni + "] " + this.apellidos + ", " + this.nombres);
        for(MiembroEnGrupo m : miembrosEnGrupo)
            System.out.println("Grupo: " + m.verGrupo().verNombre() + "\tRol: " + m.verRol());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.dni;
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
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }
    
    public void verGrupos(){
        System.out.println("Grupos: ");
        for(MiembroEnGrupo m : miembrosEnGrupo)
            System.out.println(m.verGrupo().verNombre());
    }
    
    public void agregarGrupo(Grupo grupo, Rol rol){
        MiembroEnGrupo miembro = new MiembroEnGrupo(this, grupo, rol);
        if(!miembrosEnGrupo.contains(miembro))
            miembrosEnGrupo.add(miembro);
        if(!miembrosEnGrupo.contains(grupo))
            grupo.agregarMiembro(this, rol);
    }
    
    public void quitarGrupo(Grupo grupo){
        Iterator<MiembroEnGrupo> iterator = miembrosEnGrupo.iterator();
        while (iterator.hasNext()){
            MiembroEnGrupo unMiembro = iterator.next();
            if (unMiembro.verGrupo().equals(grupo))
                iterator.remove();
        }
    }
    
    public boolean esSuperAdministrador(){
        for(MiembroEnGrupo m : miembrosEnGrupo){
            if(m.verGrupo().equals("Super Administradores"))
                return true;
            else
                return false;
        }
        return false;
    }
}
