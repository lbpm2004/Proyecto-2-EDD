/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 * Clase que representa una lista enlazada simple.
 * @author Fabiana Rodríguez
 * @Colaboradores Luis Peña
 */
public class ListaEnlazada {
    private NodoPrimitivo cabeza;
    private int tamaño;

    /**
     * Constructor por defecto.
     */
    public ListaEnlazada() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    /**
     * Obtiene la cabeza de la lista.
     *
     * @return Nodo inicial de la lista.
     */
    public NodoPrimitivo getCabeza() {
        return cabeza;
    }

    /**
     * Establece la cabeza de la lista.
     *
     * @param cabeza Nuevo nodo inicial de la lista.
     */
    public void setCabeza(NodoPrimitivo cabeza) {
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
    public void agregarALFinal(Object dato) {
        NodoPrimitivo nuevoNodo = new NodoPrimitivo(dato);
        if (this.isEmpty()) {
            this.setCabeza(nuevoNodo);
        } else {
            NodoPrimitivo temp = this.cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
        }
        this.setTamaño(this.getTamaño() + 1);
    }

    /**
     * Elimina el último nodo de la lista.
     */
    public void eliminarDelFinal() {
        if (!this.isEmpty()) {
            if (this.getTamaño() == 1) {
                this.setCabeza(null);
            } else {
                NodoPrimitivo temp = this.cabeza;
                while (temp.getSiguiente().getSiguiente() != null) {
                    temp = temp.getSiguiente();
                }
                temp.setSiguiente(null);
            }
            this.setTamaño(this.getTamaño() - 1);
        }
    }
}