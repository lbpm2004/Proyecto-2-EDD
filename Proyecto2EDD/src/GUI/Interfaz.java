/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.algorithm.layout.layout;
import org.json.JSONArray;
import org.json.JSONObject;
import Estructuras.ClaveDicotomica;
import Estructuras.ABB;
import Estructuras.NodoABB;
import Estructuras.TablaHash;

/**
 * Clase que representa la interfaz gráfica principal del programa.
 * @author Fabiana Rodríguez
 * @Colaboradores Luis Peña
 */
public class Interfaz extends javax.swing.JFrame {
    private ABB<String> arbol;
    private TablaHash<String, String> tablaHash;
    private ClaveDicotomica claveDicotomica;
    private JLabel instruccion;
    private JLabel instruccion1;
    private JLabel instruccion2;
    private JLabel instruccion3;
    private JButton cargarArchivo;
    private JButton mostrarRecorridoArbol;
    private JButton determinarEspecie;
    private JButton buscarEspecie;
    private JRadioButton buscarEspeciePorHash;
    private JRadioButton buscarEspeciePorRecorrido;
    private JTextField campoBusqueda;
    private int nodeIdCounter = 0; // Contador global para generar IDs únicos
    
    
    /**
     * Constructor que inicializa la interfaz gráfica.
     */
    public Interfaz() {
        setTitle("Clave Dicotómica");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        arbol = new ABB<>();
        tablaHash = new TablaHash<>();
        claveDicotomica = new ClaveDicotomica();
        
        
        //Generación del PAGE_START
        JPanel pageStart = new JPanel(new GridLayout(1,1));
        instruccion = new JLabel("¡Bienvenido, por favor presione el botón 'Cargar Archivo' para usar las funciones del programa!");
        instruccion.setFont(new Font("Arial",Font.PLAIN, 14));
        pageStart.add(instruccion);
        add(pageStart, BorderLayout.PAGE_START);
        
        //Generación del LINE_START
        JPanel lineStart = new JPanel(new GridLayout(10,1));
        lineStart.add(cargarArchivo = new JButton("Cargar Archivo"));
        lineStart.add(instruccion1 = new JLabel("Funciones del programa:"));
        lineStart.add(mostrarRecorridoArbol = new JButton("Mostrar Árbol"));
        lineStart.add(determinarEspecie = new JButton("Determinar Especie"));
        lineStart.add(instruccion2 = new JLabel("Introduzca el nombre de la especie:"));
        lineStart.add(campoBusqueda = new JTextField());
        lineStart.add(instruccion3 = new JLabel("Seleccione el método de búsqueda y presione el botón:"));
        ButtonGroup grupoBusqueda = new ButtonGroup();
        buscarEspeciePorHash = new JRadioButton("Por Hash");
        buscarEspeciePorRecorrido = new JRadioButton("Por Recorrido del árbol");
        grupoBusqueda.add(buscarEspeciePorHash);
        grupoBusqueda.add(buscarEspeciePorRecorrido);
        lineStart.add(buscarEspeciePorHash);
        lineStart.add(buscarEspeciePorRecorrido);
        lineStart.add(buscarEspecie = new JButton("Buscar Especie"));
        add(lineStart, BorderLayout.LINE_START);
        
        pack();
        
        cargarArchivo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        // Cargar el archivo JSON
                        claveDicotomica.cargarArchivo(selectedFile.getAbsolutePath());

                        // Obtener el árbol binario y la tabla hash
                        arbol = claveDicotomica.getArbol();
                        tablaHash = claveDicotomica.getTablaHash();

                        // Actualizar la instrucción al usuario
                        JOptionPane.showMessageDialog(null,"Archivo cargado exitosamente: " + selectedFile.getName());
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error al cargar el archivo: " + e.getMessage());
                    }
                }
            }
        });
        
        mostrarRecorridoArbol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Verificar si el árbol ha sido cargado
                if (arbol == null || arbol.getRoot() == null) {
                    JOptionPane.showMessageDialog(null, "No se ha cargado ningún árbol. Por favor, cargue un archivo JSON primero.");
                    return;
                }
                
                // Configurar el backend de GraphStream
                System.setProperty("org.graphstream.ui", "swing");
        
                // Crear un nuevo grafo
                Graph graph = new SingleGraph("Clave Dicotómica");

                // Configurar el estilo del grafo
                graph.setAttribute("ui.stylesheet", "node { fill-color: blue; text-size: 14; text-color: white; } edge { fill-color: black; }");

                // Llamar al método recursivo para agregar nodos y aristas al grafo
                agregarNodosConPosiciones(graph, arbol.getRoot(), null, 0, 0, 0);
                
                // Mostrar el grafo en una ventana
                graph.display();
            }
        });
        
        determinarEspecie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //lógica para mostrar las preguntas, en sucesion, y marcar como "Si" o "No" hasta llegar a una especie.
                
            }
        });
        
        buscarEspecie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String especie = campoBusqueda.getText();
                if (especie.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de una especie.");
                    return;
                }

                long startTime, endTime;
                String resultado = "";
                JPanel center = new JPanel(new GridLayout(5,1));
                
                if (buscarEspeciePorHash.isSelected()) {
                    startTime = System.nanoTime();
                    resultado = buscarPorHash(especie); // Implementa esta función. Pro
                    endTime = System.nanoTime();
                } else if (buscarEspeciePorRecorrido.isSelected()) {
                    startTime = System.nanoTime();
                    resultado = buscarPorRecorrido(especie); // Implementa esta función. 
                    endTime = System.nanoTime();
                } else {
                    resultado = "Seleccione un método de búsqueda.";
                }
                
                JLabel resultadoBusqueda = new JLabel(resultado);
                center.add(resultadoBusqueda);
                
                long tiempo = endTime - startTime;
                JLabel verTiempo = new JLabel("Tiempo de ejecución: " + Long.toString(tiempo) + " ns");
                center.add(verTiempo);
                add(center, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    /**
    * Método recursivo para agregar nodos al grafo.
    *
    * @param graph Grafo de GraphStream.
    * @param nodoActual Nodo actual del árbol binario.
    * @param padre Nodo padre en el grafo (puede ser null).
    */
    private void agregarNodosConPosiciones(Graph graph, NodoABB<String> nodoActual, Node padre, int x, int y, int nivel) {
        if (nodoActual == null) {
            return;
        }

        // Generar un ID único para el nodo
        String idNodo = "node_" + nodeIdCounter++;
        Node nodoGrafo = graph.addNode(idNodo);

        // Establecer posición del nodo
        nodoGrafo.setAttribute("x", x);
        nodoGrafo.setAttribute("y", y);

        // Establecer etiqueta del nodo
        nodoGrafo.setAttribute("ui.label", nodoActual.getValor());

        // Conectar con el padre si existe
        if (padre != null) {
            graph.addEdge(padre.getId() + "-" + idNodo, padre, nodoGrafo);
        }

        // Recursivamente agregar hijos
        int xOffset = 100 / (nivel + 1); // Ajustar el espacio horizontal según el nivel
        agregarNodosConPosiciones(graph, nodoActual.getHijoSi(), nodoGrafo, x - xOffset, y + 100, nivel + 1);
        agregarNodosConPosiciones(graph, nodoActual.getHijoNo(), nodoGrafo, x + xOffset, y + 100, nivel + 1);
    }
    
    /**
     * Método principal que inicia la aplicación.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
