/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

import java.io.Serializable;

/**
 * Enumeración que representa las asignaturas disponibles.
 * Cada asignatura tiene una descripción, un código y el número de créditos.
 * Implementa la interfaz Serializable para poder ser serializada.
 * 
 * @author Victor Oliver Donoso
 */
public enum Asignaturas implements Serializable {
    
    /** Asignatura de Bases de datos. */
    BD("Bases de datos", "BD", 4),
    
    /** Asignatura de Entornos de desarrollo. */
    ED("Entornos de desarrollo", "ED", 3),
    
    /** Asignatura de Formación y orientación laboral. */
    FOL("Formación y orientación laboral", "FOL", 2),
    
    /** Asignatura de Inglés técnico. */
    ING("Inglés técnico", "ING", 3),
    
    /** Asignatura de Lenguajes de marcas. */
    LMSGI("Lenguajes de marcas", "LMSGI", 3),
    
    /** Asignatura de Programación. */
    PROG("Programación", "PROG", 5),
    
    /** Asignatura de Sistemas informáticos. */
    SI("Sistemas informáticos", "SI", 4);
 
    private final String descripcion;
    private final String codigo;
    private final int creditos;
 
    /**
     * Constructor de la asignatura.
     * 
     * @param descripcion Descripción de la asignatura.
     * @param codigo Código de la asignatura.
     * @param creditos Número de créditos de la asignatura.
     */
    private Asignaturas(String descripcion, String codigo, int creditos) {
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.creditos = creditos;
    }
 
    /**
     * Obtiene la descripción de la asignatura.
     * 
     * @return Descripción de la asignatura.
     */
    public String getDescripcion() {
        return descripcion;
    }
 
    /**
     * Obtiene el código de la asignatura.
     * 
     * @return Código de la asignatura.
     */
    public String getCodigo() {
        return codigo;
    }
 
    /**
     * Obtiene el número de créditos de la asignatura.
     * 
     * @return Número de créditos de la asignatura.
     */
    public int getCreditos() {
        return creditos;
    }
 
    /**
     * Obtiene la descripción de una asignatura a partir de su código.
     * 
     * @param codigo Código de la asignatura.
     * @return Descripción de la asignatura.
     */
    public static String obtenerDescripcionAsignatura(String codigo) {
        for (Asignaturas asignatura : values()) {
            if (asignatura.getCodigo().equals(codigo)) {
                return asignatura.getDescripcion();
            }
        }
        return "Código no encontrado";
    }

    /**
     * Obtiene el código de una asignatura a partir de su posición en la enumeración.
     * 
     * @param posicion Posición de la asignatura en la enumeración.
     * @return Código de la asignatura.
     */
    public static String obtenerCodigoPorPosicion(int posicion) {
        if (posicion >= 0 && posicion < values().length) {
            return values()[posicion].getCodigo();
        } else {
            return null;
        }
    }
    
    /**
     * Obtiene una asignatura a partir de su código.
     * 
     * @param asignatura Código de la asignatura.
     * @return Asignatura correspondiente al código, o null si no se encuentra.
     */
    public static Asignaturas fromString(String asignatura) {
        for (Asignaturas a : Asignaturas.values()) {
            if (a.getCodigo().equalsIgnoreCase(asignatura)) {
                return a;
            }
        }
        return null; 
    }
}