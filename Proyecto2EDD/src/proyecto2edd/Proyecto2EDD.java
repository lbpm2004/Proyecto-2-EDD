/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2edd;

import GUI.Interfaz;

/**
 * Clase principal del proyecto.
 * Esta clase actúa como el punto de entrada del programa. Inicializa la interfaz gráfica y la hace visible para el usuario.
 *
 * @author Luis Peña
 * @Colaboradores Fabiana Rodríguez
 */
public class Proyecto2EDD {

    /**
     * Método principal que inicia la aplicación.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Interfaz interfaz = new Interfaz();
        interfaz.setLocationRelativeTo(null); //método para que la interfaz apareczca centrada
        interfaz.setVisible(true);
    }
    
}
