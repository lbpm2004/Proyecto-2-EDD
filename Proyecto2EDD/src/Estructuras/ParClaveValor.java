/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Clase que representa un par clave-valor genérico.
 * Esta estructura permite almacenar una clave y un valor asociado, donde ambos pueden ser de tipos diferentes.
 *
 * @param <K> El tipo de dato de la clave. Por ejemplo, puede ser un String, Integer, etc.
 * @param <V> El tipo de dato del valor asociado a la clave. Por ejemplo, puede ser un String, Integer, o cualquier otro objeto.
 * 
 * @author Luis Peña
 */
public class ParClaveValor<K, V> {

    private K clave;
    private V valor;

    /**
     * Constructor que inicializa un nuevo par clave-valor.
     *
     * @param clave La clave del par. No debe ser nula para evitar inconsistencias.
     * @param valor El valor asociado a la clave. Puede ser cualquier objeto.
     */
    public ParClaveValor(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    /**
     * Obtiene la clave del par clave-valor.
     *
     * @return La clave almacenada en este par.
     */
    public K getClave() {
        return clave;
    }

    /**
     * Obtiene el valor asociado a la clave.
     *
     * @return El valor almacenado en este par.
     */
    public V getValor() {
        return valor;
    }

    /**
     * Actualiza el valor asociado a la clave.
     *
     * @param valor El nuevo valor que se asociará con la clave.
     */
    public void setValor(V valor) {
        this.valor = valor;
    }
}