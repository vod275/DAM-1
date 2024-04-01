/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

import java.time.LocalDate;

/**
 *
 * @author Victor Oliver Donoso
 */
public class Estudiante extends Persona {
    private String identificador;
    private LocalDate fechaMatriculacion;

    // Constructor
    public Estudiante(String dni, String nombreCompleto, String correoElectronico, String identificador, LocalDate fechaMatriculacion) {
        super(dni, nombreCompleto, correoElectronico);
        this.identificador = identificador;
        this.fechaMatriculacion = fechaMatriculacion;
    }

    // Getters y setters específicos de Estudiante
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }
    
    public int compareTo(Estudiante otroEstudiante) {
        return this.identificador.compareTo(otroEstudiante.getIdentificador());
    }

}