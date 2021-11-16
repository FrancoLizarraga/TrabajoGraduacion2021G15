/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos.modelos;

import interfaces.IGestorTipos;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GestorTipos implements IGestorTipos {

    private ArrayList<Tipo> tipos = new ArrayList<>();

    private static GestorTipos gestor;

    private GestorTipos() {

    }

    public static GestorTipos instanciar() {
        if (gestor == null) {
            gestor = new GestorTipos();
        }
        return gestor;
    }

    @Override
    public String nuevoTipo(String nombre) {
        if ((nombre != null) && (!nombre.isEmpty())) {
            Tipo tipo = new Tipo(nombre);
            if (!this.tipos.contains(tipo)) {
                this.tipos.add(tipo);
                return "Tipo creado y guardado";
            } else {
                return "Ya existe un tipo con ese nombre";
            }
        } else {
            return "El nombre del tipo debe ser una cadena no vacia.";
        }
    }

    @Override
    public ArrayList<Tipo> verTipos() {
        return this.tipos;
    }

    @Override
    public Tipo verTipo(String nombre) {
        for (Tipo t : this.tipos) {
            if (t.toString().equals(nombre)) {
                return t;
            }
        }
        return null;
    }

}
