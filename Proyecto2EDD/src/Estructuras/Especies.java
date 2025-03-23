/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Clase que representa una especie vegetal.
 * @author Fabiana Rodríguez
 * @Colaboradores Luis Peña
 */
public class Especies {
    private String name;
    private String caracteristicas;

    /**
     * Constructor para inicializar una especie.
     *
     * @param name Nombre de la especie.
     * @param caracteristicas Características asociadas a la especie.
     */
    public Especies(String name, String caracteristicas) {
        this.name = name;
        this.caracteristicas = caracteristicas;
    }

    /**
     * Obtiene el nombre de la especie.
     *
     * @return Nombre de la especie.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene las características de la especie.
     *
     * @return Características de la especie.
     */
    public String getCaracteristica() {
        return caracteristicas;
    }
}
