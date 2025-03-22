/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author Hogar
 */
public class Species {
    private String name;
    private String caracteristicas;
    
    public Species(String name, String caracteristicas) {
        this.name = name;
        this.caracteristicas = caracteristicas;
    }
    public String getName() {
        return name;
    }
    public String getCaracteristica(){
        return caracteristicas;
    }
}
