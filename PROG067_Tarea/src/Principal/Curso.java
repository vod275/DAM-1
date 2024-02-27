/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.time.LocalDate;
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
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int[][] notas;
    private int numAlumnosMatriculados;

    // Constructor
    public Curso(LocalDate fechaInicial, LocalDate fechaFinal) {
        this.nombreCurso = NOMBRE_CURSO;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.notas = new int[MAX_ALUMNOS][NUM_ASIGNATURAS];
        this.numAlumnosMatriculados = 0;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int[][] getNotas() {
        return notas;
    }

    public void setNotas(int[][] notas) {
        this.notas = notas;
    }

    public int getNumAlumnosMatriculados() {
        return numAlumnosMatriculados;
    }

    public void setNumAlumnosMatriculados(int numAlumnosMatriculados) {
        this.numAlumnosMatriculados = numAlumnosMatriculados;
    }

    public Curso(String nombreCurso, LocalDate fechaInicial, LocalDate fechaFinal, int[][] notas, int numAlumnosMatriculados) {
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
