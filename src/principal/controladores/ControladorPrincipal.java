/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.Cargo;
import autores.modelos.Profesor;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import idiomas.modelos.Idioma;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.Publicacion;
import tipos.modelos.Tipo;


/**
 *
 * @author prog2
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
    
     //<editor-fold defaultstate="collapsed" desc="Sin intefaz gráfica"> 
        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Grupo> grupos = new ArrayList<>();
//        ArrayList<Alumno> alumnos = new ArrayList<>();
//        ArrayList<Profesor> profesores = new ArrayList<>();
        ArrayList<Tipo> tipos = new ArrayList<>();
        ArrayList<Lugar> lugares = new ArrayList<>();
        ArrayList<Idioma> idiomas = new ArrayList<>();
        ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
        ArrayList<Publicacion> publicaciones = new ArrayList<>();

        //GRUPOS
        Grupo grupo1 = new Grupo("Grupo 1", "Descripción 1");
        Grupo grupo2 = new Grupo("Grupo 2", "Descripción 2");
        Grupo grupo3 = new Grupo("Grupo 3", "Descripción 3");
        Grupo grupo4 = new Grupo("Grupo 4", "Descripción 4");
        Grupo grupo5 = new Grupo("Grupo 5", "Descripción 5");
        Grupo grupo6 = new Grupo("grupo 5", "Descripción 6");
        Grupo grupo7 = new Grupo("Grupo 7", "Descripción 7");

        if(!grupos.contains(grupo1))
            grupos.add(grupo1);
        if(!grupos.contains(grupo2))
            grupos.add(grupo2);
        if(!grupos.contains(grupo3))
            grupos.add(grupo3);
        if(!grupos.contains(grupo4))
            grupos.add(grupo4);
        if(!grupos.contains(grupo5))
            grupos.add(grupo5);
        if(!grupos.contains(grupo6))
            grupos.add(grupo6);
        if(!grupos.contains(grupo7))
            grupos.add(grupo7);
      
//        System.out.println("----Grupos----");
//        for(Grupo g : grupos)
//            g.mostrar();
        //GRUPOS
        
        //ALUMNOS
        Autor alumno1 = new Alumno(1, "Apellido1", "Nombre1", "Clave1", "1");
        Autor alumno2 = new Alumno(2, "Apellido2", "Nombre2", "Clave2", "2");
        Autor alumno3 = new Alumno(3, "Apellido3", "Nombre3", "Clave3", "3");
        Autor alumno4 = new Alumno(4, "Apellido4", "Nombre4", "Clave4", "4");
        Autor alumno5 = new Alumno(5, "Apellido5", "Nombre5", "Clave5", "3");  //cx repetido
        Autor alumno6 = new Alumno(6, "Apellido6", "Nombre5", "Clave5", "6");
        Autor alumno7 = new Alumno(2, "Apellido7", "Nombre7", "Clave7", "7");  //dni repetido

        if(!autores.contains(alumno1))
            autores.add(alumno1);
        if(!autores.contains(alumno2))
            autores.add(alumno2);
        if(!autores.contains(alumno3))
            autores.add(alumno3);
        if(!autores.contains(alumno4))
            autores.add(alumno4);
        if(!autores.contains(alumno5))
            autores.add(alumno5);
        if(!autores.contains(alumno6))
            autores.add(alumno6);
        if(!autores.contains(alumno7))
            autores.add(alumno7);
        
//        System.out.println("\n----Alumnos----\n");
//        for(Autor a : autores)
//            a.mostrar();
        //ALUMNOS
        
        //PROFESORES
        Autor profesor1 = new Profesor(10, "Apellido10", "Nombre10", "Clave10", Cargo.TITULAR);
        Autor profesor2 = new Profesor(20, "Apellido20", "Nombre20", "Clave20", Cargo.ASOCIADO);
        Autor profesor3 = new Profesor(30, "Apellido30", "Nombre30", "Clave30", Cargo.ADJUNTO);
        Autor profesor4 = new Profesor(4, "Apellido40", "Nombre40", "Clave40", Cargo.JTP);      //dni repetido de un alumno.
        Autor profesor5 = new Profesor(50, "Apellido50", "Nombre50", "Clave50", Cargo.ADG);
        Autor profesor6 = new Profesor(50, "Apellido60", "Nombre60", "Clave60", Cargo.ADJUNTO); //dni repetido.
        Autor profesor7 = new Profesor(70, "Apellido70", "Nombre70", "Clave70", Cargo.TITULAR);

        if(!autores.contains(profesor1))
            autores.add(profesor1);
        if(!autores.contains(profesor2))
            autores.add(profesor2);
        if(!autores.contains(profesor3))
            autores.add(profesor3);
        if(!autores.contains(profesor4))
            autores.add(profesor4);
        if(!autores.contains(profesor5))
            autores.add(profesor5);
        if(!autores.contains(profesor6))
            autores.add(profesor6);
        if(!autores.contains(profesor7))
            autores.add(profesor7);
        
//        System.out.println("\n----Profesores----\n");
//        for(Autor p : autores){
//            if(p instanceof Profesor)
//                p.mostrar();
//        }

        System.out.println("Agrego miembros a grupo2 y muestro:");
        grupo2.agregarMiembro(alumno7, Rol.COLABORADOR);
        grupo2.agregarMiembro(alumno7, Rol.ADMINISTRADOR);
        grupo2.agregarMiembro(profesor3, Rol.ADMINISTRADOR);
        grupo2.mostrar();
        //PROFESORES    
        
        System.out.println("\nAgrego grupos a profesor3 y muestro:");
        profesor3.agregarGrupo(grupo7, Rol.COLABORADOR);
        profesor3.agregarGrupo(grupo7, Rol.ADMINISTRADOR);
        profesor3.mostrar();
        
        System.out.println("\nAgrego grupos a profesor2 y muestro:");
        profesor2.agregarGrupo(grupo7, Rol.COLABORADOR);
        profesor2.mostrar();
        
//        System.out.println("\nMuestro grupo7 como quedó:");
//        grupo7.mostrar();
//        
//        System.out.println("\nQuito profesor3 de grupo7 y muestro:");
////        profesor3.quitarGrupo(grupo7);
////        profesor3.mostrar();
//        grupo7.quitarMiembro(profesor3);
//        grupo7.mostrar();
//        
        //TIPOS DE PUBLICACION
//        System.out.println("\n----Tipos de publicación----\n");
        Tipo tipo1 = new Tipo("Tipo 1");
        Tipo tipo2 = new Tipo("Tipo 2");
        Tipo tipo3 = new Tipo("Tipo 3");
        Tipo tipo4 = new Tipo("Tipo 4");
        Tipo tipo5 = new Tipo("Tipo 4"); //repetido.
        Tipo tipo6 = new Tipo("Tipo 6");
        Tipo tipo7 = new Tipo("tipo 2"); //repetido con minuscula.
        
        if(!tipos.contains(tipo1))
            tipos.add(tipo1);
        if(!tipos.contains(tipo2))
            tipos.add(tipo2);
        if(!tipos.contains(tipo3))
            tipos.add(tipo3);
        if(!tipos.contains(tipo4))
            tipos.add(tipo4);
        if(!tipos.contains(tipo5))
            tipos.add(tipo5);
        if(!tipos.contains(tipo6))
            tipos.add(tipo6);
        if(!tipos.contains(tipo7))
            tipos.add(tipo7);
        
//        for(Tipo t : tipos)
//            System.out.println(t);
    
        //TIPOS DE PUBLICACION
        
        //LUGARES
//        System.out.println("\n----Lugares----\n");
        Lugar lugar1 = new Lugar("Lugar 1");
        Lugar lugar2 = new Lugar("Lugar 2");
        Lugar lugar3 = new Lugar("Lugar 3");
        Lugar lugar4 = new Lugar("Lugar 4");
        Lugar lugar5 = new Lugar("Lugar 4"); //repetido.
        Lugar lugar6 = new Lugar("Lugar 6");
        Lugar lugar7 = new Lugar("lugar 3"); //repetido con minuscula.

        if(!lugares.contains(lugar1))
        lugares.add(lugar1);
        if(!lugares.contains(lugar2))
        lugares.add(lugar2);
        if(!lugares.contains(lugar3))
        lugares.add(lugar3);
        if(!lugares.contains(lugar4))
        lugares.add(lugar4);
        if(!lugares.contains(lugar5))
        lugares.add(lugar5);
        if(!lugares.contains(lugar6))
        lugares.add(lugar6);
        if(!lugares.contains(lugar7))
        lugares.add(lugar7);

//        for(Lugar l : lugares)
//            System.out.println(l);
        //LUGARES
        
        //IDIOMAS        
//        System.out.println("\n----Idiomas----\n");
        Idioma idioma1 = new Idioma("Idioma 1");
        Idioma idioma2 = new Idioma("Idioma 2");
        Idioma idioma3 = new Idioma("Idioma 3");
        Idioma idioma4 = new Idioma("Idioma 4");
        Idioma idioma5 = new Idioma("Idioma 3");  //repetido.
        Idioma idioma6 = new Idioma("Idioma 6");  
        Idioma idioma7 = new Idioma("idioma 2");  //repetido con minuscula.

        if(!idiomas.contains(idioma1))
            idiomas.add(idioma1);
        if(!idiomas.contains(idioma2))
            idiomas.add(idioma2);
        if(!idiomas.contains(idioma3))
            idiomas.add(idioma3);
        if(!idiomas.contains(idioma4))
            idiomas.add(idioma4);
        if(!idiomas.contains(idioma5))
            idiomas.add(idioma5);
        if(!idiomas.contains(idioma6))
            idiomas.add(idioma6);
        if(!idiomas.contains(idioma7))
            idiomas.add(idioma7);

//        for(Idioma i : idiomas)
//            System.out.println(i);        
        //IDIOMAS
        
        //PALABRAS CLAVE
//        System.out.println("\n----Palabras clave----\n");
        PalabraClave palabraClave1 = new PalabraClave("PalabraClave1");
        PalabraClave palabraClave2 = new PalabraClave("PalabraClave2");
        PalabraClave palabraClave3 = new PalabraClave("PalabraClave3");
        PalabraClave palabraClave4 = new PalabraClave("PalabraClave4");
        PalabraClave palabraClave5 = new PalabraClave("PalabraClave1");  //repetido.
        PalabraClave palabraClave6 = new PalabraClave("PalabraClave6");
        PalabraClave palabraClave7 = new PalabraClave("palabraclave1");  //repetido con minuscula.

        if(!palabrasClaves.contains(palabraClave1))
            palabrasClaves.add(palabraClave1);
        if(!palabrasClaves.contains(palabraClave2))
            palabrasClaves.add(palabraClave2);
        if(!palabrasClaves.contains(palabraClave3))
            palabrasClaves.add(palabraClave3);
        if(!palabrasClaves.contains(palabraClave4))
            palabrasClaves.add(palabraClave4);
        if(!palabrasClaves.contains(palabraClave5))
            palabrasClaves.add(palabraClave5);
        if(!palabrasClaves.contains(palabraClave6))
            palabrasClaves.add(palabraClave6);
        if(!palabrasClaves.contains(palabraClave7))
            palabrasClaves.add(palabraClave7);

//        for(PalabraClave pc : palabrasClaves)
//            System.out.println(pc); 
        //PALABRAS CLAVE
        
        //PUBLICACIONES
        /*
        Para un objeto de la clase publicación:
        Titulo
        Miembro en grupo
        Fecha
        Tipo
        Idioma
        Lugar
        Lista de palabras clave
        Enlace
        Resumen
        */
                
        Publicacion publicacion1 = new Publicacion("Título 1", new MiembroEnGrupo(alumno5, grupo1, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo1, idioma1, lugar1, Arrays.asList(new PalabraClave[] {palabraClave1, palabraClave2, palabraClave3}), "Enlace 1", "Resumen 1");
        Publicacion publicacion2 = new Publicacion("Título 2", new MiembroEnGrupo(profesor2, grupo1, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo2, idioma2, lugar2, Arrays.asList(new PalabraClave[] {palabraClave4, palabraClave5}), "Enlace 2", "Resumen 2");
        Publicacion publicacion3 = new Publicacion("Título 2", new MiembroEnGrupo(alumno1, grupo2, Rol.COLABORADOR), LocalDate.of(2020, 06, 24), tipo1, idioma2, lugar2, Arrays.asList(new PalabraClave[] {palabraClave2, palabraClave4, palabraClave5}), "Enlace 3", "Resumen 3");
        Publicacion publicacion4 = new Publicacion("Título 4", new MiembroEnGrupo(profesor4, grupo3, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo4, idioma2, lugar5, Arrays.asList(new PalabraClave[] {palabraClave1}), "Enlace 4", "Resumen 4");
        Publicacion publicacion5 = new Publicacion("título 4", new MiembroEnGrupo(profesor4, grupo5, Rol.COLABORADOR), LocalDate.of(2020, 06, 24), tipo5, idioma3, lugar5, Arrays.asList(new PalabraClave[] {palabraClave2, palabraClave3, palabraClave4}), "Enlace 5", "Resumen 5");
        Publicacion publicacion6 = new Publicacion("Título 6", new MiembroEnGrupo(profesor4, grupo6, Rol.COLABORADOR), LocalDate.of(2020, 06, 24), tipo6, idioma3, lugar6, Arrays.asList(new PalabraClave[] {palabraClave2, palabraClave3, palabraClave4}), "Enlace 6", "Resumen 6");
        Publicacion publicacion7 = new Publicacion("Título 7", new MiembroEnGrupo(profesor5, grupo7, Rol.COLABORADOR), LocalDate.of(2020, 06, 24), tipo7, idioma3, lugar7, Arrays.asList(new PalabraClave[] {palabraClave3, palabraClave3, palabraClave2}), "Enlace 7", "Resumen 7");
        
        if(!publicaciones.contains(publicacion1))
            publicaciones.add(publicacion1);
        if(!publicaciones.contains(publicacion2))
            publicaciones.add(publicacion2);
        if(!publicaciones.contains(publicacion3))
            publicaciones.add(publicacion3);
        if(!publicaciones.contains(publicacion4))
            publicaciones.add(publicacion4);
        if(!publicaciones.contains(publicacion5))
            publicaciones.add(publicacion5);
        if(!publicaciones.contains(publicacion6))
            publicaciones.add(publicacion6);
        if(!publicaciones.contains(publicacion7))
            publicaciones.add(publicacion7);
      
//        System.out.println("\n----Publicaciones----\n");
//        for(Publicacion p : publicaciones) {
//            p.mostrar();
//            System.out.println();
//        }
        //PUBLICACIONES

      //</editor-fold>   
     //<editor-fold defaultstate="collapsed" desc="Intefaz gráfica"> 
//        VentanaAMGrupo ventanaGrupo = new VentanaAMGrupo(null); //se instancia la ventana
//        ventanaGrupo.setLocationRelativeTo(null); //se centra la ventana
//        ventanaGrupo.setVisible(true); //se hace visible la ventana
//        
//        VentanaAMAlumno ventanaAlumno = new VentanaAMAlumno(null); //se instancia la ventana
//        ventanaAlumno.setLocationRelativeTo(null); //se centra la ventana
//        ventanaAlumno.setVisible(true); //se hace visible la ventana
//        
//        VentanaAMProfesor ventanaProfesor = new VentanaAMProfesor(null); //se instancia la ventana
//        ventanaProfesor.setLocationRelativeTo(null); //se centra la ventana
//        ventanaProfesor.setVisible(true); //se hace visible la ventana        
//       
//        VentanaAIdioma ventanaIdioma = new VentanaAIdioma(null); //se instancia la ventana
//        ventanaIdioma.setLocationRelativeTo(null); //se centra la ventana
//        ventanaIdioma.setVisible(true); //se hace visible la ventana                
//        
//        VentanaALugar ventanaLugar = new VentanaALugar(null); //se instancia la ventana
//        ventanaLugar.setLocationRelativeTo(null); //se centra la ventana
//        ventanaLugar.setVisible(true); //se hace visible la ventana                        
//        
//        VentanaAPalabraClave ventanaPalabraClave = new VentanaAPalabraClave(null); //se instancia la ventana
//        ventanaPalabraClave.setLocationRelativeTo(null); //se centra la ventana
//        ventanaPalabraClave.setVisible(true); //se hace visible la ventana                                
//        
//        VentanaATipo ventanaTipo = new VentanaATipo(null); //se instancia la ventana
//        ventanaTipo.setLocationRelativeTo(null); //se centra la ventana
//        ventanaTipo.setVisible(true); //se hace visible la ventana   

     //</editor-fold>
    
    }
}
