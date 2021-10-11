package principal.controladores;

import autores.vistas.VentanaAMAlumno;
import autores.vistas.VentanaAMProfesor;
import grupos.vistas.VentanaAMGrupo;
import idiomas.vistas.VentanaAIdioma;
import lugares.vistas.VentanaALugar;
import palabrasclaves.vistas.VentanaAPalabraClave;
import tipos.vistas.VentanaATipo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class ControladorPrincipal {
    public static void main(String[] args) {
        
//        //5)a)
//        ArrayList<Alumno> unAlumno = new ArrayList<>();
//        ArrayList<Profesor> unProfesor = new ArrayList<>();
//        ArrayList<Idioma> unIdioma = new ArrayList<>();
//        ArrayList<Lugar> unLugar = new ArrayList<>();
//        ArrayList<PalabraClave> unaPalabraClave = new ArrayList<>();
//        ArrayList<Tipo> unTipo = new ArrayList<>();
//        ArrayList<Grupo> unGrupo = new ArrayList<>();
//        
//        //5)b)
//        //instanciar objetos de la clase alumnos.
//        Alumno alumnoUno = new Alumno(4522,"Juarez", "Julian Jose", "JJJ", "555");
//        Alumno alumnoDos = new Alumno(2235,"Herrera", "Maria Elena", "HME", "333");
//        Alumno alumnoTres = new Alumno(2258,"Perez", "Jose Maria", "PJM", "515");
//        Alumno alumnoCuatro = new Alumno(1158,"Falcon", "Constanza Sabrina", "FCS", "223");
//        Alumno alumnoCinco = new Alumno(2154,"Albornoz", "Lautaro Nicolas", "ALN", "157");
//        unAlumno.add(alumnoUno);
//        unAlumno.add(alumnoDos);
//        unAlumno.add(alumnoTres);
//        unAlumno.add(alumnoCuatro);
//        unAlumno.add(alumnoCinco);
//        System.out.println("\n\t\tEsta es la lista de alumnos:");
//        for(Alumno aux : unAlumno)
//            aux.mostrar();
//        
//        //instanciar objetos de la clase profesor.
//        Profesor profesorUno = new Profesor(1234,"Correa","Maria Luisa","CML","Titular");
//        Profesor profesorDos = new Profesor(5687,"Fernandez","Pablo","FP","Asociado");
//        Profesor profesorTres = new Profesor(5134,"Martinez","Lucas Ivan","MLI","Adjunto");
//        Profesor profesorCuatro = new Profesor(4782,"Perea","Sabrina Nicole","PSN","JTP");
//        Profesor profesorCinco = new Profesor(9875,"Ibarra","Lautaro David","ILD","ADG");
//        unProfesor.add(profesorUno);
//        unProfesor.add(profesorDos);
//        unProfesor.add(profesorTres);
//        unProfesor.add(profesorCuatro);
//        unProfesor.add(profesorCinco);
//        System.out.println("\n\t\tEsta es la lista de profesores:");
//        for(Profesor prof : unProfesor)
//            prof.mostrar();
//        
//        //instanciar objetos de la clase idioma.
//        Idioma idiomaUno = new Idioma("Español");
//        Idioma idiomaDos = new Idioma("Ingles");
//        Idioma idiomaTres = new Idioma("Portugues");
//        Idioma idiomaCuatro = new Idioma("Ruso");
//        Idioma idiomaCinco = new Idioma("Aleman");
//        unIdioma.add(idiomaUno);
//        unIdioma.add(idiomaDos);
//        unIdioma.add(idiomaTres);
//        unIdioma.add(idiomaCuatro);
//        unIdioma.add(idiomaCinco);
//        System.out.println("\n\t\tEsta es la lista de idiomas:");
//        for(Idioma idiom : unIdioma)
//            System.out.println(idiom);
//        
//        //instanciar objetos de la clase lugar.
//        Lugar lugarUno = new Lugar("Facultad");
//        Lugar lugarDos = new Lugar("Congreso");
//        Lugar lugarTres = new Lugar("Revista cientifica");
//        Lugar lugarCuatro = new Lugar("Libro");
//        Lugar lugarCinco = new Lugar("Redes sociales");
//        unLugar.add(lugarUno);
//        unLugar.add(lugarDos);
//        unLugar.add(lugarTres);
//        unLugar.add(lugarCuatro);
//        unLugar.add(lugarCinco);
//        System.out.println("\n\t\tEsta es la lista de lugares:");
//        for(Lugar lug : unLugar)
//            System.out.println(lug);
//        
//        //instanciar objetos de la clase palabraclave.
//        PalabraClave palabraUno = new PalabraClave("Fisica");
//        PalabraClave palabraDos = new PalabraClave("Computacion");
//        PalabraClave palabraTres = new PalabraClave("Robotica");
//        PalabraClave palabraCuatro = new PalabraClave("Medio ambiente");
//        PalabraClave palabraCinco = new PalabraClave("Marte");
//        unaPalabraClave.add(palabraUno);
//        unaPalabraClave.add(palabraDos);
//        unaPalabraClave.add(palabraTres);
//        unaPalabraClave.add(palabraCuatro);
//        unaPalabraClave.add(palabraCinco);
//        System.out.println("\n\t\tEsta es la lista de palabras claves:");
//        for(PalabraClave palabra : unaPalabraClave)
//            System.out.println(palabra);
//        
//        //instanciar objetos de la clase tipo.
//        Tipo tipoUno = new Tipo("Trabajo de congreso");
//        Tipo tipoDos = new Tipo("Tesis");
//        Tipo tipoTres = new Tipo("Libro");
//        Tipo tipoCuatro = new Tipo("Capitulo de libro");
//        Tipo tipoCinco = new Tipo("Documento digital");
//        unTipo.add(tipoUno);
//        unTipo.add(tipoDos);
//        unTipo.add(tipoTres);
//        unTipo.add(tipoCuatro);
//        unTipo.add(tipoCinco);
//        System.out.println("\n\t\tEsta es la lista de los tipos:");
//        for(Tipo tip : unTipo)
//            System.out.println(tip);
//        
//        //instanciar objetos de la clase tipo.
//        Grupo grupoUno = new Grupo("Grupo1","Se encarga de investigar la fisica");
//        Grupo grupoDos = new Grupo("Grupo2","Se encarga de investigar la computacion");
//        Grupo grupoTres = new Grupo("Grupo3","Se encarga de investigar la robotica");
//        Grupo grupoCuatro = new Grupo("Grupo4","Se encarga de investigar el medio ambiente");
//        Grupo grupoCinco = new Grupo("Grupo5","Se encarga de investigar Marte");
//        unGrupo.add(grupoUno);
//        unGrupo.add(grupoDos);
//        unGrupo.add(grupoTres);
//        unGrupo.add(grupoCuatro);
//        unGrupo.add(grupoCinco);
//        System.out.println("\n\t\tEsta es la lista de los grupos:");
//        for(Grupo grup : unGrupo)
//            grup.mostrar();
//        
//        //5)e)Modifico algunos valores de algunos objetos y los muestro.
//        alumnoCinco.asignarApellidos("Kolda");
//        profesorTres.asignarNombres("Roberto");
//        idiomaCinco.asignarNombre("Japones");
//        grupoCinco.asignarNombre("Nuevo grupo");
//        System.out.println("\n\t\tEsta es la LISTA CON LA MODIFICACION de alumnos:");
//        for(Alumno aux : unAlumno)
//            aux.mostrar();
//        System.out.println("\n\t\tEsta es la LISTA CON LA MODIFICACION de profesores:");
//        for(Profesor prof : unProfesor)
//            prof.mostrar();
//        System.out.println("\n\t\tEsta es la LISTA CON LA MODIFICACION de idiomas:");
//        for(Idioma idiom : unIdioma)
//            System.out.println(idiom);
//        System.out.println("\n\t\tEsta es la LISTA CON LA MODIFICACION de los grupos:");
//        for(Grupo grup : unGrupo)
//            grup.mostrar();
        
          VentanaAMAlumno alumno = new VentanaAMAlumno(null);
          alumno.setLocationRelativeTo(null);
          alumno.setVisible(true);
          
          VentanaAMProfesor profesor = new VentanaAMProfesor(null);
          profesor.setLocationRelativeTo(null);
          profesor.setVisible(true);
          
          VentanaAMGrupo grupo = new VentanaAMGrupo(null);
          grupo.setLocationRelativeTo(null);
          grupo.setVisible(true);
          
          VentanaAIdioma idioma = new VentanaAIdioma(null);
          idioma.setLocationRelativeTo(null);
          idioma.setVisible(true);
          
          VentanaALugar lugar = new VentanaALugar(null);
          lugar.setLocationRelativeTo(null);
          lugar.setVisible(true);
          
          VentanaAPalabraClave palabraClave = new VentanaAPalabraClave(null);
          palabraClave.setLocationRelativeTo(null);
          palabraClave.setVisible(true);
          
          VentanaATipo tipo = new VentanaATipo(null);
          tipo.setLocationRelativeTo(null);
          tipo.setVisible(true);
        
        
    }
}
