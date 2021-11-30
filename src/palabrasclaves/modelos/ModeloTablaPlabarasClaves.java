/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTablaPlabarasClaves extends AbstractTableModel{
    private List<String> nombresColumnas = new ArrayList<>();
    private List<PalabraClave> palabrasClaves = new ArrayList<>();
   
    
    public ModeloTablaPlabarasClaves(String filtroPalabraClave){
        this.nombresColumnas.add("Palabras Claves Filtradas");
        IGestorPalabrasClaves gestorPalabras = GestorPalabrasClaves.instanciar();
        this.palabrasClaves = gestorPalabras.buscarPalabrasClaves(filtroPalabraClave);
    }
    
    public ModeloTablaPlabarasClaves(){
        this.nombresColumnas.add("Palabras Claves Totales");
        IGestorPalabrasClaves gestorPalabras = GestorPalabrasClaves.instanciar();
        this.palabrasClaves = gestorPalabras.verPalabrasClaves();
    }
    
    @Override
    public int getRowCount() {
        return this.palabrasClaves.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        PalabraClave palabra = this.palabrasClaves.get(fila);
        switch(columna){
            case 0: return palabra;
            default: return palabra.toString();
        }
    }
    
    @Override
    public String getColumnName(int columna) {
         return this.nombresColumnas.get(columna);
    }
}
