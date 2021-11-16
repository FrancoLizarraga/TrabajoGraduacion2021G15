/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.modelos;

import interfaces.IGestorAutores;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GestorAutores implements IGestorAutores {

    private ArrayList<Autor> autores = new ArrayList<>();

    private static GestorAutores gestor;

    private GestorAutores() {

    }

    public static GestorAutores instanciar() {
        if (gestor == null) {
            gestor = new GestorAutores();
        }
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
            for (Autor a : autores) {
                if (a.equals(autor)) {
                    Alumno alumno;
                    alumno = (Alumno) autores.get(i);        //alumno apunta al mismo objeto que la posicion i de autores
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
    public ArrayList<Autor> verAutores() {
        return this.autores;
    }

    @Override
    public ArrayList<Profesor> verProfesores() {
        //La unica forma que se me ocurrió.
        ArrayList<Profesor> profesores = new ArrayList<>();
        for (Autor a : this.autores) {
            if (a instanceof Profesor) {
                profesores.add((Profesor) a);
            }
        }
        return profesores;
    }

    @Override
    public ArrayList<Alumno> verAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        for (Autor a : this.autores) {
            if (a instanceof Alumno) {
                alumnos.add((Alumno) a);
            }
        }
        return alumnos;
    }

    @Override
    public Autor verAutor(int dni) {
        for (Autor a : this.autores) {
            if (a.verDni() == dni) //if(a.equals(dni)) podria ser?
            {
                return a;
            }
        }
        return null;
    }

    //NUEVO METODO PARA BORRAR UN AUTOR.
    public void borrarAutor(Autor autor) {
        ArrayList<Autor> autorBorrado = this.autores;
        int i = 0;
        for (Autor a : autorBorrado) {
            if (a.equals(autor)) {
                break; //Cundo encuentra el autor sale del bucle for.
            }
            i++;
        }
        autorBorrado.remove(i); //Elimina el autor ubicado en la posicion i del ArrayList autorBorrado.
        this.autores = autorBorrado;
    }

}
