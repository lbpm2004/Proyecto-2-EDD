/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

/**
 *
 * @author Hogar
 */
public class Arboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

//ARBOLES GENERALES
class Nodo 
    int valor; 
    List<Nodo> hijos;

//CONSTRUCTOR
    public Nodo(int valor) {
        this.valor = valor; 
        this.hijos = new ArrayList<>();
}

//METODO PARA AGREGAR UN HIJO
    public void agregarHijo(Nodo hijo) {
        this.hijos.add(hijo);
    }
}
class Arbol {
    Nodo raiz; 

//CONSTRUCTOR
    public Arbol(int valor) {
        this.raiz = new Nodo(valor);
    }

//METODO PARA RECORRER EL ARBOL EN PREORDEN 
    public void preorden(Nodo nodo) {
        if (nodo == null)return;
        System.out.print(nodo.valor + "");
        for(Nodo hijo: nodo.hijos) {
            preorden(hijo);
        }
    }
}
//EJEMPLO DE USO
Arbol arbol = new Arbol(1);
Nodo nodo2 = new Nodo(2);
Nodo nodo3 = new Nodo(3);
arbol.raiz.agregarHijo(nodo2);
arbol.raiz.agregarHijo(nodo3);
arbol.preorden(arbol.raiz); //salida: 1 2 3

//ARBOLES BINARIOS
class NodoBST {
    int valor; 
    NodoBST izquierdo, derecho;

//CONSTRUCTOR
    public NodoBST(int valor) {
        this.valor = valor; 
        this.izquierdo = this.derecho = null
    }
}

class BST {
    NodoBST raiz;

//CONSTRUCTOR
    public BST(){
this.raiz = null;
}

//METODO PARA INSERTAR UN VALOR 
    public void insertar(int valor)
        raiz = insertarRec(raiz, valor);
}

    private NodoBST insertarRec(NodoBST raiz, int valor);
        if (raiz == null){
        raiz = new NodoBST(valor);
        return raiz;
}

        if (valor < raiz.valor){
            raiz.izquierdo = insertarRec(raiz.izquierdo, valor);
}       else if (valor > raiz.valor) {
            raiz.derecho = insertarRec(raiz.derecho, valor);
}
        return raiz
}

//METODO PARA RECORRER EL ARBOL EN INORDEN
    public void inorden(NodoBST raiz) {
        if (raiz != null){
            inorden(raiz.izquierdo);
            System.out.print(raiz, valor + "");
            inorden(raiz.derecho);
        }
    }
}

//EJEMPLO DE USO
BST arbol = new BST();
arbol.insertar(50);
arbol.insertar(30);
arbol.insertar(20);
arbol.insertar(40);
arbol.insertar(70);
arbol.insertar(60);
arbol.insertar(80);
arbol.inorden(arbol.raiz); //Salida: 20 30 40 50 60 70 80

//IMPLEMENTACION CON APUNTADORES
class Nodo<T> {
    public T tInfo;
    public Nodo<T> hijo_izq;
    public Nodo<T> hijo_der;
}

class ArbolG<T> {
    private Nodo<T> pRoot;
    //Funciones publicas
}

//IMPLEMENTACION CON ARREGLOS
class Nodo<T> {
    private T elemento;
    private int hijo_der;
    private int hijo_izq;
    //Constructor y destructor
}

class ArbolB<T> {
    private int pRoot, maz;
    private Nodo<T>[] memoria;
    //Funciones publicas
}

//PREORDEN
void preorden(Nodo) <T> root {
	if (root != null) {
            Visitar(root);
            preorden(root.hijo_izq);
            preorden(root.hijo_der);
}
}

//INORDEN
void inorden(Nodo<T> root) {
    if (root != null){
        inorden(root.hijo_izq);
        Visitar(root);
        inorden(root.hijo_der);
}
}

//POSTORDEN
    void postorden(Nodo<T> root) {
        if (root != null){
            postorden(root.hijo_izq);
            postorden(root.hijo_der);
            Visitar(root);
}
}

//BUSQUEDA
Nodo buscar(int x, Nodo root){
    if (root == null) return null;
    if (x < root.info) return buscar(x, root.hijo_izq);
    if (x > root.info) return buscar(x, root.hijo_der);
    else return root;
}

//INSERCION
NodoBST insertar(NodoBST nodo, int valor) {
    if (nodo == null){
        return new NodoBST(valor); //crear nuevo nodo si el arbol esta vacio
}
    if (valor < nodo.valor){
    nodo.izquierdo = insertar(nodo.izquierdo, valor); // Insertar en el subarbol izquierdo
}
    else if (valor > nodo.valor){
        nodo.derecho = insertar(nodo.derecho, valor) //Insertar en el subarbol derecho
}
    return nodo; //Retornar el nodo actual
}

//ELIMINACION
NodoBST eliminar(NodoBST nodo, int valor){
    if (nodo == null){
        return null; //Si el arbol esta vacio, no hay nada que eliminar
}
    if (valor < nodo.valor) {
        nodo.izquierdo = eliminar(nodo.izquierdo, valor); //Buscar en el subarbol izquierdo
}
    else if (valor > nodo.valor){
        nodo.derecho = eliminar(nodo.derecho, valor); //Buscar en el subarbol derecho
    }else{
//Caso 1: Nodo sin hijos o con un hijo
        if (nodo.izquierdo == null){
            return nodo.derecho; // Reemplazar por el hijo derecho
}       else if (nodo.derecho == null){
            return nodo.izquierdo; //Reemplazar por el hijo izquierdo
}
//Caso 2: Nodo con dos hijos
    nodo.valor = encontrarMinimo(nodo.derecho); //Reemplazar por el sucesor
    nodo.derecho = eliminar(nodo.derecho, nodo.valor); //Eliminar el sucesor
}
return nodo; //Retornar el nodo actual
}

int encontrarMinimo(NodoBST nodo) {
    while(nodo. izquierdo != null) {
        nodo = nodo.izquierdo; //Encontrar el valor minimo en el subarbol
}
return nodo.valor;
}


//ARBOLES-B
class NodoB {
    int[] claves;
    NodoB hijos;
    int numClaves;
    boolean esHoja;

//CONSTRUCTOR
    public NodoB(int orden, boolean esHoja) {
        this.claves = new int[2 * orden -1];
        this.hijos = new NodoB[2 * orden];
        this.numClaves = 0;
        this.esHoja = esHoja;
}

//METODO PARA BUSCAR UNA CLAVE
    public NodoB buscar(int clave) {
        int i = 0;
        while (1 < numClaves && claves[i] == clave){
            i++;
}
        if (i < numClaves && claves[i] == clave) {
            return this;
}
        if (esHoja) {
            return null;
}
        return hijos[i].buscar(clave);
}
}

class ArbolB {
    NodoB raiz; 
    int orden; 

//CONSTRUCTOR
    public ArbolB(int orden){
        this.raiz = null;
        this.orden = orden; 
}

//METODO PARA BUSCAR UNA CLAVE
   public NodoB buscar(int clave){
        return (raiz == null) ? null : raiz.buscar(clave);
}
}
//EJEMPLO DE USO
Arbol arbol = new ArbolB(3);
//Aqui se podrian agregar metodos para insertar y eliminar claves

//ARBOLES BALANCEADOS
class NodoAVL {
    int valor, altura;
    NodoAVL izquierdo, derecho;

//CONSTRUCTOR
    public NodoAVL(int valor) {
        this.valor = valor; 
        this.altura = 1;
}
}
class AVL {
    NodoAVL raiz;

//METODO PARA OBTENER EL BALANCE DE UN NODO
    private int valance(NodoAVL nodo) {
        return(nodo == null) ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
}

//METODO PARA REALIZAR UNA ROTACION SIMPLE A LA DERCEHA
    private NodoAVL rotarderecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;
        x.derecho = y;
        y.izquierdo = T2;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) +1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        return x;
}
//METODO PARA INSERTAR UN VALOR 
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
}
     private NodoAVL insertarRec(NodoAVL nodo, int valor){
        if (nodo == null){
            return new NodoAVL(valor):
}
        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, valor);
}       else if (valor > nodo.valor) {
            nodo.derecjo = insertarRec(nodo.derecho, valor);
}       else {
            return nodo; //No se permiten valores aplicados
}
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
        int balance = balance(nodo);

//Rotacion simple a la derecha
        if (balance > 1 && valor < nodo.izquierdo.valor){
            return rotarDerecha(nodo);
}

//Rotacion simple hacia la izquierda
        if (balance < -1 && valor > nodo.derecho.valor){
            return rotarIzquierda(nodo);
}
//Rotacion doble hacia la derecha
        if (balance > 1 && valor > nodo.izquierdo.valor){
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);  
}
//Rotacion doble hacia la izquierda 
 if (balance < -1 && valor < nodo.derecho.valor){
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);  
}
return nodo; 
}
}
//EJEMPLO DE USO
AVL arbol = new AVL();
arbol.insertar(10);
arbol.insertar(20);
arbol.insertar(30);
arbol.insertar(40);