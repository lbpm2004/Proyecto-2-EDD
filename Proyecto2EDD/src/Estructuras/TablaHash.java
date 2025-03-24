/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Clase que representa una tabla hash.
 * @author Fabiana Rodríguez
 * @Colaboradores Luis Peña
 */
public class TablaHash<K, V> {
    private ListaEnlazada<K, V>[] tabla; // Arreglo de listas enlazadas
    private int size; // Tamaño de la tabla hash

    /**
     * Constructor por defecto que inicializa la tabla hash con un tamaño predeterminado.
     */
    public TablaHash() {
        this(50); // Tamaño predeterminado
    }

    /**
     * Constructor que inicializa la tabla hash con un tamaño específico.
     *
     * @param size Tamaño de la tabla hash.
     */
    public TablaHash(int size) {
        this.size = size;
        this.tabla = new ListaEnlazada[size];
        for (int i = 0; i < size; i++) {
            this.tabla[i] = new ListaEnlazada<>();
        }
    }

    /**
     * Inserta un par clave-valor en la tabla hash.
     *
     * @param clave   Clave del elemento.
     * @param valor   Valor asociado a la clave.
     */
    public void insertar(K clave, V valor) {
        int indice = funcionHash(clave);
        tabla[indice].insertar(new ParClaveValor<>(clave, valor));
    }

    /**
     * Busca un valor en la tabla hash dado su clave.
     *
     * @param clave Clave del elemento buscado.
     * @return Valor asociado a la clave, o null si no se encuentra.
     */
    public V buscar(K clave) {
        int indice = funcionHash(clave);
        return tabla[indice].buscarValor(clave);
    }

    /**
     * Función hash para calcular el índice de la tabla.
     *
     * @param clave Clave del elemento.
     * @return Índice calculado.
     */
    private int funcionHash(K clave) {
        return Math.abs(clave.hashCode()) % size;
    }

    /**
     * Obtiene la tabla hash.
     *
     * @return Arreglo de listas enlazadas.
     */
    public ListaEnlazada<K, V>[] getTabla() {
        return tabla;
    }

    /**
     * Establece la tabla hash.
     *
     * @param tabla Nueva tabla hash.
     */
    public void setTabla(ListaEnlazada<K, V>[] tabla) {
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
