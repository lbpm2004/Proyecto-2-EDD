/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Clase que representa un nodo en un árbol binario.
 * @author Fabiana Rodríguez
 * @Colaboradores Luis Peña
 */
public class NodoABB<T> {
    private T valor; // Valor almacenado en el nodo (puede ser una pregunta o una especie)
    private NodoABB<T> hijoSi; // Referencia al nodo hijo para respuesta "Sí"
    private NodoABB<T> hijoNo; // Referencia al nodo hijo para respuesta "No"

    /**
     * Constructor que inicializa un nodo con un valor específico.
     *
     * @param valor Valor a almacenar en el nodo.
     */
    public NodoABB(T valor) {
        this.valor = valor;
        this.hijoSi = null;
        this.hijoNo = null;
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     *
     * @return Valor almacenado en el nodo.
     */
    public T getValor() {
        return valor;
    }

    /**
     * Establece el valor almacenado en el nodo.
     *
     * @param valor Nuevo valor a almacenar.
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * Obtiene el nodo hijo para respuesta "Sí".
     *
     * @return Nodo hijo para respuesta "Sí".
     */
    public NodoABB<T> getHijoSi() {
        return hijoSi;
    }

    /**
     * Establece el nodo hijo para respuesta "Sí".
     *
     * @param hijoSi Nuevo nodo hijo para respuesta "Sí".
     */
    public void setHijoSi(NodoABB<T> hijoSi) {
        this.hijoSi = hijoSi;
    }

    /**
     * Obtiene el nodo hijo para respuesta "No".
     *
     * @return Nodo hijo para respuesta "No".
     */
    public NodoABB<T> getHijoNo() {
        return hijoNo;
    }

    /**
     * Establece el nodo hijo para respuesta "No".
     *
     * @param hijoNo Nuevo nodo hijo para respuesta "No".
     */
    public void setHijoNo(NodoABB<T> hijoNo) {
        this.hijoNo = hijoNo;
    }
}
