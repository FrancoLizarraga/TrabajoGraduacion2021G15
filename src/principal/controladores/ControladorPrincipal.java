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
import interfaces.IControladorPrincipal;
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
     
        
////      Gestor Grupo.
//        System.out.println("\n\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR GRUPOS");
//        System.out.println("\t----------------------------------------------");
        IGestorGrupos g=GestorGrupos.instanciar();
//        System.out.println("\n\tmethod nuevoGrupo\n");
//        
        System.out.println(g.nuevoGrupo("grupo1", "descripcion1"));
        System.out.println(g.nuevoGrupo("a", "descripcion2"));
//        System.out.println(g.nuevoGrupo("grupo1", "descripcion3"));//repetido
//        System.out.println(g.nuevoGrupo("", "descripcion1"));//vacia
//        System.out.println(g.nuevoGrupo("alumnos", "descripcion12"));//nuevo grupo para tp6
//        System.out.println(g.nuevoGrupo("autores", "descripcion02"));//nuevo grupo para tp6
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
//        System.out.println("El grupo es: "+g.verGrupo("grupo1").verNombre());//devuelve el nombre del grupo
//        System.out.println("El grupo es: "+g.verGrupo("grupo5"));//devuelve null
//        
//        System.out.println("\n\tmethod buscarGrupos\n");
//        for(Grupo grupo: g.buscarGrupos("grup"))
//                System.out.println("\t" + grupo.verNombre());
//        
//        System.out.println("\n\tmethod existeEsteGrupo\n");
//        System.out.println("Existe el grupo1: "+g.existeEsteGrupo(g.verGrupo("grupo1")));//true
//        System.out.println("Existe el grupo5: "+g.existeEsteGrupo(g.verGrupo("grupo5")));//false
//
////      Gestor Idiomas
//        System.out.println("\n\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR IDIOMAS");
//        System.out.println("\t----------------------------------------------");
        IGestorIdiomas gi=GestorIdiomas.instanciar();
//        System.out.println("\n\tmethod nuevoIdioma\n");
//        
//        System.out.println(gi.nuevoIdioma("idioma1"));
//        System.out.println(gi.nuevoIdioma("idioma2"));
//        System.out.println(gi.nuevoIdioma("idioma1"));//repetido
//        System.out.println(gi.nuevoIdioma(""));//vacio
//        System.out.println(gi.nuevoIdioma("Aleman"));//nuevo idioma para tp6
//        System.out.println(gi.nuevoIdioma("Castellano"));//nuevo idioma para tp6
//        System.out.println(gi.nuevoIdioma(null));//null
        System.out.println(gi.nuevoIdioma("Inglés"));
        System.out.println(gi.nuevoIdioma("Español"));
        System.out.println(gi.nuevoIdioma("Portugués"));
        System.out.println(gi.nuevoIdioma("Alemán"));
//        
//        System.out.println("\n\tmethod verIdiomas\n");
//        System.out.println("Los idiomas son:");
//        for(Idioma id : gi.verIdiomas())
//            System.out.println("\t"+id.toString());
//        
//        System.out.println("\n\tmethod verIdioma\n");
//        System.out.println("El idioma es: "+gi.verIdioma("idioma1"));
//        System.out.println("El idioma es: "+gi.verIdioma("idioma5"));
//        
//        System.out.println("\n\tmethod buscarIdiomas\n");
//        for(Idioma i : gi.buscarIdiomas("idiom"))
//                System.out.println("\t" + i.toString());
//        
//        System.out.println("\n\tmethod existeEsteIdioma\n");
//        System.out.println("El idioma Castellano existe: "+ gi.existeEsteIdioma(gi.verIdioma("Castellano")));//true
//        
////      Gestor Lugares
//        System.out.println("\n\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR LUGAR");
//        System.out.println("\t----------------------------------------------");
        IGestorLugares gl= GestorLugares.instanciar();
//              
//        System.out.println("\n\tmethod nuevoLugar\n");
//        System.out.println(gl.nuevoLugar("lugar1"));
//        System.out.println(gl.nuevoLugar("lugar2"));
//        System.out.println(gl.nuevoLugar("lugar1"));//repetido
//        System.out.println(gl.nuevoLugar(""));//vacia
//        System.out.println(gl.nuevoLugar("Aula"));          //nueva palabra clave para tp6
//        System.out.println(gl.nuevoLugar("Anfiteatro"));    //nueva palabra clave para tp6
//        System.out.println(gl.nuevoLugar(null));
        System.out.println(gl.nuevoLugar("Aula"));
        System.out.println(gl.nuevoLugar("Anfiteatro"));
        System.out.println(gl.nuevoLugar("Laboratorio"));
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
//        
////      Gestor Palabras Claves
//        System.out.println("\n\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR PALABRAS CLAVES");
//        System.out.println("\t----------------------------------------------");
        IGestorPalabrasClaves pc=GestorPalabrasClaves.instanciar();
//        
//        System.out.println("\n\tmethod nuevaPalabraClave\n");
//        System.out.println(pc.nuevaPalabraClave("palabraClave1"));
//        System.out.println(pc.nuevaPalabraClave("palabraClave2"));
//        System.out.println(pc.nuevaPalabraClave("palabraClave1"));//repetida
//        System.out.println(pc.nuevaPalabraClave(""));//vacia
//        System.out.println(pc.nuevaPalabraClave("Hola"));       //nueva palabra clave para tp6
//        System.out.println(pc.nuevaPalabraClave("Alcance"));    //nueva palabra clave para tp6
//        System.out.println(pc.nuevaPalabraClave(null));//nula
        System.out.println(pc.nuevaPalabraClave("Hardware"));
        System.out.println(pc.nuevaPalabraClave("Web"));
        System.out.println(pc.nuevaPalabraClave("Software"));
        System.out.println(pc.nuevaPalabraClave("Física"));
        System.out.println(pc.nuevaPalabraClave("Electrónica"));
        System.out.println(pc.nuevaPalabraClave("Java"));
//        
//        System.out.println("\n\tmethod verPalabrasClaves\n");
//        System.out.println("Las palabras claves son:");
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
//        
////      GESTOR TIPOS
//        System.out.println("\n\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR TIPOS");
//        System.out.println("\t----------------------------------------------");
        IGestorTipos gt=GestorTipos.instanciar();
//        
//        System.out.println("\n\tmethod nuevoTipo\n");
//        System.out.println(gt.nuevoTipo("Tipo1"));
//        System.out.println(gt.nuevoTipo("Tipo2"));
//        System.out.println(gt.nuevoTipo("Tipo1"));//tipo repetido
//        System.out.println(gt.nuevoTipo(""));//cadena vacia
//        System.out.println(gt.nuevoTipo("Hola"));       //nuevo tipo para tp6
//        System.out.println(gt.nuevoTipo("Alcance"));    //nuevo tipo para tp6
//        System.out.println(gt.nuevoTipo(null));//nulo
        System.out.println(gt.nuevoTipo("Texto cientifico"));
        System.out.println(gt.nuevoTipo("Articulo"));
        System.out.println(gt.nuevoTipo("Extras"));
//     
//        System.out.println("\n\tmethod verTipos\n");
//        System.out.println("Los tipos son:");
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
//        
//        
//        System.out.println("\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR AUTORES");
//        System.out.println("\t----------------------------------------------");
        IGestorAutores ga=GestorAutores.instanciar();
//        System.out.println("\n\tmethod nuevoAutor (Para profesores)\n");
//        
////      PROFESORES
//        System.out.println(ga.nuevoAutor(1, "apellido1", "nombre1", Cargo.ADJUNTO, "clave1", "clave1"));//se agrega
//        System.out.println(ga.nuevoAutor(1, "apellido1", "nombre1", Cargo.ADG, "clave1", "clave1"));//repetido
//        System.out.println(ga.nuevoAutor(0, "apellido1", "nombre1", Cargo.ADJUNTO, "clave1", "clave1"));//dni nulo
//        System.out.println(ga.nuevoAutor(2, "", "nombre1", Cargo.ADJUNTO, "clave1", "clave1"));//apellido vacio
//        System.out.println(ga.nuevoAutor(3, "apellido1", "", Cargo.TITULAR, "clave1", "clave1"));//nombre vacio
//        System.out.println(ga.nuevoAutor(4, null, "nombre1", Cargo.ADJUNTO, "clave1", "clave1"));//apellido null
//        System.out.println(ga.nuevoAutor(65, "Lizarraga", "Franco", Cargo.ADJUNTO, "clave6", "clave6"));//NUEVOS PARA TP6
//        System.out.println(ga.nuevoAutor(621, "Lizarraga", "Ana", Cargo.ADJUNTO, "clave6", "clave6"));//NUEVOS PARA TP6
//        System.out.println(ga.nuevoAutor(61, "Lizarraga", "Boris", Cargo.ADJUNTO, "clave6", "clave6"));//NUEVOS PARA TP6
//        System.out.println(ga.nuevoAutor(5, "apellido1", null, Cargo.ASOCIADO, "clave1", "clave1"));//nombre null
//        System.out.println(ga.nuevoAutor(6, "apellido6", "nombre6", Cargo.ADJUNTO, "clave6", "clave6"));//se agrega
//
        ga.nuevoAutor(621, "Lizarraga", "Franco Tomás", Cargo.JTP, "clave6", "clave6");
        ga.nuevoAutor(622, "Juarez", "Tatiana Jimena", Cargo.TITULAR, "clave2", "clave2");
        ga.verAutor(621).agregarGrupo(g.verGrupo("grupo1"), Rol.COLABORADOR);
        ga.verAutor(621).agregarGrupo(g.verGrupo("a"), Rol.ADMINISTRADOR);
        ga.verAutor(622).agregarGrupo(g.verGrupo("grupo1"), Rol.ADMINISTRADOR);
        
////      ALUMNOS
//        System.out.println("\n\tmethod nuevoAutor (Para alumnos)\n");
//        System.out.println(ga.nuevoAutor(5, "apellido1", "nombre1", "cx1", "clave1", "clave1"));//se agrega
//        System.out.println(ga.nuevoAutor(5, "apellido1", "nombre1", "cx2", "clave1", "clave1"));//dni repetido
//        System.out.println(ga.nuevoAutor(0, "apellido1", "nombre1", "cx3", "clave1", "clave1"));//dni nulo
//        System.out.println(ga.nuevoAutor(2, "", "nombre1", "cx4", "clave1", "clave1"));//apellido vacio
//        System.out.println(ga.nuevoAutor(3, "apellido1", "", "cx5", "clave1", "clave1"));//nombre vacio
//        System.out.println(ga.nuevoAutor(4, null, "nombre1", "cx6", "clave1", "clave1"));//apellido null
//        System.out.println(ga.nuevoAutor(5, "apellido1", null, "cx7", "clave1", "clave1"));//nombre null
//        System.out.println(ga.nuevoAutor(511, "Juarez", "Julia", "cx81", "clave1", "clave1"));//NUEVOS PARA TP6
//        System.out.println(ga.nuevoAutor(5211, "Juarez", "Valentin", "cx91", "clave1", "clave1"));//NUEVOS PARA TP6
//        System.out.println(ga.nuevoAutor(53, "Juarez", "Eric", "cx71", "clave1", "clave1"));//NUEVOS PARA TP6
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
//        System.out.println("\n\tmethod buscarProfesores\n");
//        for(Profesor p: ga.buscarProfesores("Lizar"))
//            p.mostrar();
//        
//        System.out.println("\n\tmethod buscarAlumnos\n");
//        for(Alumno a: ga.buscarAlumnos("Juar"))
//            a.mostrar();
//        
//        //Primero le agrego un grupo al autor (o viceversa es lo mismo) y despues controlo el metodo hayAutoresConEsteGrupo.
//        g.verGrupo("grupo1").agregarMiembro(ga.verAutor(53), Rol.COLABORADOR);
//        System.out.println("\n\tmethod hayAutoresConEsteGrupo\n");
//        System.out.println(ga.hayAutoresConEsteGrupo(g.verGrupo("grupo1")));
//
////      GESTOR PUBLICACIONES
//        System.out.println("\n\t----------------------------------------------");
//        System.out.println("\t\t\tGESTOR PUBLICACIONES");
//        System.out.println("\t----------------------------------------------");
        IGestorPublicaciones gp=GestorPublicaciones.instanciar();
//        
//        System.out.println("\n\tmethod nuevaPublicacion\n");
//        
        gp.nuevaPublicacion("Titulo 1", new MiembroEnGrupo(ga.verAutor(622),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Articulo"), gi.verIdioma("Español"), gl.verLugar("Anfiteatro"), pc.verPalabrasClaves(), "enlace 1", "resumen1");
//        System.out.println(gp.nuevaPublicacion("Titulo 1", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlace 1", "resumen1"));//lo agrega
//        System.out.println(gp.nuevaPublicacion("", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlace 1", "resumen1"));//titulo vacio
//        System.out.println(gp.nuevaPublicacion(null, new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlace 1", "resumen1"));// titulo null
//        System.out.println(gp.nuevaPublicacion("Titulo 2", null, LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlace 1", "resumen1"));//miembroEnGrupo null
//        System.out.println(gp.nuevaPublicacion("Titulo 1", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo2"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo2"), gi.verIdioma("idioma2"), gl.verLugar("lugar2"), pc.verPalabrasClaves(), "enlace 2", "resumen2"));//titulo repetido
//        System.out.println(gp.nuevaPublicacion("Titulo 2", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), null, gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlace 1", "resumen1"));//idioma null
//        System.out.println(gp.nuevaPublicacion("Titulo 2", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), null, pc.verPalabrasClaves(), "enlace 1", "resumen1"));//lugar null
//        System.out.println(gp.nuevaPublicacion("Titulo 2", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), null, "enlace 1", "resumen1"));//palabras claves null
//        System.out.println(gp.nuevaPublicacion("Titulo 2", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "", "resumen1"));//Enlace Vacio
//        System.out.println(gp.nuevaPublicacion("Zorro", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlazado", "resumen1"));//NUEVO PARA TP6.
//        System.out.println(gp.nuevaPublicacion("Nuevo titulo 2", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "www.google.com", "resumen1"));//NUEVO PARA TP6.
//        System.out.println(gp.nuevaPublicacion("Antess", new MiembroEnGrupo(ga.verAutor(1),g.verGrupo("grupo1"),Rol.COLABORADOR), LocalDate.of(2020, 06, 24), gt.verTipo("Tipo1"), gi.verIdioma("idioma1"), gl.verLugar("lugar1"), pc.verPalabrasClaves(), "enlazado2", "resumen1"));//NUEVO PARA TP6.
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
//        System.out.println("\nLa Publicacion modificada es:\n");
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
//        System.out.println("\n\tmethod hayPublicacionesConEsteTipo\n");
//        System.out.println("El Tipo1: "+gp.hayPublicacionesConEsteTipo(gt.verTipo("Tipo1")));//true
//        System.out.println("El Tipo26: "+gp.hayPublicacionesConEsteTipo(gt.verTipo("Tipo26")));//false
//        
//        System.out.println("\n\tmethod hayPublicacionesConEsteAutor\n");
//        System.out.println("El autor apellido modi nombre modi: "+gp.hayPublicacionesConEsteAutor(ga.verAutor(5)));//true
//        System.out.println("El autor apellido con dni 25: "+gp.hayPublicacionesConEsteAutor(ga.verAutor(25)));//false
//        
//        System.out.println("\n\tmethod ExisteEstaPublicacion\n");
//        System.out.println("La Publicacion Titulo1 existe: "+gp.existeEstaPublicacion(gp.verPublicacion("Titulo 1")));//true
//        System.out.println("La Publicacion Titulo25 existe: "+gp.existeEstaPublicacion(gp.verPublicacion("Titulo 25")));//false
//        
//        System.out.println("\n\tmethod verPublicaciones\n");
//        for(Publicacion pb: gp.verPublicaciones()){
//            pb.mostrar();
//            System.out.println();
//        }
//        
//        System.out.println("\n\tmethod verPublicacion\n");
//        gp.verPublicacion("Titulo 2").mostrar();
//        
//        System.out.println("\n\tmethod buscarPublicaciones\n");
//        for(Publicacion p : gp.buscarPublicaciones("Tit")){
//            p.mostrar();
//            System.out.println();
//        }
//        
//        System.out.println("\n\tmethod borrarPublicacion\n");
//        System.out.println(gp.borrarPublicacion(gp.verPublicacion("Titulo 2")));
//        //MUESTRO DE NUEVO TODAS LAS PUBLICACIONES PARA COMPROBAR SI SE BORRÓ.
//        System.out.println("\n\tmethod verPublicaciones\n");
//        for(Publicacion pb: gp.verPublicaciones()){
//            pb.mostrar();
//            System.out.println();
//        }
//        
//        System.out.println("\n\tmethod borrarAutor\n");
//        System.out.println(ga.borrarAutor(ga.verAutor(1)));
//        //MUESTRO DE NUEVO TODOS LOS AUTORES PARA COMPROBAR SI SE BORRÓ.
//        System.out.println("\n\tmethod verAutores\n");
//        System.out.println("Lista de todos los autores:");
//        for(Autor a : ga.verAutores())
//            a.mostrar();
//        
//        System.out.println("\n\tmethod borrarTipo\n");
//        System.out.println(gt.borrarTipo(gt.verTipo("Alcance")));
//        //MUESTRO DE NUEVO TODOS LOS TIPOS PARA COMPROBAR SI SE BORRÓ.
//        System.out.println("\n\tmethod verTipos\n");
//        System.out.println("Los tipos son:");
//        for(Tipo t : gt.verTipos())
//            System.out.println("\t" + t.toString());
//        
//        System.out.println("\n\tmethod borrarPalabraClave\n");
//        System.out.println(pc.borrarPalabraClave(pc.verPalabraClave("palabraClave2")));
//        //MUESTRO DE NUEVO TODAS LAS PALABRAS CLAVES PARA COMPROBAR SI SE BORRÓ.
//        //No se borra ninguna porque en publicaciones le agrego todas las palabras claves.
//        System.out.println("\n\tmethod verPalabrasClaves\n");
//        System.out.println("Las palabras claves son:");
//        for(PalabraClave p : pc.verPalabrasClaves())
//            System.out.println("\t" + p.toString());
//        
//        System.out.println("\n\tmethod borrarLugar\n");
//        System.out.println(gl.borrarLugar(gl.verLugar("Aula")));
//        //MUESTRO DE NUEVO TODOS LOS LUGARES PARA COMPROBAR SI SE BORRÓ.
//        System.out.println("\n\tmethod verLugares\n");
//        System.out.println("Los lugares son:");
//        for(Lugar l : gl.verLugares())
//            System.out.println("\t" + l.verNombre());
//        
//        System.out.println("\n\tmethod borrarIdioma\n");
//        System.out.println(gi.borrarIdioma(gi.verIdioma("Aleman")));
//        //MUESTRO DE NUEVO TODOS LOS IDIOMAS PARA COMPROBAR SI SE BORRÓ.
//        System.out.println("\n\tmethod verIdiomas\n");
//        System.out.println("Los idiomas son:");
//        for(Idioma id : gi.verIdiomas())
//            System.out.println("\t"+id.toString());
//        
//        System.out.println("\n\tmethod borrarGrupo\n");
//        System.out.println(g.borrarGrupo(g.verGrupo("grupo1")));
//        //MUESTRO DE NUEVO TODOS LOS GRUPOS PARA COMPROBAR SI SE BORRÓ.
//        System.out.println("\n\tmethod verGrupos");
//        for(Grupo gr : g.verGrupos())
//            gr.mostrar();

      //</editor-fold>   
     //<editor-fold defaultstate="collapsed" desc="Intefaz gráfica"> 
	IControladorPrincipal cp = ControladorVentanaPrincipal.instanciar();
     //</editor-fold>
    
    }
}
