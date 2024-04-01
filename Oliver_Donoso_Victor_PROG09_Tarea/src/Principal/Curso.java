/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Persona.Asignaturas;
import Persona.Estudiante;
import Persona.Profesor;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa un curso académico.
 * Un curso tiene un nombre, una fecha de inicio, una fecha de finalización,
 * una matriz de notas de los estudiantes matriculados, y una lista de estudiantes.
 * Implementa la interfaz Serializable para permitir su almacenamiento y recuperación.
 * 
 * Esta clase proporciona métodos para obtener y establecer los atributos del curso,
 * así como para agregar estudiantes, buscar profesores y estudiantes, y calcular estadísticas de notas.
 * También incluye métodos para calcular medias, mínimos y máximos de notas, y para eliminar estudiantes del curso.
 * 
 * @author Victor Oliver Donoso
 */
public class Curso implements Serializable {
    
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
    private List<Asignaturas> asignaturas;

    /**
     * Constructor de la clase Curso.
     * 
     * @param nombreCurso el nombre del curso.
     * @param fechaInicial la fecha de inicio del curso.
     * @param fechaFinal la fecha de finalización del curso.
     * @param notas la matriz de notas de los estudiantes matriculados.
     * @param numAlumnosMatriculados el número de alumnos matriculados en el curso.
     */
    public Curso(String nombreCurso, LocalDate fechaInicial, LocalDate fechaFinal, double[][] notas, int numAlumnosMatriculados) {
        this.nombreCurso = NOMBRE_CURSO;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.notas = new double[MAX_ALUMNOS][NUM_ASIGNATURAS];
        this.numAlumnosMatriculados = 0;
    }

        /**
     * Método para obtener el nombre del curso.
     * 
     * @return el nombre del curso.
     */
    public String getNombreCurso() {
        return nombreCurso;
    }

    /**
     * Método para establecer el nombre del curso.
     * 
     * @param nombreCurso el nuevo nombre del curso.
     */
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    /**
     * Método para obtener la fecha de inicio del curso.
     * 
     * @return la fecha de inicio del curso.
     */
    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    /**
     * Método para establecer la fecha de inicio del curso.
     * 
     * @param fechaInicial la nueva fecha de inicio del curso.
     */
    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * Método para obtener la fecha de finalización del curso.
     * 
     * @return la fecha de finalización del curso.
     */
    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Método para establecer la fecha de finalización del curso.
     * 
     * @param fechaFinal la nueva fecha de finalización del curso.
     */
    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Método para obtener las notas de los estudiantes matriculados en el curso.
     * 
     * @return una matriz de notas de los estudiantes.
     */
    public double[][] getNotas() {
        return notas;
    }

    /**
     * Método para establecer las notas de los estudiantes matriculados en el curso.
     * 
     * @param notas la nueva matriz de notas de los estudiantes.
     */
    public void setNotas(double[][] notas) {
        this.notas = notas;
    }

    /**
     * Método para obtener el número de alumnos matriculados en el curso.
     * 
     * @return el número de alumnos matriculados en el curso.
     */
    public int getNumAlumnosMatriculados() {
        return numAlumnosMatriculados;
    }

    /**
     * Método para establecer el número de alumnos matriculados en el curso.
     * 
     * @param numAlumnosMatriculados el nuevo número de alumnos matriculados en el curso.
     */
    public void setNumAlumnosMatriculados(int numAlumnosMatriculados) {
        this.numAlumnosMatriculados = numAlumnosMatriculados;
    }

  
        /**
     * Método para agregar un estudiante al curso junto con sus notas.
     * 
     * @param estudiante El estudiante a agregar.
     * @param notasEstudiante Las notas del estudiante.
     */
    public void agregarEstudiante(Estudiante estudiante, double[] notasEstudiante) {
        // Insertar el estudiante en la posición adecuada según su identificador
        int i = 0;
        while (i < estudiantes.size() && estudiantes.get(i).getIdentificador().compareTo(estudiante.getIdentificador()) < 0) {
            i++;
        }
        estudiantes.add(i, estudiante);
    }

    /**
     * Método para obtener los identificadores de los estudiantes matriculados en el curso.
     * 
     * @return Un arreglo de cadenas con los identificadores de los estudiantes.
     */
    public String[] getIdentificadoresEstudiantes() {
        String[] identificadores = new String[numAlumnosMatriculados];
        int i = 0;
        for (Estudiante estudiante : estudiantes) {
            identificadores[i++] = estudiante.getIdentificador();
        }
        return identificadores;
    }

    /**
     * Método para obtener los códigos de las asignaturas del curso.
     * 
     * @return Un arreglo de cadenas con los códigos de las asignaturas del curso.
     */
    public String[] getAsignaturas() {
        String[] codigos = new String[NUM_ASIGNATURAS];
        for (int i = 0; i < NUM_ASIGNATURAS; i++) {
            codigos[i] = asignaturas.get(i).getCodigo();
        }
        return codigos;
    }
      
      
        /**
     * Método para buscar un profesor por su identificador en una lista de profesores.
     * 
     * @param idProfesor El identificador del profesor a buscar.
     * @param profesores La lista de profesores en la que se realizará la búsqueda.
     * @return El profesor encontrado o null si no se encuentra.
     */
    public Profesor buscarProfesorPorId(String idProfesor, List<Profesor> profesores) {
        for (Profesor profesor : profesores) {
            if (profesor.getIdentificadorProfesor().equals(idProfesor)) {
                return profesor;
            }
        }
        return null; 
    }

    /**
     * Método para contar el número de estudiantes que han aprobado todas las asignaturas.
     * 
     * @param notas La matriz de notas de los estudiantes.
     * @return El número de estudiantes que han aprobado todas las asignaturas.
     */
    public int contarAprobados(double[][] notas) {
        int contadorAprobados = 0;
        for (double[] alumnoNotas : notas) {
            if (esAprobado(alumnoNotas)) {
                contadorAprobados++;
            }
        }
        return contadorAprobados;
    }

    /**
     * Método auxiliar para verificar si un estudiante ha aprobado todas las asignaturas.
     * 
     * @param alumnoNotas Las notas del estudiante.
     * @return true si el estudiante ha aprobado todas las asignaturas, false de lo contrario.
     */
    private boolean esAprobado(double[] alumnoNotas) {
        for (double nota : alumnoNotas) {
            if (nota < 5) {
                return false;
            }
        }
        return true;
    }

    /**
     * Método para calcular la nota media de todas las asignaturas.
     * 
     * @param notas La matriz de notas de los estudiantes.
     * @return La nota media de todas las asignaturas.
     */
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

        /**
     * Método para calcular la nota mínima entre todas las asignaturas.
     * 
     * @param notas La matriz de notas de los estudiantes.
     * @return La nota mínima entre todas las asignaturas.
     */
    public double calcularNotaMinima(double[][] notas) {
        double notaMinima = Double.MAX_VALUE;
        for (double[] alumnoNotas : notas) {
            for (double nota : alumnoNotas) {
                notaMinima = Math.min(notaMinima, nota);
            }
        }
        return notaMinima != Double.MAX_VALUE ? notaMinima : 0.0; // Si no hay notas, devolver 0.0
    }

    /**
     * Método para calcular la nota máxima entre todas las asignaturas.
     * 
     * @param notas La matriz de notas de los estudiantes.
     * @return La nota máxima entre todas las asignaturas.
     */
    public double calcularNotaMaxima(double[][] notas) {
        double notaMaxima = Double.MIN_VALUE;
        for (double[] alumnoNotas : notas) {
            for (double nota : alumnoNotas) {
                notaMaxima = Math.max(notaMaxima, nota);
            }
        }
        return notaMaxima != Double.MIN_VALUE ? notaMaxima : 0.0; // Si no hay notas, devolver 0.0
    }

    /**
     * Método para buscar un estudiante por su identificador en una lista de estudiantes.
     * 
     * @param identificador El identificador del estudiante a buscar.
     * @param estudiantes La lista de estudiantes en la que se realizará la búsqueda.
     * @return El estudiante encontrado o null si no se encuentra.
     */
    public Estudiante buscarEstudiantesPorId(String identificador, List<Estudiante> estudiantes) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getIdentificador().equals(identificador)) {
                return estudiante;
            }
        }
        return null; 
    }

    /**
     * Método para obtener un estudiante por su índice en una lista de estudiantes.
     * 
     * @param indice El índice del estudiante en la lista.
     * @param estudiantes La lista de estudiantes.
     * @return El estudiante correspondiente al índice especificado o null si el índice está fuera de rango.
     */
    public Estudiante buscarEstudiantesPorIndice(int indice, List<Estudiante> estudiantes) {
        if (indice >= 0 && indice < estudiantes.size()) {
            return estudiantes.get(indice);
        }
        return null;
    }

    /**
     * Método para calcular las medias por asignatura de todas las asignaturas.
     * 
     * @param notas La matriz de notas de los estudiantes.
     * @return Un arreglo con las medias por asignatura.
     */
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

    /**
     * Método para calcular la nota media del curso.
     * 
     * @param notas La matriz de notas de los estudiantes.
     * @return La nota media del curso.
     */
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

    /**
     * Método para buscar un estudiante por su identificador.
     * 
     * @param identificador El identificador del estudiante a buscar.
     * @return El estudiante encontrado o null si no se encuentra.
     */
    public Estudiante buscarEstudiantesPorIdentificador(String identificador) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getIdentificador().equalsIgnoreCase(identificador)) {
                return estudiante;
            }
        }
        return null;
    }

    /**
     * Método para eliminar un estudiante por su identificador.
     * 
     * @param identificador El identificador del estudiante a eliminar.
     * @return true si se elimina el estudiante correctamente, false si el estudiante no existe en la lista.
     */
    public boolean eliminarEstudiante(String identificador) {
        // Buscar el estudiante por su identificador
        Estudiante estudiante = buscarEstudiantesPorIdentificador(identificador);

        // Si se encuentra al estudiante, eliminarlo de la lista de estudiantes
        if (estudiante != null) {
            return estudiantes.remove(estudiante);
        } else {
            return false;
        }
    }
    
}
