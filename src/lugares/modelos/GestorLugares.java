/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lugares.modelos;

import interfaces.IGestorLugares;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GestorLugares implements IGestorLugares {

    private ArrayList<Lugar> lugares = new ArrayList<>();

    private static GestorLugares gestor;

    private GestorLugares() {

    }

    public static GestorLugares instanciar() {
        if (gestor == null) {
            gestor = new GestorLugares();
        }
        return gestor;
    }

    @Override
    public String nuevoLugar(String nombre) {
        if ((nombre != null) && (!nombre.isEmpty())) {
            Lugar lugarx = new Lugar(nombre);
            if (!this.lugares.contains(lugarx)) {
                this.lugares.add(lugarx);
                return "Lugar creado y guardado";
            } else {
                return "Ya existe un lugar con ese nombre";
            }
        } else {
            return "El nombre del lugar debe ser una cadena no vacia.";
        }
    }

    @Override
    public ArrayList<Lugar> verLugares() {
        return this.lugares;
    }

    @Override
    public Lugar verLugar(String nombre) {
        for (Lugar l : this.lugares) {
            if (l.toString().equals(nombre)) {
                return l;
            }
        }
        return null;
    }

}
