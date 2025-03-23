/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ClaveDicotomica {
    private ABB<String> arbol;

    public ClaveDicotomica() {
        this.arbol = new ABB<>();
    }

    /**
     * Carga un archivo JSON y construye el árbol binario.
     *
     * @param filePath Ruta del archivo JSON.
     */
    public void cargarArchivo(String filePath) throws IOException {
        // Leer el contenido del archivo
        String content = new String(Files.readAllBytes(new File(filePath).toPath()));
        JSONObject json = new JSONObject(content);

        // Obtener la clave principal (nombre de la clave dicotómica)
        String clavePrincipal = json.keys().next();
        JSONArray especiesArray = json.getJSONArray(clavePrincipal);

        // Construir el árbol binario
        construirArbol(especiesArray);
    }

    /**
     * Construye el árbol binario a partir de la lista de especies.
     *
     * @param especiesArray Lista de especies en formato JSON.
     */
    private void construirArbol(JSONArray especiesArray) {
        // Crear la raíz del árbol (primera pregunta común)
        JSONObject primeraEspecie = especiesArray.getJSONObject(0);
        String primeraPregunta = primeraEspecie.getJSONArray(primeraEspecie.keys().next()).getJSONObject(0).keys().next();
        NodoABB<String> root = arbol.crearRoot(primeraPregunta);

        // Procesar cada especie
        for (int i = 0; i < especiesArray.length(); i++) {
            JSONObject especie = especiesArray.getJSONObject(i);
            String nombreEspecie = especie.keys().next();
            JSONArray preguntas = especie.getJSONArray(nombreEspecie);

            // Agregar la especie al árbol
            agregarEspecie(root, preguntas, nombreEspecie);
        }
    }

    /**
    * Agrega una especie al árbol siguiendo las preguntas.
    *
    * @param nodoActual Nodo actual en el árbol.
    * @param preguntas  Lista de preguntas para llegar a la especie.
    * @param especie    Nombre de la especie.
    */
    private void agregarEspecie(NodoABB<String> nodoActual, JSONArray preguntas, String especie) {
        for (int i = 0; i < preguntas.length(); i++) {
           JSONObject preguntaObj = preguntas.getJSONObject(i);
           String pregunta = preguntaObj.keys().next();
           boolean respuesta = preguntaObj.getBoolean(pregunta);

           // Verificar si la pregunta ya existe en el árbol
           NodoABB<String> siguienteNodo;
           if (respuesta) {
               siguienteNodo = nodoActual.getHijoSi();
           } else {
               siguienteNodo = nodoActual.getHijoNo();
           }

           // Si el nodo no existe, agregarlo al árbol
           if (siguienteNodo == null) {
               arbol.agregarHijo(nodoActual, pregunta, respuesta); // Pasar el String directamente
               siguienteNodo = respuesta ? nodoActual.getHijoSi() : nodoActual.getHijoNo();
            }

           // Avanzar al siguiente nodo
           nodoActual = siguienteNodo;
        }

       // Al final de las preguntas, agregar la especie como hoja
       arbol.agregarHijo(nodoActual, especie, true); // Agregar la especie como "Sí"
    }

    /**
     * Método para obtener el árbol binario construido.
     *
     * @return Árbol binario.
     */
    public ABB<String> getArbol() {
        return arbol;
    }
}