/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JOptionPane;
/**
 *
 * @author Fabiana Rodríguez
 */
public class ListaEnlazada {
    private NodoPrimitivo cabeza;
    private int tamaño;
    
    public ListaEnlazada() {
    this.cabeza = null;
    this.tamaño = 0;
}
    public NodoPrimitivo getCabeza() {
        return cabeza;
    }
    public int getTamaño() {
        return tamaño;
    }
    public void setCabeza(NodoPrimitivo cabeza) {
        this.cabeza = cabeza;
    }
    public void setTamañ(int tamaño) {
     this.tamaño = tamaño;
    }
    
    public boolean isEmpty() {
        return this.cabeza == null;
    }
    
    public void agregarALFinal(Object data) {
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

    
    public void eliminarDelFinal() {
        if(!this.isEmpty()) {
            if (this.getTamaño() == 1) {
                this.setCabeza(null);
            } else {
                    NodoPrimitivo temp = this.cabeza;
                    
                    while(temp.getSiguiente().getSiguiente() != null) {
                        temp = temp.getSiguiente();
                    }
                    temp.setSiguiente(null);
            }
            this.setTamaño(this.getTamaño() - 1);


}
}
}