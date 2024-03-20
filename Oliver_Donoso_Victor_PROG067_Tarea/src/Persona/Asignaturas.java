/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

/**
 *
 * @author Victor Oliver Donoso
 */
public enum Asignaturas  {
    
    BD("Bases de datos", "BD", 4),
    ED("Entornos de desarrollo", "ED", 3),
    FOL("Formación y orientación laboral", "FOL", 2),
    ING("Inglés técnico", "ING", 3),
    LMSGI("Lenguajes de marcas", "LMSGI", 3),
    PROG("Programación", "PROG", 5),
    SI("Sistemas informáticos", "SI", 4);
 
    private final String descripcion;
    private final String codigo;
    private final int creditos;
 
    private Asignaturas(String descripcion, String codigo, int creditos) {
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.creditos = creditos;
    }
 
    public String getDescripcion()
{
        return descripcion;
    }
 
    public String getCodigo() {
        return codigo;
    }
 
    public int getCreditos() {
        return creditos;
    }
 
    // Método para obtener la descripcion de la asignatura
    public static String obtenerDescripcionAsignatura(String codigo) {
        for (Asignaturas asignatura : values()) {
            if (asignatura.getCodigo().equals(codigo)) {
                return asignatura.getDescripcion();
            }
        }
        return "Código no encontrado";
    }

    // Método para obtener el código a partir de la posición en la clase
    public static String obtenerCodigoPorPosicion(int posicion) {
        if (posicion >= 0 && posicion < values().length) {
            return values()[posicion].getCodigo();
        } else {
            return null;
        }
    }
    
    public static Asignaturas fromString(String asignatura) {
        for (Asignaturas a : Asignaturas.values()) {
            if (a.getCodigo().equalsIgnoreCase(asignatura)) {
                return a;
            }
        }
        return null; 
    }
}
