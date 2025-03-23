/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 * Clase que representa un nodo básico.
 * @author Fabiana Rodríguez
 * @Colaboradores Luis Peña
 */
public class NodoPrimitivo {
    private Object valorPrimitivo;
    private NodoPrimitivo siguiente;

    /**
     * Constructor por defecto.
     */
    public NodoPrimitivo() {
        this.valorPrimitivo = null;
        this.siguiente = null;
    }

    /**
     * Constructor que inicializa el nodo con un valor específico.
     *
     * @param valorPrimitivo Valor a almacenar en el nodo.
     */
    public NodoPrimitivo(Object valorPrimitivo) {
        this.valorPrimitivo = valorPrimitivo;
        this.siguiente = null;
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     *
     * @return Valor almacenado en el nodo.
     */
    public Object getValorPrimitivo() {
        return valorPrimitivo;
    }

    /**
     * Establece el valor almacenado en el nodo.
     *
     * @param valorPrimitivo Nuevo valor a almacenar.
     */
    public void setValorPrimitivo(Object valorPrimitivo) {
        this.valorPrimitivo = valorPrimitivo;
    }

    /**
     * Obtiene la referencia al siguiente nodo.
     *
     * @return Siguiente nodo en la estructura.
     */
    public NodoPrimitivo getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al siguiente nodo.
     *
     * @param siguiente Nuevo nodo siguiente.
     */
    public void setSiguiente(NodoPrimitivo siguiente) {
        this.siguiente = siguiente;
    }
}
