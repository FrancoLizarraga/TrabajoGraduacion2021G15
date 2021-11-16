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
        
        //BORRE TODO LO DE "SIN INTERFAZ GRAFICA" PORQUE ME PEDIA QUE NO DEJE CODIGO NO FUNCIONAL.
        //Lo tengo guardado en un block de notas.
        
        //</editor-fold>   
        //<editor-fold defaultstate="collapsed" desc="Intefaz gráfica"> 
        IControladorPrincipal cp = ControladorVentanaPrincipal.instanciar();
        //</editor-fold>
    }
}
