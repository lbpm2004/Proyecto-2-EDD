/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Fabiana Rodríguez
 */
public class HashTable {
    private ListaEnlazada[] tabla;
    private int size;
    
    public HashTable(int size){
        this.size = size;
        this.tabla = new ListaEnlazada[size];
        this.iniciar();
    
    
}
    public ListaEnlazasa[] getTabla() {
        return tabla;
    }
    public int getSize() {
        return size;
    }
    public void setTabla(ListaEnlazada[] tabla) {
        this.tabla = tabla;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
