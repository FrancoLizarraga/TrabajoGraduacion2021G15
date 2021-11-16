/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idiomas.modelos;

import interfaces.IGestorIdiomas;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GestorIdiomas implements IGestorIdiomas {

    private ArrayList<Idioma> idiomas = new ArrayList<>();

    private static GestorIdiomas gestor;

    private GestorIdiomas() {

    }

    public static GestorIdiomas instanciar() {
        if (gestor == null) {
            gestor = new GestorIdiomas();
        }
        return gestor;
    }

    @Override
    public String nuevoIdioma(String nombre) {
        if ((nombre != null) && (!nombre.isEmpty())) {
            Idioma idiomax = new Idioma(nombre);
            if (!this.idiomas.contains(idiomax)) {
                this.idiomas.add(idiomax);
                return "Idioma creado y guardado";
            } else {
                return "Ya existe un idioma con ese nombre";
            }
        } else {
            return "El nombre del idioma debe ser una cadena no vacia.";
        }
    }

    @Override
    public ArrayList<Idioma> verIdiomas() {
        return this.idiomas;
    }

    @Override
    public Idioma verIdioma(String nombre) {
        for (Idioma i : this.idiomas) {
            if (i.toString().equals(nombre)) {
                return i;
            }
        }
        return null;
    }

}
