/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Fabiana Rodríguez
 */
public class TreeNode {
    private Object valor;
    private TreeNode nodoPadre;
    private ListaEnlazada nodoHijos;
    
    public TreeNode(Object valor) {
        this.valor = valor; 
        this.nodoPadre = null;
        this.nodoHijos = new ListaEnlazada();
    }

    public Object getValor() {
        return valor;
    }
    public TreeNode getNodoPadre() {
        return nodoPadre;
    }

    public ListaEnlazada getNodoHijos() {
        return nodoHijos;
    }
    public Object obtenerValor() {
        return valor;
    }
    
    public void setValor(Object valor) {
        this.valor = valor;
    }
    public void setNodoPadre(TreeNode nodoPadre) {
        this.nodoPadre = nodoPadre;
    }
    public void setNodoHijos(ListaEnlazada nodoHijos) {
        this.nodoHijos = nodoHijos;
    }
    
    public void agregarHijo(TreeNode hijo) {
        hijo.setNodoPadre(this);
        this.nodoHijos.agregarALFinal(hijo);
    }
    
    
}
