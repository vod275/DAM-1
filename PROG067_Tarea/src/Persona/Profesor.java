/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

import Interfaces.IGestionAcademica;
import java.util.Date;


/**
 *
 * @author Victor Oliver Donoso
 */
public abstract class Profesor extends Persona  implements IGestionAcademica {
    private String identificador;
    private Date fechaAlta;
    private Asignaturas asignaturaImparte;

    // Constructor
    public Profesor(String dni, String nombreCompleto, String correoElectronico, String identificador, Date fechaAlta, Asignaturas asignaturaImparte) {
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

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Asignaturas getAsignaturaImparte() { // Cambio aquí
        return asignaturaImparte;
    }

    public void setAsignaturaImparte(Asignaturas asignaturaImparte) { // Cambio aquí
        this.asignaturaImparte = asignaturaImparte;
    }
    
     public  String informeResultados(Profesor profesor) {
        
        return String.format("Informe de resultados del profesor: ",
                profesor.getIdentificador(), profesor.getDni(), profesor.getNombreCompleto(), profesor.getCorreoElectronico());
    }



}