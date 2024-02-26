/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

import java.util.Date;

/**
 *
 * @author Victor Oliver Donoso
 */
public class Estudiante extends Persona {
    private String identificador;
    private Date fechaMatriculacion;

    // Constructor
    public Estudiante(String dni, String nombreCompleto, String correoElectronico, String identificador, Date fechaMatriculacion) {
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

    public Date getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(Date fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

      public static String informeResultados(Estudiante estudiante) {
      
        return String.format("Informe de resultados del estudiante %s: ",
                estudiante.getIdentificador(), estudiante.getDni(), estudiante.getNombreCompleto(), estudiante.getCorreoElectronico());
    }
}