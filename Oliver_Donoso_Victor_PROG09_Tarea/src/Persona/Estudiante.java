/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que representa a un estudiante.
 * Extiende de la clase Persona y es Serializable para poder ser serializada.
 * 
 * @author Victor Oliver Donoso
 */
public class Estudiante extends Persona implements Serializable {
    private String identificador;
    private LocalDate fechaMatriculacion;

    /**
     * Constructor de la clase Estudiante.
     * 
     * @param dni DNI del estudiante.
     * @param nombreCompleto Nombre completo del estudiante.
     * @param correoElectronico Correo electrónico del estudiante.
     * @param identificador Identificador único del estudiante.
     * @param fechaMatriculacion Fecha de matriculación del estudiante.
     */
    public Estudiante(String dni, String nombreCompleto, String correoElectronico, String identificador, LocalDate fechaMatriculacion) {
        super(dni, nombreCompleto, correoElectronico);
        this.identificador = identificador;
        this.fechaMatriculacion = fechaMatriculacion;
    }

    /**
     * Obtiene el identificador del estudiante.
     * 
     * @return Identificador del estudiante.
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * Establece el identificador del estudiante.
     * 
     * @param identificador Identificador del estudiante.
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * Obtiene la fecha de matriculación del estudiante.
     * 
     * @return Fecha de matriculación del estudiante.
     */
    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    /**
     * Establece la fecha de matriculación del estudiante.
     * 
     * @param fechaMatriculacion Fecha de matriculación del estudiante.
     */
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }
    
    /**
     * Compara este estudiante con otro estudiante basado en su identificador.
     * 
     * @param otroEstudiante El otro estudiante con el que comparar.
     * @return El valor 0 si los identificadores son iguales; un valor negativo si el identificador de este estudiante
     * es menor que el del otro estudiante; un valor positivo si el identificador de este estudiante es mayor que el del otro estudiante.
     */
    public int compareTo(Estudiante otroEstudiante) {
        return this.identificador.compareTo(otroEstudiante.getIdentificador());
    }

}
