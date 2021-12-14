/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import interfaces.IGestorAutores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import publicaciones.modelos.GestorPublicaciones;

/**
 *
 * @author Usuario
 */
public class GestorAutores implements IGestorAutores{
    private List<Autor> autores = new ArrayList<>();
    
    private static GestorAutores gestor;
    private GestorAutores(){
        
    }
    public static GestorAutores instanciar(){
        if(gestor==null)
            gestor = new GestorAutores();
        return gestor;
    }

    //Agregué que el dni sea mayor que cero, el control de clave y claveRepetida.
    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {
        if ((nombres != null) && (!nombres.isEmpty()) && (apellidos != null) && (!apellidos.isEmpty())
                && (dni != 0) && (dni > 0) && (cargo != null) && (!cargo.toString().isEmpty()) && (clave != null)
                && (!clave.isEmpty()) && (claveRepetida != null) && (!claveRepetida.isEmpty())) {
            Autor profesor = new Profesor(dni, apellidos, nombres, clave, cargo);
            if (!this.autores.contains(profesor)) {
                this.autores.add(profesor);
                return "Profesor creado y guardado.";
            } else {
                return "Ya existe un profesor con ese dni.";
            }
        } else {
            return "Los datos del profesor deben ser validos.";
        }

    }

    //Agregué que el dni sea mayor que cero, el control de clave y claveRepetida.
    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
        if ((nombres != null) && (!nombres.isEmpty()) && (apellidos != null) && (!apellidos.isEmpty())
                && (dni != 0) && (dni > 0) && (cx != null) && (!cx.isEmpty()) && (clave != null)
                && (!clave.isEmpty()) && (claveRepetida != null) && (!claveRepetida.isEmpty())) {
            Autor alumno = new Alumno(dni, apellidos, nombres, clave, cx);
            if (!this.autores.contains(alumno)) {
                this.autores.add(alumno);
                return "Alumno creado y guardado.";
            } else {
                return "Ya existe un alumno con ese dni o cx.";
            }
        } else {
            return "Los datos del alumno deben ser validos.";
        }
    }

    //Agregué que el dni sea mayor que cero, el control de clave y claveRepetida.
    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {
        int i = 0;
        if ((nombres != null) && (!nombres.isEmpty()) && (apellidos != null) && (!apellidos.isEmpty())
                && (cargo != null) && (!cargo.toString().isEmpty()) && (autor != null) && (clave != null)
                && (!clave.isEmpty()) && (claveRepetida != null) && (!claveRepetida.isEmpty())) {
            for (Autor a : autores) {
                if (a.equals(autor)) {
                    Profesor profesor;
                    profesor = (Profesor) autores.get(i);
                    profesor.asignarApellidos(apellidos);
                    profesor.asignarNombres(nombres);
                    profesor.asignarCargo(cargo);
                    profesor.asignarClave(clave);

                    return "Los datos se han modificado.";
                }
                i++;
            }
            return "No existe dicho profesor.";
        } else {
            return "Los datos a modificar deben ser validos.";
        }
    }

    //Agregué que el dni sea mayor que cero, el control de clave y claveRepetida.
    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida) {
        int i = 0;
        if ((nombres != null) && (!nombres.isEmpty()) && (apellidos != null) && (!apellidos.isEmpty())
                && (cx != null) && (!cx.isEmpty()) && (autor != null) && (clave != null)
                && (!clave.isEmpty()) && (claveRepetida != null) && (!claveRepetida.isEmpty())) {
            //Busco el autor a modificar en el ArrayList.
            for (Autor a : autores) {
                if (a.equals(autor)) {
                    Alumno alumno;
                    alumno = (Alumno) autores.get(i);     //alumno apunta al mismo objeto que la posicion i de autores.
                    //Controlo que el cx ingresado no se repita en el ArrayList.
                    for(Alumno b : verAlumnos()){
                        if(b.equals(alumno))              //Cuando sean los mismos no controlo el cx, para que deje poner el mismo que ya tenia si lo desea.
                            continue;                     //Salta a la siguiente iteración del bucle for.
                        if(b.verCx().equals(cx))          //Si ya existe el cx ingresado, salta el mensaje.
                            return "El cx ingresado ya se encuentra registrado.";
                    }
                    alumno.asignarApellidos(apellidos);
                    alumno.asignarNombres(nombres);
                    alumno.asignarCx(cx);
                    alumno.asignarClave(clave);

                    return "Los datos se han modificado.";
                }
                i++;
            }
            return "No existe dicho alumno.";
        } else {
            return "Los datos a modificar deben ser validos.";
        }
    }

    @Override
    public boolean existeEsteAutor(Autor autor) {
        if (autores.contains(autor)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Autor> verAutores() {
        //La unica forma que se me ocurrió. Los concateno y los comparo para odenarlos por apellido y nombre.
        Comparator<Autor> comp = (a1, a2 ) -> a1.verApellidos().concat(a1.verNombres()).compareToIgnoreCase(a2.verApellidos().concat(a2.verNombres())); //Expresion lambda.
        Collections.sort(this.autores, comp);
        
        return this.autores;
    }

    @Override
    public List<Profesor> verProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        //La unica forma que se me ocurrió. Los concateno y los comparo para odenarlos por apellido y nombre.
        Comparator<Autor> comp = (a1, a2 ) -> a1.verApellidos().concat(a1.verNombres()).compareToIgnoreCase(a2.verApellidos().concat(a2.verNombres())); //Expresion lambda.
        
        for(Autor a : this.autores){
            if(a instanceof Profesor){
                profesores.add((Profesor)a);
            }
        }
        //No entendi si la consigna era igual que la de verAutores pero lo hice de la misma manera.
        Collections.sort(profesores, comp);
        
        return profesores;
    }

    @Override
    public List<Alumno> verAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        //La unica forma que se me ocurrió. Los concateno y los comparo para odenarlos por apellido y nombre.
        Comparator<Autor> comp = (a1, a2 ) -> a1.verApellidos().concat(a1.verNombres()).compareToIgnoreCase(a2.verApellidos().concat(a2.verNombres())); //Expresion lambda.
        
        for(Autor a : this.autores){
            if(a instanceof Alumno)
                alumnos.add((Alumno)a);
        }
        //No entendi si la consigna era igual que la de verAutores pero lo hice de la misma manera.
        Collections.sort(alumnos, comp);
        
        return alumnos;
    }

    @Override
    public Autor verAutor(int dni) {
        for(Autor a : this.autores){
            if(a.verDni() == dni)
                return a;
        }
        return null;
    }

    @Override
    public String borrarAutor(Autor autor) {
        GestorPublicaciones gp = GestorPublicaciones.instanciar();
        
        if(this.autores.contains(autor)){
            if(!gp.hayPublicacionesConEsteAutor(autor)){
                this.autores.remove(autor);
                return "Se ha borrado el autor porque no hay publicaciones con el mismo.";
            }
            else
                return "No se pudo borrar el autor ya que hay publicaciones con el mismo.";
        }
        else
            return "No existe este autor.";
    }

    @Override
    public List<Profesor> buscarProfesores(String apellidos) {
        List<Profesor> nuevosProfesores = new ArrayList<>();
        //La unica forma que se me ocurrió. Los concateno y los comparo para odenarlos por apellido y nombre.
        Comparator<Autor> comp = (a1, a2 ) -> a1.verApellidos().concat(a1.verNombres()).compareToIgnoreCase(a2.verApellidos().concat(a2.verNombres())); //Expresion lambda.
        
        for(Autor profesor : verProfesores()){
            if(profesor.verApellidos().toLowerCase().contains(apellidos.toLowerCase())){
                if(profesor.verApellidos().toLowerCase().compareTo(apellidos.toLowerCase()) >= 0)
                    nuevosProfesores.add((Profesor)profesor);
            }
        }
        //No entendi si la consigna era igual que la de buscarAlumnos pero lo hice de la misma manera.
        Collections.sort(nuevosProfesores, comp); 
        
        return nuevosProfesores;
    }

    @Override
    public List<Alumno> buscarAlumnos(String apellidos) {
        List<Alumno> nuevosAlumnos = new ArrayList<>();
        //La unica forma que se me ocurrió. Los concateno y los comparo para odenarlos por apellido y nombre.
        Comparator<Autor> comp = (a1, a2 ) -> a1.verApellidos().concat(a1.verNombres()).compareToIgnoreCase(a2.verApellidos().concat(a2.verNombres())); //Expresion lambda.
        
        for(Autor alumno : verAlumnos()){
            if(alumno.verApellidos().toLowerCase().contains(apellidos.toLowerCase())){
                if(alumno.verApellidos().toLowerCase().compareTo(apellidos.toLowerCase()) >= 0)
                    nuevosAlumnos.add((Alumno)alumno);
            }
        }
        Collections.sort(nuevosAlumnos,comp);
        
        return nuevosAlumnos;
    }

    @Override
    public boolean hayAutoresConEsteGrupo(Grupo grupo) {
        for(Autor a : this.autores){
            for(MiembroEnGrupo miembro : a.devolverMiembros()){
                if(miembro.verGrupo().equals(grupo))
                    return true;
            }
        }
        return false;
    }

    //METODOS NUEVOS PARA PARCIAL 2
    @Override
    public String agregarGrupos(Autor autor, List<MiembroEnGrupo> grupos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String quitarGrupos(Autor autor, List<MiembroEnGrupo> grupos) {
        if (this.existeEsteAutor(autor)) {
            if( (grupos!=null) && (!grupos.isEmpty()) ) {
                for(int i=0; i<grupos.size(); i++){
                    if(autor.devolverMiembros().contains(grupos.get(i)))
                        autor.quitarGrupo(grupos.get(i).verGrupo());
                }
                return "Grupos quitados con éxito.";
            }
            else
                return "No se especificaron grupos a quitar.";
        }
        return "No existe el autor especificado.";
    }
    
}
