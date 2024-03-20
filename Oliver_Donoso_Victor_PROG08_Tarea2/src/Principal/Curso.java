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
import java.util.List;

/**
 *
 * @author Victor Oliver Donoso
 */
public class Curso {
    
 // Constantes
    static final int NUM_ASIGNATURAS = 7;
    static final String NOMBRE_CURSO = "DAM 1 E-Learning";

    // Atributos
    private String nombreCurso;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private double[][] notas;
    private int numAlumnosMatriculados;
    private int MAX_ALUMNOS;
     private List<Estudiante> estudiantes;
    private Asignaturas[] asignaturas;


    // Constructor
    public Curso(String nombreCurso, LocalDate fechaInicial, LocalDate fechaFinal, double[][] notas, int numAlumnosMatriculados) {
        this.nombreCurso = NOMBRE_CURSO;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.notas = new double[MAX_ALUMNOS][NUM_ASIGNATURAS];
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

    public double[][] getNotas() {
        return notas;
    }

    public void setNotas(double[][] notas) {
        this.notas = notas;
    }

    public int getNumAlumnosMatriculados() {
        return numAlumnosMatriculados;
    }

    public void setNumAlumnosMatriculados(int numAlumnosMatriculados) {
        this.numAlumnosMatriculados = numAlumnosMatriculados;
    }

  
    public void agregarEstudiante(Estudiante estudiante, double[] notasEstudiante) {
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
        int i = 0;
        for (Estudiante estudiante : estudiantes) {
            identificadores[i++] = estudiante.getIdentificador();
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
    public int contarAprobados(double[][] notas) {
        int contadorAprobados = 0;
        for (double[] alumnoNotas : notas) {
            if (esAprobado(alumnoNotas)) {
                contadorAprobados++;
            }
        }
        return contadorAprobados;
    }

    // Método auxiliar para verificar si un alumno está aprobado
    private boolean esAprobado(double[] alumnoNotas) {
        for (double nota : alumnoNotas) {
            if (nota < 5) {
                return false;
            }
        }
        return true;
    }
    

    // Método para calcular la nota media de una asignatura
    public double calcularNotaMedia(double[][] notas) {
        double sumaNotas = 0;
        int totalNotas = 0;
        for (double[] alumnoNotas : notas) {
            for (double nota : alumnoNotas) {
                sumaNotas += nota;
                totalNotas++;
            }
        }
        return totalNotas > 0 ? sumaNotas / totalNotas : 0;
    }

        // Método para calcular la nota mínima de una asignatura
    public double calcularNotaMinima(double[][] notas) {
        double notaMinima = Double.MAX_VALUE;
        for (double[] alumnoNotas : notas) {
            for (double nota : alumnoNotas) {
                notaMinima = Math.min(notaMinima, nota);
            }
        }
        return notaMinima != Double.MAX_VALUE ? notaMinima : 0.0; // Si no hay notas, devolver 0.0
    }

    // Método para calcular la nota máxima de una asignatura
    public double calcularNotaMaxima(double[][] notas) {
        double notaMaxima = Double.MIN_VALUE;
        for (double[] alumnoNotas : notas) {
            for (double nota : alumnoNotas) {
                notaMaxima = Math.max(notaMaxima, nota);
            }
        }
        return notaMaxima != Double.MIN_VALUE ? notaMaxima : 0.0; // Si no hay notas, devolver 0.0
    }

    //Metodo para recorrer la lista de estudiantes y encontrar el id 
     public  Estudiante buscarEstudiantesPorId(String identificador, List<Estudiante> estudiantes) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getIdentificador().equals(identificador)) {
                return estudiante;
            }
        }
        return null; 
    }
   
     
        public Estudiante buscarEstudiantesPorIndice(int indice, List<Estudiante> estudiantes) {
         if (indice >= 0 && indice < estudiantes.size()) {
           return estudiantes.get(indice);
          }
         return null;
        }
        
        public double[] calcularMediasPorAsignatura(double[][] notas) {
        double[] mediasPorAsignatura = new double[notas[0].length]; // Inicializar un arreglo para almacenar las medias por asignatura
        for (int j = 0; j < notas[0].length; j++) { // Recorrer las columnas de la matriz de notas (asignaturas)
            double suma = 0;
            int contador = 0;
            for (int i = 0; i < notas.length; i++) { // Recorrer las filas de la matriz de notas (estudiantes)
                suma += notas[i][j];
                contador++;
            }
            mediasPorAsignatura[j] = contador > 0 ? suma / contador : 0; // Calcular la media de la asignatura
        }
        return mediasPorAsignatura;
    }
        
        // Método para calcular la nota media del curso
    public double calcularNotaMediaCurso(double[][] notas) {
        double suma = 0;
        int contador = 0;
        for (int i = 0; i < notas.length; i++) { // Recorrer las filas de la matriz de notas (estudiantes)
            for (int j = 0; j < notas[i].length; j++) { // Recorrer las columnas de la matriz de notas (asignaturas)
                suma += notas[i][j];
                contador++;
            }
        }
        return contador > 0 ? suma / contador : 0; // Calcular la media del curso
    }
    
    // Método para buscar un estudiante por su identificador
    public Estudiante buscarEstudiantesPorIdentificador(String identificador) {
        // Iterar sobre la lista de estudiantes para buscar el que tenga el identificador dado
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getIdentificador().equalsIgnoreCase(identificador)) {
                return estudiante; // Si se encuentra, devolver el estudiante
            }
        }
        return null; // Si no se encuentra, devolver null
    }
    
    
    // Método para eliminar un estudiante por su identificador
    public boolean eliminarEstudiante(String identificador) {
        // Buscar el estudiante por su identificador
        Estudiante estudiante = buscarEstudiantesPorIdentificador(identificador);

        // Si se encuentra al estudiante, eliminarlo de la lista de estudiantes
        if (estudiante != null) {
            return estudiantes.remove(estudiante);
           // Devolver true si se elimina correctamente
        } else {
            return false; // Devolver false si el estudiante no se encuentra en la lista
        }
    }
    
}
