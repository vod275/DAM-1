/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

import java.time.LocalDate;
import java.io.Serializable;

/**
 * Clase que representa a un profesor.
 * Contiene los atributos específicos de un profesor como el identificador, la fecha de alta y la asignatura que imparte.
 * 
 * Esta clase hereda de la clase Persona.
 * 
 * @author Victor Oliver Donoso
 */
public class Profesor extends Persona implements Serializable {
    private String identificadorProfesor;
    private LocalDate fechaAlta;
    private Asignaturas asignaturaImparte;

    /**
     * Constructor de la clase Profesor.
     * 
     * @param dni El DNI del profesor.
     * @param nombreCompleto El nombre completo del profesor.
     * @param correoElectronico El correo electrónico del profesor.
     * @param identificadorProfesor El identificador del profesor.
     * @param fechaAlta La fecha de alta del profesor.
     * @param asignaturaImparte La asignatura que imparte el profesor.
     */
    public Profesor(String dni, String nombreCompleto, String correoElectronico, String identificadorProfesor, LocalDate fechaAlta, Asignaturas asignaturaImparte) {
        super(dni, nombreCompleto, correoElectronico);
        this.identificadorProfesor = identificadorProfesor;
        this.fechaAlta = fechaAlta;
        this.asignaturaImparte = asignaturaImparte;
    }

    /**
     * Obtiene el identificador del profesor.
     * 
     * @return El identificador del profesor.
     */
    public String getIdentificadorProfesor() {
        return identificadorProfesor;
    }

    /**
     * Establece el identificador del profesor.
     * 
     * @param identificador El identificador del profesor.
     */
    public void setIdentificador(String identificador) {
        this.identificadorProfesor = identificador;
    }

    /**
     * Obtiene la fecha de alta del profesor.
     * 
     * @return La fecha de alta del profesor.
     */
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Establece la fecha de alta del profesor.
     * 
     * @param fechaAlta La fecha de alta del profesor.
     */
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * Obtiene la asignatura que imparte el profesor.
     * 
     * @return La asignatura que imparte el profesor.
     */
    public Asignaturas getAsignaturaImparte() { 
        return asignaturaImparte;
    }

    /**
     * Establece la asignatura que imparte el profesor.
     * 
     * @param asignaturaImparte La asignatura que imparte el profesor.
     */
    public void setAsignaturaImparte(Asignaturas asignaturaImparte) { 
        this.asignaturaImparte = asignaturaImparte;
    }
}
 