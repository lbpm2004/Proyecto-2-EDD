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
import org.json.JSONArray;
import org.json.JSONObject;
import Estructuras.ClaveDicotomica;
import Estructuras.ABB;
import Estructuras.NodoABB;
import Estructuras.TablaHash;

/**
 * Clase que representa la interfaz gráfica principal del programa.
 * @author Luis Peña
 * @Colaboradores Fabiana Rodríguez y Drexler Hurtado
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
    private JPanel center;
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
                DeterminarEspecie(); 

            }
        });
        
        buscarEspecie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                if(center != null){
                    remove(center);
                }
                
                String especie = campoBusqueda.getText();
                if (especie.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de una especie.");
                    return;
                }

                long startTime=0, endTime=0;
                String resultado = "";
                center = new JPanel(new GridLayout(5,1));
                
                if (buscarEspeciePorHash.isSelected()) {
                    startTime = System.nanoTime();
                    resultado = buscarPorHash(especie); // Implementa esta función.
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
                JLabel verTiempo = new JLabel("Tiempo de ejecución: " + Long.toString(tiempo) + " nanosegundos");
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
    * Método que permite al usuario determinar una especie a través de una serie de preguntas dicotómicas (sí/no) presentadas en sucesión. El proceso comienza desde la raíz del árbol binario y avanza hacia los nodos hoja (especies) según las respuestas del usuario.
    */
    private void DeterminarEspecie() {
        // Verificar si el árbol ha sido cargado
        if (arbol == null || arbol.getRoot() == null) {
            JOptionPane.showMessageDialog(null, "No se ha cargado ningún árbol. Por favor, cargue un archivo JSON primero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Iniciar desde la raíz del árbol
        NodoABB<String> nodoActual = arbol.getRoot();

        // Recorrer el árbol hasta encontrar una especie
        while (nodoActual != null) {
            String valorNodo = nodoActual.getValor();

            // Si el nodo actual es una especie (hoja del árbol)
            if (tablaHash.buscar(valorNodo) != null) {
                String caracteristicas = tablaHash.buscar(valorNodo);
                JOptionPane.showMessageDialog(null, "Especie determinada: " + valorNodo + "\nCaracterísticas: " + caracteristicas, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Si el nodo actual es una pregunta, solicitar respuesta al usuario
            String respuesta;
            do {
                respuesta = obtenerRespuestaUsuario(valorNodo);
                if (!respuesta.equalsIgnoreCase("Sí") && !respuesta.equalsIgnoreCase("No")) {
                    JOptionPane.showMessageDialog(null, "Respuesta no válida. Por favor, responda 'Sí' o 'No'.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (!respuesta.equalsIgnoreCase("Sí") && !respuesta.equalsIgnoreCase("No"));

            // Avanzar al siguiente nodo según la respuesta
            if (respuesta.equalsIgnoreCase("Sí")) {
                nodoActual = nodoActual.getHijoSi();
            } else {
                nodoActual = nodoActual.getHijoNo();
            }
        }

        // Si no se encuentra ninguna especie
        JOptionPane.showMessageDialog(null, "No se pudo determinar ninguna especie.", "Resultado", JOptionPane.WARNING_MESSAGE);
    }

    /**
    * Obtiene la respuesta del usuario desde una ventana emergente.
    *
    * @param pregunta Pregunta a mostrar al usuario.
    * @return Respuesta del usuario ("Sí" o "No").
    */
    private String obtenerRespuestaUsuario(String pregunta) {
        String[] opciones = {"Sí", "No"};
        int seleccion = JOptionPane.showOptionDialog(null, pregunta, "Respuesta", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        return (seleccion == 0) ? "Sí" : "No";
    }
    
    
    
    /**
    * Realiza una búsqueda en el árbol binario para encontrar una especie y reconstruye las preguntas que llevan a dicha especie.
    *
    * @param nombreEspecie El nombre de la especie que se desea buscar.
    * @return Un mensaje indicando si la especie fue encontrada, junto con
    *         las preguntas que llevan a ella. Si no se encuentra la especie,
    *         se devuelve un mensaje de error.
    */
    private String buscarPorRecorrido(String nombreEspecie) {
        // Llamar al método recursivo para buscar la especie
        StringBuilder preguntas = new StringBuilder();
        boolean encontrada = buscarEspecieConPreguntas(arbol.getRoot(), nombreEspecie, preguntas);

        if (encontrada) {
            return "Especie encontrada: " + nombreEspecie + "\nPreguntas que llevan a la especie:\n" + preguntas.toString();
        } else {
            return "La especie '" + nombreEspecie + "' no fue encontrada.";
        }
    }
    
    /**
    * Método recursivo que busca una especie en el árbol binario y reconstruye el camino de preguntas que llevan a dicha especie.
    *
    * @param nodo El nodo actual del árbol binario.
    * @param nombreEspecie El nombre de la especie que se desea buscar.
    * @param preguntas Un StringBuilder que almacena las preguntas que llevan a la especie durante la búsqueda.
    * @return true si la especie fue encontrada; false en caso contrario.
    */
    private boolean buscarEspecieConPreguntas(NodoABB<String> nodo, String nombreEspecie, StringBuilder preguntas) {
        if (nodo == null) {
            return false; // Llegamos al final de una rama sin encontrar la especie
        }

        // Si el valor del nodo coincide con el nombre de la especie
        if (nodo.getValor().equalsIgnoreCase(nombreEspecie)) {
            return true; // Encontramos la especie
        }

        // Intentar buscar en el subárbol "Sí"
        preguntas.append("Sí -> ");
        if (buscarEspecieConPreguntas(nodo.getHijoSi(), nombreEspecie, preguntas)) {
            return true; // Encontramos la especie en el subárbol "Sí"
        }
        preguntas.delete(preguntas.length() - 5, preguntas.length()); // Eliminar "Sí -> " si no se encontró

        // Intentar buscar en el subárbol "No"
        preguntas.append("No -> ");
        if (buscarEspecieConPreguntas(nodo.getHijoNo(), nombreEspecie, preguntas)) {
            return true; // Encontramos la especie en el subárbol "No"
        }
        preguntas.delete(preguntas.length() - 6, preguntas.length()); // Eliminar "No -> " si no se encontró

        return false; // No se encontró la especie en este nodo ni en sus hijos
    }
    
    /**
    * Realiza una búsqueda en la tabla hash para encontrar una especie y, si existe, reconstruye las preguntas que llevan a dicha especie utilizando el árbol binario.
    *
    * @param nombreEspecie El nombre de la especie que se desea buscar.
    * @return Un mensaje indicando si la especie fue encontrada, junto con las preguntas que llevan a ella y sus características. Si no se encuentra la especie, se devuelve un mensaje de error.
    */
    private String buscarPorHash(String nombreEspecie) {
        // Buscar la especie en la tabla hash
        String especieEncontrada = tablaHash.buscar(nombreEspecie);

        if (especieEncontrada == null) {
            return "La especie '" + nombreEspecie + "' no fue encontrada en la tabla hash.";
        }

        // Reconstruir las preguntas que llevan a la especie usando el árbol
        StringBuilder preguntas = new StringBuilder();
        boolean encontrada = buscarEspecieConPreguntas(arbol.getRoot(), nombreEspecie, preguntas);

        if (encontrada) {
            return "Especie encontrada: " + nombreEspecie + 
                   "\nPreguntas que llevan a la especie:\n" + preguntas.toString() +
                   "\nCaracterísticas: " + especieEncontrada;
        } else {
            return "La especie '" + nombreEspecie + "' fue encontrada en la tabla hash, pero no en el árbol.";
        }
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
