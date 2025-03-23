/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Clase que representa una lista enlazada simple.
 * @author Fabiana Rodríguez
 * @Colaboradores Luis Peña
 */
public class ListaEnlazada<K, V> {
    private Nodo<ParClaveValor<K, V>> cabeza; // Nodo inicial de la lista
    private int tamaño; // Número de nodos en la lista

    /**
     * Constructor por defecto.
     */
    public ListaEnlazada() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    /**
     * Inserta un nuevo par clave-valor al final de la lista.
     *
     * @param par Par clave-valor a insertar.
     */
    public void insertar(ParClaveValor<K, V> par) {
        Nodo<ParClaveValor<K, V>> nuevoNodo = new Nodo<>(par);
        if (this.cabeza == null) {
            this.cabeza = nuevoNodo;
        } else {
            Nodo<ParClaveValor<K, V>> actual = this.cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        this.tamaño++;
    }

    /**
     * Busca un valor en la lista dado su clave.
     *
     * @param clave Clave del elemento buscado.
     * @return Valor asociado a la clave, o null si no se encuentra.
     */
    public V buscarValor(K clave) {
        Nodo<ParClaveValor<K, V>> actual = this.cabeza;
        while (actual != null) {
            if (actual.getDato().getClave().equals(clave)) {
                return actual.getDato().getValor();
            }
            actual = actual.getSiguiente();
        }
        return null; // No se encontró la clave
    }

    /**
     * Obtiene la cabeza de la lista.
     *
     * @return Nodo inicial de la lista.
     */
    public Nodo<ParClaveValor<K, V>> getCabeza() {
        return cabeza;
    }

    /**
     * Establece la cabeza de la lista.
     *
     * @param cabeza Nuevo nodo inicial de la lista.
     */
    public void setCabeza(Nodo<ParClaveValor<K, V>> cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Obtiene el tamaño de la lista.
     *
     * @return Número de nodos en la lista.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Establece el tamaño de la lista.
     *
     * @param tamaño Nuevo tamaño de la lista.
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    /**
     * Agrega un nuevo nodo al final de la lista.
     *
     * @param dato Dato a almacenar en el nuevo nodo.
     */
    public void agregarALFinal(ParClaveValor<K, V> dato) {
        Nodo<ParClaveValor<K, V>> nuevoNodo = new Nodo<>(dato);
        if (this.isEmpty()) {
            this.setCabeza(nuevoNodo);
        } else {
            Nodo<ParClaveValor<K, V>> temp = this.cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
        }
        this.tamaño++;
    }

    /**
     * Elimina el último nodo de la lista.
     */
    public void eliminarDelFinal() {
        if (!this.isEmpty()) {
            if (this.getTamaño() == 1) {
                this.setCabeza(null);
            } else {
                Nodo<ParClaveValor<K, V>> temp = this.cabeza;
                while (temp.getSiguiente().getSiguiente() != null) {
                    temp = temp.getSiguiente();
                }
                temp.setSiguiente(null);
            }
            this.tamaño--;
        }
    }
}