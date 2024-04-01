/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

/**
 * Clase que representa a una persona.
 * Contiene los atributos básicos de una persona como el DNI, el nombre completo y el correo electrónico.
 * 
 * @author Victor Oliver Donoso
 */
public class Persona {
    private String dni;
    private String nombreCompleto;
    private String correoElectronico;

    /**
     * Constructor de la clase Persona.
     * 
     * @param dni El DNI de la persona.
     * @param nombreCompleto El nombre completo de la persona.
     * @param correoElectronico El correo electrónico de la persona.
     */
    public Persona(String dni, String nombreCompleto, String correoElectronico) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene el DNI de la persona.
     * 
     * @return El DNI de la persona.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI de la persona.
     * 
     * @param dni El DNI de la persona.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre completo de la persona.
     * 
     * @return El nombre completo de la persona.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo de la persona.
     * 
     * @param nombreCompleto El nombre completo de la persona.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     * 
     * @return El correo electrónico de la persona.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el correo electrónico de la persona.
     * 
     * @param correoElectronico El correo electrónico de la persona.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
