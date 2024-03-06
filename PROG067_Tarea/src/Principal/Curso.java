/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Persona.Asignaturas;
import Persona.Estudiante;
import Persona.Profesor;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    private Estudiante[] estudiantes;
    private Asignaturas[] asignaturas;


    // Constructor
    public Curso(String nombreCurso, LocalDate fechaInicial, LocalDate fechaFinal, int[][] notas, int numAlumnosMatriculados) {
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

  
     public void agregarEstudiante(Estudiante estudiante, int[] notasEstudiante) {
        // Verificar si hay espacio disponible en la tabla de notas
        if (numAlumnosMatriculados >= MAX_ALUMNOS) {
            System.out.println("Error: No hay espacio disponible para más estudiantes.");
            return;
        }

        // Agregar estudiante a la lista de alumnos matriculados
        numAlumnosMatriculados++;

        // Obtener la posición del estudiante en la lista
        int posicionEstudiante = numAlumnosMatriculados - 1;

        // Guardar las notas del estudiante en la tabla de notas del curso
        notas[posicionEstudiante] = Arrays.copyOf(notasEstudiante, NUM_ASIGNATURAS);     
    }
     
      public String[] getIdentificadoresEstudiantes() {
        String[] identificadores = new String[numAlumnosMatriculados];
        for (int i = 0; i < numAlumnosMatriculados; i++) {
            identificadores[i] = estudiantes[i].getIdentificador();
        }
        return identificadores;
    }
      
      public String[] getAsignaturas() {
        String[] codigos = new String[ NUM_ASIGNATURAS];
        for (int i = 0; i <  NUM_ASIGNATURAS; i++) {
            codigos[i] = asignaturas[i].getCodigo();
        }
        return codigos;
    }
      
      
      public  Profesor buscarProfesorPorId(String idProfesor, List<Profesor> profesores) {
        for (Profesor profesor : profesores) {
            if (profesor.getIdentificadorProfesor().equals(idProfesor)) {
                return profesor;
            }
        }
        return null; 
    }
    public int contarAprobados(int[][] notas) {
        int contadorAprobados = 0;
        for (int[] alumnoNotas : notas) {
            if (esAprobado(alumnoNotas)) {
                contadorAprobados++;
            }
        }
        return contadorAprobados;
    }

    // Método auxiliar para verificar si un alumno está aprobado
    private boolean esAprobado(int[] alumnoNotas) {
        for (int nota : alumnoNotas) {
            if (nota < 5) {
                return false;
            }
        }
        return true;
    }
    

    // Método para calcular la nota media de una asignatura
    public double calcularNotaMedia(int[][] notas) {
        double sumaNotas = 0;
        int totalNotas = 0;
        for (int[] alumnoNotas : notas) {
            for (int nota : alumnoNotas) {
                sumaNotas += nota;
                totalNotas++;
            }
        }
        return totalNotas > 0 ? sumaNotas / totalNotas : 0; // Evitar división por cero
    }

    // Método para calcular la nota mínima de una asignatura
    public int calcularNotaMinima(int[][] notas) {
        int notaMinima = Integer.MAX_VALUE;
        for (int[] alumnoNotas : notas) {
            for (int nota : alumnoNotas) {
                notaMinima = Math.min(notaMinima, nota);
            }
        }
        return notaMinima != Integer.MAX_VALUE ? notaMinima : 0; // Si no hay notas, devolver 0
    }

    // Método para calcular la nota máxima de una asignatura
    public int calcularNotaMaxima(int[][] notas) {
        int notaMaxima = Integer.MIN_VALUE;
        for (int[] alumnoNotas : notas) {
            for (int nota : alumnoNotas) {
                notaMaxima = Math.max(notaMaxima, nota);
            }
        }
        return notaMaxima != Integer.MIN_VALUE ? notaMaxima : 0; // Si no hay notas, devolver 0
    }
      
    
     public  Estudiante buscarEstudiantesPorId(String identificador, List<Estudiante> estudiantes) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getIdentificador().equals(identificador)) {
                return estudiante;
            }
        }
        return null; 
    }
   
    
}
