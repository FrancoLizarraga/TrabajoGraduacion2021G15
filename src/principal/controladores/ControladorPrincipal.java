/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import autores.modelos.Profesor;
import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.Idioma;
import interfaces.IGestorAutores;
import interfaces.IGestorGrupos;
import interfaces.IGestorIdiomas;
import interfaces.IGestorLugares;
import interfaces.IGestorPalabrasClaves;
import interfaces.IGestorPublicaciones;
import interfaces.IGestorTipos;
import static java.lang.System.out;
import java.time.LocalDate;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.Publicacion;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;


/**
 *
 * @author prog2
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
    
     //<editor-fold defaultstate="collapsed" desc="Sin intefaz gráfica"> 
     
//        System.out.println("\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR AUTORES");
//        System.out.println("\t----------------------------------------------");
//        IGestorAutores ga=GestorAutores.instanciar();
//        System.out.println("\n\tmethod nuevoAutor (Para profesores)\n");
//        
////      PROFESORES
//        System.out.println(ga.nuevoAutor(1, "apellido1", "nombre1", Cargo.ADJUNTO, "clave1", "clave1"));//se agrega
//        System.out.println(ga.nuevoAutor(1, "apellido1", "nombre1", Cargo.ADG, "clave1", "clave1"));//repetido
//        System.out.println(ga.nuevoAutor(0, "apellido1", "nombre1", Cargo.ADJUNTO, "clave1", "clave1"));//dni nulo
//        System.out.println(ga.nuevoAutor(2, "", "nombre1", Cargo.ADJUNTO, "clave1", "clave1"));//apellido vacio
//        System.out.println(ga.nuevoAutor(3, "apellido1", "", Cargo.TITULAR, "clave1", "clave1"));//nombre vacio
//        System.out.println(ga.nuevoAutor(4, null, "nombre1", Cargo.ADJUNTO, "clave1", "clave1"));//apellido null
//        System.out.println(ga.nuevoAutor(5, "apellido1", null, Cargo.ASOCIADO, "clave1", "clave1"));//nombre null
//        System.out.println(ga.nuevoAutor(6, "apellido6", "nombre6", Cargo.ADJUNTO, "clave6", "clave6"));//se agrega
//
////      ALUMNOS
//        System.out.println("\n\tmethod nuevoAutor (Para alumnos)\n");
//        System.out.println(ga.nuevoAutor(5, "apellido1", "nombre1", "cx1", "clave1", "clave1"));//se agrega
//        System.out.println(ga.nuevoAutor(5, "apellido1", "nombre1", "cx2", "clave1", "clave1"));//dni repetido
//        System.out.println(ga.nuevoAutor(0, "apellido1", "nombre1", "cx3", "clave1", "clave1"));//dni nulo
//        System.out.println(ga.nuevoAutor(2, "", "nombre1", "cx4", "clave1", "clave1"));//apellido vacio
//        System.out.println(ga.nuevoAutor(3, "apellido1", "", "cx5", "clave1", "clave1"));//nombre vacio
//        System.out.println(ga.nuevoAutor(4, null, "nombre1", "cx6", "clave1", "clave1"));//apellido null
//        System.out.println(ga.nuevoAutor(5, "apellido1", null, "cx7", "clave1", "clave1"));//nombre null
//        System.out.println(ga.nuevoAutor(7, "apellido5", "nombre5", "cx1", "clave1", "clave1"));//cx repetido con el primero
//        System.out.println(ga.nuevoAutor(8, "apellido8", "nombre8", "cx8", "clave8", "clave8"));
//        
//        System.out.println("\n\tmethod modificarAutor(Para profesores)\n");
//        
//        System.out.println(ga.modificarAutor(ga.verAutor(1), "apellido modi", "nombre1 modi", Cargo.TITULAR, "clave1 mod", "clave1 mod")+"\n\tNombre y Apellido modificado: "+ga.verAutor(1).verNombres()+" "+ga.verAutor(1).verApellidos()+" "+ga.verAutor(1).verClave());//se debe modificar
//        System.out.println(ga.modificarAutor(ga.verAutor(6), "", "nombre6 modi", Cargo.JTP, "clave6 mod", "clave6 mod"));//apellido vacio
//        System.out.println(ga.modificarAutor(ga.verAutor(6), "apellido modi", "", Cargo.TITULAR, "clave6 mod", "clave6 mod"));//nombre vacio
//        System.out.println(ga.modificarAutor(ga.verAutor(6), null, "nombre6 modi", Cargo.ASOCIADO, "clave6 mod", "clave6 mod"));//apellido nulo
//        System.out.println(ga.modificarAutor(ga.verAutor(6), "apellido modi", null, Cargo.ADG, "clave6 mod", "clave6 mod"));//nombre nulo
//                
//        System.out.println("\n\tmethod modificarAutor(Para alumnos)\n");
//        
//        System.out.println(ga.modificarAutor(ga.verAutor(5), "apellido modi", "nombre1 modi", "cx mod", "clave1 mod", "clave1 mod")+"\n\tNombre y Apellido modificado: "+ga.verAutor(1).verNombres()+" "+ga.verAutor(1).verApellidos()+" "+ga.verAutor(1).verClave());//se debe modificar
//        System.out.println(ga.modificarAutor(ga.verAutor(8), "", "nombre6 modi", "cx mod", "clave6 mod", "clave6 mod"));//apellido vacio
//        System.out.println(ga.modificarAutor(ga.verAutor(8), "apellido modi", "", "cx mod", "clave6 mod", "clave6 mod"));//nombre vacio
//        System.out.println(ga.modificarAutor(ga.verAutor(8), "", "nombre6 modi", "cx mod", "clave6 mod", "clave6 mod"));//apellido nulo
//        System.out.println(ga.modificarAutor(ga.verAutor(8), "apellido modi", null, "cx mod", "clave6 mod", "clave6 mod"));//nombre nulo
//        System.out.println(ga.modificarAutor(ga.verAutor(8), "apellido modi", "nombre mod", "", "clave6 mod", "clave6 mod"));//cx vacio
//        
//        System.out.println("\n\tmethod existeEsteautor\n");
//        
//        System.out.println("El autor existe: "+ga.existeEsteAutor(ga.verAutor(1)));//true
//        System.out.println("El autor existe: "+ga.existeEsteAutor(new Profesor(24,"apellido","nombre","clave",Cargo.ADG)));//false
//        
//        System.out.println("\n\tmethod verAutores\n");
//        System.out.println("Lista de todos los autores:");
//        for(Autor a : ga.verAutores())
//            a.mostrar();
//        
//        System.out.println("\n\tmethod verProfesores");
//        for(Profesor p: ga.verProfesores())
//            p.mostrar();
//        
//        System.out.println("\n\tmethod verAlumnos");
//        for(Alumno a: ga.verAlumnos())
//            a.mostrar();
//        
//        System.out.println("\n\tmethod verAutor(dni)\n");
//        System.out.println(ga.verAutor(1).verApellidos());//true muestra el apellido
//        System.out.println(ga.verAutor(6).verApellidos());//true muestra el apellido
//        System.out.println(ga.verAutor(19));//false devuelve null
//        
//        
////      Prueba Gestor Grupo.
//        System.out.println("\n\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR GRUPOS");
//        System.out.println("\t----------------------------------------------");
//        IGestorGrupos g=GestorGrupos.instanciar();
//        System.out.println("\n\tmethod nuevoGrupo\n");
//        
//        System.out.println(g.nuevoGrupo("grupo1", "descripcion1"));
//        System.out.println(g.nuevoGrupo("grupo2", "descripcion2"));
//        System.out.println(g.nuevoGrupo("grupo1", "descripcion3"));//repetido
//        System.out.println(g.nuevoGrupo("", "descripcion1"));//vacia
//        System.out.println(g.nuevoGrupo(null, "descripcion1"));//null
//        
//        System.out.println("\n\tmethod modificarGrupo\n");
//        System.out.println("La descripcion original del "+ g.verGrupo("grupo1").verNombre() + " es: "+g.verGrupo("grupo1").verDescripcion());
//        System.out.println(g.modificarGrupo(g.verGrupo("grupo1"), "descripcion modificada trr")+"\n\tLa nueva descripcion del "+ g.verGrupo("grupo1").verNombre() + " es: "+g.verGrupo("grupo1").verDescripcion());
//        System.out.println(g.modificarGrupo(g.verGrupo("grupo5"),"descripcion nueva"));//no lo encuentra
//        
//        System.out.println("\n\tmethod verGrupos");
//        for(Grupo gr : g.verGrupos())
//            gr.mostrar();
//        
//        System.out.println("\n\tmethod verGrupo\n");
//        
//        System.out.println(g.verGrupo("grupo1").verNombre());//devuelve el nombre del grupo
//        System.out.println(g.verGrupo("grupo5"));//devuelve null
//        
//        System.out.println("\n\tmethod existeEsteGrupo\n");
//        System.out.println("Existe el grupo1: "+g.existeEsteGrupo(g.verGrupo("grupo1")));//true
//        System.out.println("Existe el grupo5: "+g.existeEsteGrupo(g.verGrupo("grupo5")));//false
//        System.out.println("Existe el grupo6: "+g.existeEsteGrupo(new Grupo("grupo6","descripcion 6")));//false
//
//      Gestor Idiomas
        System.out.println("\n\t----------------------------------------------");
        System.out.println("\t\t\tGESTOR IDIOMAS");
        System.out.println("\t----------------------------------------------");
        IGestorIdiomas gi=GestorIdiomas.instanciar();
        System.out.println("\n\tmethod nuevoIdioma\n");
        
        System.out.println(gi.nuevoIdioma("idioma1"));
        System.out.println(gi.nuevoIdioma("idioma2"));
        System.out.println(gi.nuevoIdioma("idioma1"));//repetido
        System.out.println(gi.nuevoIdioma(""));//vacio
        System.out.println(gi.nuevoIdioma("Aleman"));//nuevo idioma para tp6
        System.out.println(gi.nuevoIdioma("Castellano"));//nuevo idioma para tp6
        System.out.println(gi.nuevoIdioma(null));//null
        
        System.out.println("\n\tmethod verIdiomas\n");
        System.out.println("Los idiomas son:");
        for(Idioma id : gi.verIdiomas())
            System.out.println("\t"+id.toString());
        
        System.out.println("\n\tmethod verIdioma\n");
        System.out.println("El idioma es: "+gi.verIdioma("idioma1"));
        System.out.println("El idioma es: "+gi.verIdioma("idioma5"));
        
        System.out.println("\n\tmethod buscarIdiomas\n");
        for(Idioma i : gi.buscarIdiomas("idiom"))
                System.out.println("\t" + i.toString());
        
        System.out.println("\n\tmethod existeEsteIdioma\n");
        System.out.println("El idioma Castellano existe: "+ gi.existeEsteIdioma(gi.verIdioma("Castellano")));//true
        
//      Gestor Lugares
//        System.out.println("\n\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR LUGAR");
//        System.out.println("\t----------------------------------------------");
//        IGestorLugares gl= GestorLugares.instanciar();
//              
//        System.out.println("\n\tmethod nuevoLugar\n");
//        System.out.println(gl.nuevoLugar("lugar1"));
//        System.out.println(gl.nuevoLugar("lugar2"));
//        System.out.println(gl.nuevoLugar("lugar1"));//repetido
//        System.out.println(gl.nuevoLugar(""));//vacia
//        System.out.println(gl.nuevoLugar("Aula"));          //nueva palabra clave para tp6
//        System.out.println(gl.nuevoLugar("Anfiteatro"));    //nueva palabra clave para tp6
//        System.out.println(gl.nuevoLugar(null));
//        
//        System.out.println("\n\tmethod verLugares\n");
//        System.out.println("Los lugares son:");
//        for(Lugar l : gl.verLugares())
//            System.out.println("\t" + l.verNombre());
//        
//        System.out.println("\n\tmethod verLugar\n");
//        System.out.println("El lugar es: "+gl.verLugar("lugar1"));
//        System.out.println("El lugar es: "+gl.verLugar("lugar5"));//no lo encuentra, devuelve null
//        
//        System.out.println("\n\tmethod buscarLugares\n");
//        for(Lugar l : gl.buscarLugares("lugar"))
//                System.out.println("\t" + l.toString());
//        
//        System.out.println("\n\tmethod existeEsteLugar\n");
//        System.out.println("El lugar Anfiteatro existe: "+ gl.existeEsteLugar(gl.verLugar("Anfiteatro")));//true
        
//      Gestor Palabras Claves
//        System.out.println("\n\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR PALABRAS CLAVES");
//        System.out.println("\t----------------------------------------------");
//        IGestorPalabrasClaves pc=GestorPalabrasClaves.instanciar();
//        
//        System.out.println("\n\tmethod nuevaPalabraClave\n");
//        System.out.println(pc.nuevaPalabraClave("palabraClave1"));
//        System.out.println(pc.nuevaPalabraClave("palabraClave2"));
//        System.out.println(pc.nuevaPalabraClave("palabraClave1"));//repetida
//        System.out.println(pc.nuevaPalabraClave(""));//vacia
//        System.out.println(pc.nuevaPalabraClave("Hola"));       //nueva palabra clave para tp6
//        System.out.println(pc.nuevaPalabraClave("Alcance"));    //nueva palabra clave para tp6
//        System.out.println(pc.nuevaPalabraClave(null));//nula
//        
//        System.out.println("\n\tmethod verPalabrasClaves\n");
//         System.out.println("Las palabras claves son:");
//        for(PalabraClave p : pc.verPalabrasClaves())
//            System.out.println("\t" + p.toString());
//        
//        System.out.println("\n\tmethod verPalabraClave\n");
//        System.out.println("La palabra clave es: "+pc.verPalabraClave("palabraClave1"));
//        System.out.println("La palabra clave es: "+pc.verPalabraClave("palabraClave5"));//no existe
//        
//        System.out.println("\n\tmethod buscarPalabrasClaves\n");
//        for(PalabraClave p : pc.buscarPalabrasClaves("palabr"))
//                System.out.println("\t" + p.toString());
//        
//        System.out.println("\n\tmethod existeEstaPalabraClave\n");
//        System.out.println("La palabra clave Alcance existe: "+ pc.existeEstaPalabraClave(pc.verPalabraClave("Alcance")));//true
        
//      GESTOR TIPOS
//        System.out.println("\n\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR TIPOS");
//        System.out.println("\t----------------------------------------------");
//        IGestorTipos gt=GestorTipos.instanciar();
//        
//        System.out.println("\n\tmethod nuevoTipo\n");
//        System.out.println(gt.nuevoTipo("Tipo1"));
//        System.out.println(gt.nuevoTipo("Tipo2"));
//        System.out.println(gt.nuevoTipo("Tipo1"));//tipo repetido
//        System.out.println(gt.nuevoTipo(""));//cadena vacia
//        System.out.println(gt.nuevoTipo("Hola"));       //nuevo tipo para tp6
//        System.out.println(gt.nuevoTipo("Alcance"));    //nuevo tipo para tp6
//        System.out.println(gt.nuevoTipo(null));//nulo
//     
//        System.out.println("\n\tmethod verTipos\n");
//        System.out.println("Los tipos son:");
////        gt.verTipos();
//        for(Tipo t : gt.verTipos())
//            System.out.println("\t" + t.toString());
//        
//        System.out.println("\n\tmethod verTipo\n");
//        
//        System.out.println("El nombre del Tipo es: "+gt.verTipo("Tipo1"));//si existe devuelve el nombre Tipo1
//        System.out.println("El nombre del Tipo es: "+gt.verTipo("Tipo4"));//no existe devuelve null
//        
//        System.out.println("\n\tmethod buscarTipos\n");
//        for(Tipo t : gt.buscarTipos("tip"))
//                System.out.println("\t" + t.toString());
//        
//        System.out.println("\n\tmethod existeEsteTipo\n");
//        System.out.println("El Tipo Alcance existe: "+gt.existeEsteTipo(gt.verTipo("Alcance")));//true

//      GESTOR PUBLICACIONES
//        System.out.println("\n\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR PUBLICACIONES");
//        System.out.println("\t----------------------------------------------");
//        IGestorPublicaciones gp=GestorPublicaciones.instanciar();
//        
//        System.out.println("\n\tmethod nuevaPublicacion\n");
//        
//        System.out.println(gp.nuevaPublicacion("Titulo 1", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlace 1", "resumen1"));//lo agrega
//        System.out.println(gp.nuevaPublicacion("", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlace 1", "resumen1"));//titulo vacio
//        System.out.println(gp.nuevaPublicacion(null, new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlace 1", "resumen1"));// titulo null
//        System.out.println(gp.nuevaPublicacion("Titulo 2", null, LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlace 1", "resumen1"));//miembroEnGrupo null
//        System.out.println(gp.nuevaPublicacion("Titulo 1", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo2"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo2"), gi.verIdioma("idioma2"), gl.verLugar("lugar2"), pc.verPalabrasClaves(), "enlace 2", "resumen2"));//titulo repetido
//        System.out.println(gp.nuevaPublicacion("Titulo 2", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), null, gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlace 1", "resumen1"));//idioma null
//        System.out.println(gp.nuevaPublicacion("Titulo 2", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), null, pc.verPalabrasClaves(), "enlace 1", "resumen1"));//lugar null
//        System.out.println(gp.nuevaPublicacion("Titulo 2", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), null, "enlace 1", "resumen1"));//palabras claves null
//        System.out.println(gp.nuevaPublicacion("Titulo 2", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "", "resumen1"));//Enlace Vacio
//        System.out.println(gp.nuevaPublicacion("Titulo 2", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlace 1", ""));//Resumen Vacio
//        System.out.println(gp.nuevaPublicacion("Titulo 2", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo2"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo2"), gi.verIdioma("idioma2"), gl.verLugar("lugar2"), pc.verPalabrasClaves(), "enlace 2", "resumen2"));//lo agrega
//        
//        System.out.println("\n\tmethod modificarPublicacion\n");
//        System.out.println(gp.modificarPublicacion(gp.verPublicacion("Titulo 1"), new MiembroEnGrupo(ga.verAutor(5),g.verGrupo("grupo2"),Rol.ADMINISTRADOR), LocalDate.of(2021,8, 30), gt.verTipo("Tipo2"), gi.verIdioma("idioma2"), gl.verLugar("lugar2"), pc.verPalabrasClaves(), "Enlace mod", "resumen mod"));//modifica
//        System.out.println(gp.modificarPublicacion(null, new MiembroEnGrupo(ga.verAutor(5),g.verGrupo("grupo2"),Rol.ADMINISTRADOR), LocalDate.of(2021,8, 30), gt.verTipo("Tipo2"), gi.verIdioma("idioma2"), gl.verLugar("lugar2"), pc.verPalabrasClaves(), "Enlace mod", "resumen mod"));//Publicacion null
//        System.out.println(gp.modificarPublicacion(gp.verPublicacion("Titulo 1"), null, LocalDate.of(2021,8, 30), gt.verTipo("Tipo2"), gi.verIdioma("idioma2"), gl.verLugar("lugar2"), pc.verPalabrasClaves(), "Enlace mod", "resumen mod"));//miembroEnGrupo null
//        System.out.println(gp.modificarPublicacion(gp.verPublicacion("Titulo 1"), new MiembroEnGrupo(ga.verAutor(5),g.verGrupo("grupo2"),Rol.ADMINISTRADOR), null, gt.verTipo("Tipo2"), gi.verIdioma("idioma2"), gl.verLugar("lugar2"), pc.verPalabrasClaves(), "Enlace mod", "resumen mod"));// Fecha null
//        System.out.println(gp.modificarPublicacion(gp.verPublicacion("Titulo 1"), new MiembroEnGrupo(ga.verAutor(5),g.verGrupo("grupo2"),Rol.ADMINISTRADOR), LocalDate.of(2021,8, 30), gt.verTipo("Tipo2"), gi.verIdioma("idioma2"), null, pc.verPalabrasClaves(), "Enlace mod", "resumen mod"));//Lugar null
//        System.out.println(gp.modificarPublicacion(gp.verPublicacion("Titulo 1"), new MiembroEnGrupo(ga.verAutor(5),g.verGrupo("grupo2"),Rol.ADMINISTRADOR), LocalDate.of(2021,8, 30), gt.verTipo("Tipo2"), gi.verIdioma("idioma2"), gl.verLugar("lugar2"), null, "Enlace mod", "resumen mod"));//Palabras Claves null
//        System.out.println(gp.modificarPublicacion(gp.verPublicacion("Titulo 1"), new MiembroEnGrupo(ga.verAutor(5),g.verGrupo("grupo2"),Rol.ADMINISTRADOR), LocalDate.of(2021,8, 30), gt.verTipo("Tipo2"), gi.verIdioma("idioma2"), gl.verLugar("lugar2"), pc.verPalabrasClaves(), "", "resumen mod"));//Enlace vacio
//        System.out.println(gp.modificarPublicacion(gp.verPublicacion("Titulo 1"), new MiembroEnGrupo(ga.verAutor(5),g.verGrupo("grupo2"),Rol.ADMINISTRADOR), LocalDate.of(2021,8, 30), gt.verTipo("Tipo2"), gi.verIdioma("idioma2"), gl.verLugar("lugar2"), pc.verPalabrasClaves(), "Enlace mod", ""));//Resumen Vacio
//        
//        System.out.println("La Publicacion modificada es: ");
//            gp.verPublicacion("Titulo 1").mostrar();
//            
//        System.out.println("\n\tmethod hayPublicacionesConEstaPalabraClave\n");
//        System.out.println("La palabraClave1: "+gp.hayPublicacionesConEstaPalabraClave(pc.verPalabraClave("palabraClave1")));//true
//        System.out.println("La palabraClave5: "+gp.hayPublicacionesConEstaPalabraClave(pc.verPalabraClave("palabraClave5")));//false
//        System.out.println("La palabraClave2: "+gp.hayPublicacionesConEstaPalabraClave(pc.verPalabraClave("palabraClave2")));//true
//        
//        System.out.println("\n\tmethod hayPublicacionesConEsteLugar\n");
//        System.out.println("El lugar2: "+gp.hayPublicacionesConEsteLugar(gl.verLugar("lugar2")));//true
//        System.out.println("El lugar5: "+gp.hayPublicacionesConEsteLugar(gl.verLugar("lugar5")));//false
//        
//        System.out.println("\n\tmethod hayPublicacionesConEsteIdioma\n");
//        System.out.println("El idioma2: "+gp.hayPublicacionesConEsteIdioma(gi.verIdioma("idioma2")));//true
//        System.out.println("El idioma5: "+gp.hayPublicacionesConEsteIdioma(gi.verIdioma("idioma5")));//false
//        
//        System.out.println("\n\tmethod hayPublicacionesConEsteAutor\n");
//        System.out.println("El autor apellido modi nombre modi: "+gp.hayPublicacionesConEsteAutor(ga.verAutor(5)));//true
//        System.out.println("El autor apellido con dni 25: "+gp.hayPublicacionesConEsteAutor(ga.verAutor(25)));//false
//        
//        System.out.println("\n\tmethod ExisteEstaPublicacion\n");
//        System.out.println("LA Publicacion Titulo1 existe: "+gp.existeEstaPublicacion(gp.verPublicacion("Titulo 1")));//true
//        System.out.println("LA Publicacion Titulo25 existe: "+gp.existeEstaPublicacion(gp.verPublicacion("Titulo 25")));//false
//        
//        System.out.println("\n\tmethod verPublicaciones\n");
//        for(Publicacion pb: gp.verPublicaciones())
//            pb.mostrar();
//        
//        System.out.println("\n\tmethod verPublicacion\n");
//        gp.verPublicacion("Titulo 2").mostrar();
        
//        ArrayList<Autor> autores = new ArrayList<>();
//        ArrayList<Grupo> grupos = new ArrayList<>();
////        ArrayList<Alumno> alumnos = new ArrayList<>();
////        ArrayList<Profesor> profesores = new ArrayList<>();
//        ArrayList<Tipo> tipos = new ArrayList<>();
//        ArrayList<Lugar> lugares = new ArrayList<>();
//        ArrayList<Idioma> idiomas = new ArrayList<>();
//        ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
//        ArrayList<Publicacion> publicaciones = new ArrayList<>();
//
//        //GRUPOS
//        Grupo grupo1 = new Grupo("Grupo 1", "Descripción 1");
//        Grupo grupo2 = new Grupo("Grupo 2", "Descripción 2");
//        Grupo grupo3 = new Grupo("Grupo 3", "Descripción 3");
//        Grupo grupo4 = new Grupo("Grupo 4", "Descripción 4");
//        Grupo grupo5 = new Grupo("Grupo 5", "Descripción 5");
//        Grupo grupo6 = new Grupo("grupo 5", "Descripción 6");
//
//        if(!grupos.contains(grupo1))
//            grupos.add(grupo1);
//        if(!grupos.contains(grupo2))
//            grupos.add(grupo2);
//        if(!grupos.contains(grupo3))
//            grupos.add(grupo3);
//        if(!grupos.contains(grupo4))
//            grupos.add(grupo4);
//        if(!grupos.contains(grupo5))
//            grupos.add(grupo5);
//        if(!grupos.contains(grupo6))
//            grupos.add(grupo6);
//      
////        System.out.println("----Grupos----");
////        for(Grupo g : grupos)
////            g.mostrar();
//        //GRUPOS
//        
//        //ALUMNOS
//        Autor alumno1 = new Alumno(1, "Apellido1", "Nombre1", "Clave1", "1");
//        Autor alumno2 = new Alumno(2, "Apellido2", "Nombre2", "Clave2", "2");
//        Autor alumno3 = new Alumno(3, "Apellido3", "Nombre3", "Clave3", "3");
//        Autor alumno4 = new Alumno(4, "Apellido4", "Nombre4", "Clave4", "4");
//        Autor alumno5 = new Alumno(5, "Apellido5", "Nombre5", "Clave5", "3");  //cx repetido
//        Autor alumno6 = new Alumno(6, "Apellido6", "Nombre5", "Clave5", "6");
//        Autor alumno7 = new Alumno(2, "Apellido7", "Nombre7", "Clave7", "7");  //dni repetido
//
//        if(!autores.contains(alumno1))
//            autores.add(alumno1);
//        if(!autores.contains(alumno2))
//            autores.add(alumno2);
//        if(!autores.contains(alumno3))
//            autores.add(alumno3);
//        if(!autores.contains(alumno4))
//            autores.add(alumno4);
//        if(!autores.contains(alumno5))
//            autores.add(alumno5);
//        if(!autores.contains(alumno6))
//            autores.add(alumno6);
//        if(!autores.contains(alumno7))
//            autores.add(alumno7);
//        
////        System.out.println("\n----Alumnos----\n");
////        for(Autor a : autores)
////            a.mostrar();
//        //ALUMNOS
//        
//        //PROFESORES
//        Autor profesor1 = new Profesor(10, "Apellido10", "Nombre10", "Clave10", Cargo.TITULAR);
//        Autor profesor2 = new Profesor(20, "Apellido20", "Nombre20", "Clave20", Cargo.ASOCIADO);
//        Autor profesor3 = new Profesor(30, "Apellido30", "Nombre30", "Clave30", Cargo.ADJUNTO);
//        Autor profesor4 = new Profesor(4, "Apellido40", "Nombre40", "Clave40", Cargo.JTP);      //dni repetido de un alumno.
//        Autor profesor5 = new Profesor(50, "Apellido50", "Nombre50", "Clave50", Cargo.ADG);
//        Autor profesor6 = new Profesor(50, "Apellido60", "Nombre60", "Clave60", Cargo.ADJUNTO); //dni repetido.
//        Autor profesor7 = new Profesor(70, "Apellido70", "Nombre70", "Clave70", Cargo.TITULAR);
//
//        if(!autores.contains(profesor1))
//            autores.add(profesor1);
//        if(!autores.contains(profesor2))
//            autores.add(profesor2);
//        if(!autores.contains(profesor3))
//            autores.add(profesor3);
//        if(!autores.contains(profesor4))
//            autores.add(profesor4);
//        if(!autores.contains(profesor5))
//            autores.add(profesor5);
//        if(!autores.contains(profesor6))
//            autores.add(profesor6);
//        if(!autores.contains(profesor7))
//            autores.add(profesor7);
//        
////        System.out.println("\n----Profesores----\n");
////        for(Autor p : autores){
////            if(p instanceof Profesor)
////                p.mostrar();
////        }
//
//        /*Main parte 3*/
//        /*Luego de crear grupos y autores, tomar 1 grupo y agregarle 2 autores 
//        como miembros. Mostrar el grupo verificando que tenga los miembros 
//        asignados. Verificar también que no se pueda agregar 
//        un mismo autor más de una vez, por más que sean en roles distintos.*/
//        grupo1.agregarMiembro(profesor1, Rol.ADMINISTRADOR);
//        grupo1.agregarMiembro(profesor1, Rol.COLABORADOR); //autor repetido
//        grupo1.agregarMiembro(alumno1, Rol.COLABORADOR);
//        grupo1.mostrar(); 
//        
//        /*Tomar 1 de los 2 autores que se asignó al grupo anterior y 
//        agregarlo a otro grupo distinto. 
//        Mostrar los 2 autores verificando que pertenezcan a los grupos
//        a los que fueron asignados. 
//        Verificar también que no se pueda agregarle a un autor 
//        un mismo grupo más de una vez, por más que sean roles distintos.*/
//
//        profesor1.agregarGrupo(grupo2, Rol.COLABORADOR);
//        profesor1.agregarGrupo(grupo2, Rol.ADMINISTRADOR); //grupo repetido
//        profesor1.mostrar();
//        alumno1.mostrar();
//        
//        /*
//        Tomar el grupo al que se le agregaron los 2 autores como miembros, 
//        quitarle 1 y mostrarlo, verificando que el autor 
//        ya no es miembro del grupo.
//        */
//        grupo1.quitarMiembro(profesor1);
//        grupo1.mostrar();
//        
//        /*
//        Crear un nuevo grupo para los super administradores. 
//        Este grupo DEBE llevar por nombre "Super Administradores". 
//        Intentar asignarle como miembro un autor cualquiera
//        con el rol de colaborador, verificando que se lo
//        agrega pero con el rol de administrador.
//        */
//        Grupo grupo7 = new Grupo("Super Administradores", "Grupo para los super administradores"); //grupo para los super administradores
//        if (!grupos.contains(grupo7))
//            grupos.add(grupo7);
//        
//        grupo7.agregarMiembro(profesor1, Rol.COLABORADOR);
//        grupo7.mostrar();
//        
//        //TIPOS DE PUBLICACION
////        System.out.println("\n----Tipos de publicación----\n");
//        Tipo tipo1 = new Tipo("Tipo 1");
//        Tipo tipo2 = new Tipo("Tipo 2");
//        Tipo tipo3 = new Tipo("Tipo 3");
//        Tipo tipo4 = new Tipo("Tipo 4");
//        Tipo tipo5 = new Tipo("Tipo 4"); //repetido.
//        Tipo tipo6 = new Tipo("Tipo 6");
//        Tipo tipo7 = new Tipo("tipo 2"); //repetido con minuscula.
//        
//        if(!tipos.contains(tipo1))
//            tipos.add(tipo1);
//        if(!tipos.contains(tipo2))
//            tipos.add(tipo2);
//        if(!tipos.contains(tipo3))
//            tipos.add(tipo3);
//        if(!tipos.contains(tipo4))
//            tipos.add(tipo4);
//        if(!tipos.contains(tipo5))
//            tipos.add(tipo5);
//        if(!tipos.contains(tipo6))
//            tipos.add(tipo6);
//        if(!tipos.contains(tipo7))
//            tipos.add(tipo7);
//        
////        for(Tipo t : tipos)
////            System.out.println(t);
//    
//        //TIPOS DE PUBLICACION
//        
//        //LUGARES
////        System.out.println("\n----Lugares----\n");
//        Lugar lugar1 = new Lugar("Lugar 1");
//        Lugar lugar2 = new Lugar("Lugar 2");
//        Lugar lugar3 = new Lugar("Lugar 3");
//        Lugar lugar4 = new Lugar("Lugar 4");
//        Lugar lugar5 = new Lugar("Lugar 4"); //repetido.
//        Lugar lugar6 = new Lugar("Lugar 6");
//        Lugar lugar7 = new Lugar("lugar 3"); //repetido con minuscula.
//
//        if(!lugares.contains(lugar1))
//        lugares.add(lugar1);
//        if(!lugares.contains(lugar2))
//        lugares.add(lugar2);
//        if(!lugares.contains(lugar3))
//        lugares.add(lugar3);
//        if(!lugares.contains(lugar4))
//        lugares.add(lugar4);
//        if(!lugares.contains(lugar5))
//        lugares.add(lugar5);
//        if(!lugares.contains(lugar6))
//        lugares.add(lugar6);
//        if(!lugares.contains(lugar7))
//        lugares.add(lugar7);
//
////        for(Lugar l : lugares)
////            System.out.println(l);
//        //LUGARES
//        
//        //IDIOMAS        
////        System.out.println("\n----Idiomas----\n");
//        Idioma idioma1 = new Idioma("Idioma 1");
//        Idioma idioma2 = new Idioma("Idioma 2");
//        Idioma idioma3 = new Idioma("Idioma 3");
//        Idioma idioma4 = new Idioma("Idioma 4");
//        Idioma idioma5 = new Idioma("Idioma 3");  //repetido.
//        Idioma idioma6 = new Idioma("Idioma 6");  
//        Idioma idioma7 = new Idioma("idioma 2");  //repetido con minuscula.
//
//        if(!idiomas.contains(idioma1))
//            idiomas.add(idioma1);
//        if(!idiomas.contains(idioma2))
//            idiomas.add(idioma2);
//        if(!idiomas.contains(idioma3))
//            idiomas.add(idioma3);
//        if(!idiomas.contains(idioma4))
//            idiomas.add(idioma4);
//        if(!idiomas.contains(idioma5))
//            idiomas.add(idioma5);
//        if(!idiomas.contains(idioma6))
//            idiomas.add(idioma6);
//        if(!idiomas.contains(idioma7))
//            idiomas.add(idioma7);
//
////        for(Idioma i : idiomas)
////            System.out.println(i);        
//        //IDIOMAS
//        
//        //PALABRAS CLAVE
////        System.out.println("\n----Palabras clave----\n");
//        PalabraClave palabraClave1 = new PalabraClave("PalabraClave1");
//        PalabraClave palabraClave2 = new PalabraClave("PalabraClave2");
//        PalabraClave palabraClave3 = new PalabraClave("PalabraClave3");
//        PalabraClave palabraClave4 = new PalabraClave("PalabraClave4");
//        PalabraClave palabraClave5 = new PalabraClave("PalabraClave1");  //repetido.
//        PalabraClave palabraClave6 = new PalabraClave("PalabraClave6");
//        PalabraClave palabraClave7 = new PalabraClave("palabraclave1");  //repetido con minuscula.
//
//        if(!palabrasClaves.contains(palabraClave1))
//            palabrasClaves.add(palabraClave1);
//        if(!palabrasClaves.contains(palabraClave2))
//            palabrasClaves.add(palabraClave2);
//        if(!palabrasClaves.contains(palabraClave3))
//            palabrasClaves.add(palabraClave3);
//        if(!palabrasClaves.contains(palabraClave4))
//            palabrasClaves.add(palabraClave4);
//        if(!palabrasClaves.contains(palabraClave5))
//            palabrasClaves.add(palabraClave5);
//        if(!palabrasClaves.contains(palabraClave6))
//            palabrasClaves.add(palabraClave6);
//        if(!palabrasClaves.contains(palabraClave7))
//            palabrasClaves.add(palabraClave7);
//
////        for(PalabraClave pc : palabrasClaves)
////            System.out.println(pc); 
//        //PALABRAS CLAVE
//        
//        //PUBLICACIONES
//        /*
//        Para un objeto de la clase publicación:
//        Titulo
//        Miembro en grupo
//        Fecha
//        Tipo
//        Idioma
//        Lugar
//        Lista de palabras clave
//        Enlace
//        Resumen
//        */
//                
//        Publicacion publicacion1 = new Publicacion("Título 1", new MiembroEnGrupo(alumno5, grupo1, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo1, idioma1, lugar1, Arrays.asList(new PalabraClave[] {palabraClave1, palabraClave2, palabraClave3}), "Enlace 1", "Resumen 1");
//        Publicacion publicacion2 = new Publicacion("Título 2", new MiembroEnGrupo(profesor2, grupo1, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo2, idioma2, lugar2, Arrays.asList(new PalabraClave[] {palabraClave4, palabraClave5}), "Enlace 2", "Resumen 2");
//        Publicacion publicacion3 = new Publicacion("Título 2", new MiembroEnGrupo(alumno1, grupo2, Rol.COLABORADOR), LocalDate.of(2020, 06, 24), tipo1, idioma2, lugar2, Arrays.asList(new PalabraClave[] {palabraClave2, palabraClave4, palabraClave5}), "Enlace 3", "Resumen 3");
//        Publicacion publicacion4 = new Publicacion("Título 4", new MiembroEnGrupo(profesor4, grupo3, Rol.ADMINISTRADOR), LocalDate.of(2020, 06, 24), tipo4, idioma2, lugar5, Arrays.asList(new PalabraClave[] {palabraClave1}), "Enlace 4", "Resumen 4");
//        Publicacion publicacion5 = new Publicacion("título 4", new MiembroEnGrupo(profesor4, grupo5, Rol.COLABORADOR), LocalDate.of(2020, 06, 24), tipo5, idioma3, lugar5, Arrays.asList(new PalabraClave[] {palabraClave2, palabraClave3, palabraClave4}), "Enlace 5", "Resumen 5");
//        Publicacion publicacion6 = new Publicacion("Título 6", new MiembroEnGrupo(profesor4, grupo6, Rol.COLABORADOR), LocalDate.of(2020, 06, 24), tipo6, idioma3, lugar6, Arrays.asList(new PalabraClave[] {palabraClave2, palabraClave3, palabraClave4}), "Enlace 6", "Resumen 6");
//        Publicacion publicacion7 = new Publicacion("Título 7", new MiembroEnGrupo(profesor5, grupo7, Rol.COLABORADOR), LocalDate.of(2020, 06, 24), tipo7, idioma3, lugar7, Arrays.asList(new PalabraClave[] {palabraClave3, palabraClave3, palabraClave2}), "Enlace 7", "Resumen 7");
//        
//        if(!publicaciones.contains(publicacion1))
//            publicaciones.add(publicacion1);
//        if(!publicaciones.contains(publicacion2))
//            publicaciones.add(publicacion2);
//        if(!publicaciones.contains(publicacion3))
//            publicaciones.add(publicacion3);
//        if(!publicaciones.contains(publicacion4))
//            publicaciones.add(publicacion4);
//        if(!publicaciones.contains(publicacion5))
//            publicaciones.add(publicacion5);
//        if(!publicaciones.contains(publicacion6))
//            publicaciones.add(publicacion6);
//        if(!publicaciones.contains(publicacion7))
//            publicaciones.add(publicacion7);
      
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
