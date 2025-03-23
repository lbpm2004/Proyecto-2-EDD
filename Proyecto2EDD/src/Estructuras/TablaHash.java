/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import proyecto2edd.ListaEnlazada;

/**
 * Clase que representa una tabla hash.
 * @author Fabiana Rodríguez
 * @Colaboradores Luis Peña
 */
public class TablaHash {
    private ListaEnlazada[] tabla;
    private int size;

    /**
     * Constructor que inicializa la tabla hash con un tamaño específico.
     *
     * @param size Tamaño de la tabla hash.
     */
    public TablaHash(int size) {
        this.size = size;
        this.tabla = new ListaEnlazada[size];
        for (int i = 0; i < size; i++) {
            this.tabla[i] = new ListaEnlazada();
        }
    }

    /**
     * Obtiene la tabla hash.
     *
     * @return Arreglo de listas enlazadas.
     */
    public ListaEnlazada[] getTabla() {
        return tabla;
    }

    /**
     * Establece la tabla hash.
     *
     * @param tabla Nueva tabla hash.
     */
    public void setTabla(ListaEnlazada[] tabla) {
        this.tabla = tabla;
    }

    /**
     * Obtiene el tamaño de la tabla hash.
     *
     * @return Tamaño de la tabla hash.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la tabla hash.
     *
     * @param size Nuevo tamaño de la tabla hash.
     */
    public void setSize(int size) {
        this.size = size;
    }
}
