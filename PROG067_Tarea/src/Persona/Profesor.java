/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

import Interfaces.IGestionAcademica;
import java.time.LocalDate;



/**
 *
 * @author Victor Oliver Donoso
 */
public  class Profesor extends Persona {
    private String identificador;
    private LocalDate fechaAlta;
    private Asignaturas asignaturaImparte;

    // Constructor
    public Profesor(String dni, String nombreCompleto, String correoElectronico, String identificador, LocalDate fechaAlta, Asignaturas asignaturaImparte) {
        super(dni, nombreCompleto, correoElectronico);
        this.identificador = identificador;
        this.fechaAlta = fechaAlta;
        this.asignaturaImparte = asignaturaImparte;
    }

    // Getters y setters específicos de Profesor
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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
   