/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Clase que representa un árbol binario.
 * @author Fabiana Rodríguez
 * @Colaboradores Luis Peña
 */
public class ABB<T> {
    private NodoABB<T> root; // Nodo raíz del árbol

    /**
     * Constructor por defecto.
     */
    public ABB() {
        this.root = null;
    }

    /**
     * Obtiene el nodo raíz del árbol.
     *
     * @return Nodo raíz.
     */
    public NodoABB<T> getRoot() {
        return root;
    }

    /**
     * Establece el nodo raíz del árbol.
     *
     * @param root Nuevo nodo raíz.
     */
    public void setRoot(NodoABB<T> root) {
        this.root = root;
    }

    /**
     * Crea el nodo raíz del árbol.
     *
     * @param data Valor a almacenar en el nodo raíz.
     * @return Nodo raíz creado.
     */
    public NodoABB<T> crearRoot(T data) {
        this.root = new NodoABB<>(data);
        return this.root;
    }

    /**
     * Verifica si el árbol está vacío.
     *
     * @return true si el árbol está vacío, false en caso contrario.
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Agrega un nuevo nodo hijo al nodo padre especificado.
     *
     * @param padre Nodo padre.
     * @param data  Valor a almacenar en el nodo hijo.
     * @param esSi  Indica si el hijo es para respuesta "Sí" (true) o "No" (false).
     * @return Nodo hijo agregado.
     */
    public NodoABB<T> agregarHijo(NodoABB<T> padre, T data, boolean esSi) {
        if (padre == null) {
            throw new IllegalArgumentException("El nodo padre no puede ser nulo.");
        }
        NodoABB<T> hijo = new NodoABB<>(data);
        if (esSi) {
            if (padre.getHijoSi() != null) {
                throw new IllegalArgumentException("El nodo ya tiene un hijo para respuesta 'Sí'.");
            }
            padre.setHijoSi(hijo);
        } else {
            if (padre.getHijoNo() != null) {
                throw new IllegalArgumentException("El nodo ya tiene un hijo para respuesta 'No'.");
            }
            padre.setHijoNo(hijo);
        }
        return hijo;
    }
}
