/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.util.Date;

/**
 *
 * @author Victor Oliver Donoso
 */
public class Curso {
    
 // Constantes
    static final int MAX_ALUMNOS = 100;
    static final int NUM_ASIGNATURAS = 7;
    static final String NOMBRE_CURSO = "DAM 1 E-Learning";

    // Atributos
    private String nombreCurso;
    private Date fechaInicial;
    private Date fechaFinal;
    private int[][] notas;
    private int numAlumnosMatriculados;

    // Constructor
    public Curso(Date fechaInicial, Date fechaFinal) {
        this.nombreCurso = NOMBRE_CURSO;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.notas = new int[MAX_ALUMNOS][NUM_ASIGNATURAS];
        this.numAlumnosMatriculados = 0;
    }

    public Curso(String nombreCurso, Date fechaInicial, Date fechaFinal, int[][] notas, int numAlumnosMatriculados) {
        this.nombreCurso = nombreCurso;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.notas = notas;
        this.numAlumnosMatriculados = numAlumnosMatriculados;
    }

  
    public void agregarNotas(int[][] notas) {
        this.notas = notas;
    }
    
}
