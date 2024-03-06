/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

import java.time.LocalDate;
import java.util.Arrays;



/**
 *
 * @author Victor Oliver Donoso
 */
public  class Profesor extends Persona {
    private String identificadorProfesor;
    private LocalDate fechaAlta;
    private Asignaturas asignaturaImparte;

    // Constructor
    public Profesor(String dni, String nombreCompleto, String correoElectronico, String identificadorProfesor, LocalDate fechaAlta, Asignaturas asignaturaImparte) {
        super(dni, nombreCompleto, correoElectronico);
        this.identificadorProfesor = identificadorProfesor;
        this.fechaAlta = fechaAlta;
        this.asignaturaImparte = asignaturaImparte;
    }

    // Getters y setters específicos de Profesor
    public String getIdentificadorProfesor() {
        return identificadorProfesor;
    }

    public void setIdentificador(String identificador) {
        this.identificadorProfesor = identificador;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Asignaturas getAsignaturaImparte() { // Cambio aquí
        return asignaturaImparte;
    }

    public void setAsignaturaImparte(Asignaturas asignaturaImparte) { // Cambio aquí
        this.asignaturaImparte = asignaturaImparte;
    }
  
}
   