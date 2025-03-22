/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Fabiana Rodríguez
 */
public class NodoPrimitivo {
    private Object valorPrimitivo;
    private NodoPrimitivo siguiente;
    
    public NodoPrimitivo(){
        this.valorPrimitivo = null;
        this.siguiente = null;
    }
    
    public NodoPrimitivo(Object valorPrimitivo) {
        this.valorPrimitivo = valorPrimitivo;
        this.siguiente = null;
    }
    public Object getValorPrimitivo() {
        return valorPrimitivo;
    }
    public NodoPrimitivo getSiguiente() {
        return siguiente;
    }
    public void setValorPrimitivo(Object valorPrimitivo) {
        this.valorPrimitivo = valorPrimitivo;
    }
    public void setSiguiente(NodoPrimitivo siguiente) {
        this.siguiente = siguiente;
    }
}
