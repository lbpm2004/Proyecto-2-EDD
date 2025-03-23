/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Clase que representa un nodo genérico para una lista enlazada.
 * @author Fabiana Rodríguez
 * @Colaboradores Luis Peña
 */
public class Nodo<T> {
    private T dato; // Valor almacenado en el nodo
    private Nodo<T> siguiente; // Referencia al siguiente nodo

    /**
     * Constructor por defecto.
     */
    public Nodo() {
        this.dato = null;
        this.siguiente = null;
    }

    /**
     * Constructor que inicializa el nodo con un valor específico.
     *
     * @param dato Valor a almacenar en el nodo.
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     *
     * @return Valor almacenado en el nodo.
     */
    public T getDato() {
        return dato;
    }

    /**
     * Establece el valor almacenado en el nodo.
     *
     * @param dato Nuevo valor a almacenar.
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la referencia al siguiente nodo.
     *
     * @return Siguiente nodo en la estructura.
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al siguiente nodo.
     *
     * @param siguiente Nuevo nodo siguiente.
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}