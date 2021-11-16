/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GestorPalabrasClaves implements IGestorPalabrasClaves {

    private ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();

    private static GestorPalabrasClaves gestor;

    private GestorPalabrasClaves() {

    }

    public static GestorPalabrasClaves instanciar() {
        if (gestor == null) {
            gestor = new GestorPalabrasClaves();
        }
        return gestor;
    }

    @Override
    public String nuevaPalabraClave(String nombre) {
        if ((nombre != null) && (!nombre.isEmpty())) {
            PalabraClave palabra = new PalabraClave(nombre);
            if (!this.palabrasClaves.contains(palabra)) {
                this.palabrasClaves.add(palabra);
                return "Palabra clave creada y guardada";
            } else {
                return "Ya existe una palabra clave con ese nombre";
            }
        } else {
            return "El nombre de la palabra clave debe ser una cadena no vacia.";
        }
    }

    @Override
    public ArrayList<PalabraClave> verPalabrasClaves() {
        return this.palabrasClaves;
    }

    @Override
    public PalabraClave verPalabraClave(String nombre) {
        for (PalabraClave p : this.palabrasClaves) {
            if (p.toString().equals(nombre)) {
                return p;
            }
        }
        return null;
    }

}
