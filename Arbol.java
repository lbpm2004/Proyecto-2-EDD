/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Fabiana Rodríguez
 */
public class Arbol {
    private TreeNode root;
    
    public Arbol() {
        this.root = null;
    
    }
    public TreeNode getRoot() {
        return root;
    }
    
    public void setRoot(TreeNode root){
        this.root = root;
    }
    
    public TreeNode crearRoot(Object data) {
        this.root = new TreeNode(data);
        return this.root;
    }
    
    public boolean isEmpty() {
        return this.root = null;
    }
    
    public TreeNode agregarHijo(TreeNode padre, Object data) {
        TreeNode hijo = new TreeNode(data);
        padre.agregarHijo(hijo);
        return hijo;
    }
    
}

