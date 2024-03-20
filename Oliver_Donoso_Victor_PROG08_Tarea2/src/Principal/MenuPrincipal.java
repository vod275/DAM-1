package Principal;

import Persona.Asignaturas;
import Persona.Estudiante;
import Persona.Profesor;
import static Principal.Curso.NUM_ASIGNATURAS;
import Validaciones.Validaciones;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private static Curso curso;
     static List<Profesor> listaProfesores = new ArrayList<>();
     static List<Estudiante> listaEstudiantes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    crearCurso(scanner);
                    break;
                case 2:
                    nuevoProfesor(scanner);
                    break;
                case 3:
                    nuevoEstudiante(scanner);
                    break;
                    
                case 4:
                    eliminarEstudiante(scanner);
                    break;
                case 5:
                    actualizarNota(scanner);
                    break;
                case 6:
                    informeAsignatura(scanner);
                    break;
                case 7:
                    informeEstudiante(scanner);
                    break;
                case 8:
                    informeGeneral();
                    break;
                case 9:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("=== Menu Principal ===");
        System.out.println("1. Crear curso");
        System.out.println("2. Nuevo profesor");
        System.out.println("3. Nuevo estudiante");
        System.out.println("4. Eliminar estudiante");
        System.out.println("5. Actualizar nota");
        System.out.println("6. Informe de asignatura");
        System.out.println("7. Informe de estudiante");
        System.out.println("8. Informe general");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static void crearCurso(Scanner scanner) {
        System.out.println("Ingrese la fecha de inicio del curso (formato dd-mm-aaaa):");
        LocalDate fechaInicial = obtenerFecha(scanner);

        System.out.println("Ingrese la fecha de fin del curso (formato dd-mm-aaaa):");
        LocalDate fechaFinal = obtenerFecha(scanner);

        // Validar que la fecha de inicio sea anterior a la fecha de fin
        if (fechaInicial.isAfter(fechaFinal)) {
            System.out.println("Error: La fecha de inicio debe ser anterior a la fecha de fin del curso.");
        } else {
            // Crear el curso y almacenarlo en la variable curso
              curso = new Curso("DAM 1 E-Learning", fechaInicial, fechaFinal, null, 0);
            System.out.println("¡Curso creado exitosamente!");
        }
    }

    private static void nuevoProfesor(Scanner scanner) {
        //Validar DNI/NIE
        System.out.println("Ingrese su DNI/NIE: ");
        String dni = scanner.nextLine().trim();

        while (true) {
            if (dni.equalsIgnoreCase("x")) {
                System.out.println("Operación cancelada.");
                return;
            }
            if (!Validaciones.validaDNI(dni)) {
                System.out.println("DNI. Ingrese nuevamente (o 'x' para cancelar):");
                continue;
            }
            break;
        }

        // Validar el identificador
        System.out.println("Ingrese el identificador del profesor:");
        String identificadorProfesor = scanner.nextLine().trim();
        while (true) {
            if (identificadorProfesor.equalsIgnoreCase("x")) {
                System.out.println("Operación cancelada.");
                return;
            }
            if (!Validaciones.validarIdentificadorProfesor(identificadorProfesor)) {
                System.out.println("Identificador incorrecto. Ingrese nuevamente (o 'x' para cancelar):");
            }
            break; // Agrega el break aquí
        }

        // Validar el nombre
        System.out.println("Ingrese el nombre del profesor: ");
        String nombreCompleto = scanner.nextLine().trim();
        while (true) {    
            if (nombreCompleto.equalsIgnoreCase("x")) {
                System.out.println("Operación cancelada.");
                return;
            }
            if (nombreCompleto.isEmpty() || nombreCompleto.length() > 40) {
                System.out.println("Nombre incorrecto. Debe tener entre 1 y 40 caracteres."); 
                continue; 
            }       
            break; 
        }

        // Validar fechaAlta
        System.out.println("Ingrese la fecha de alta del profesor (formato dd-MM-yyyy):");
        LocalDate fechaAlta = obtenerFecha(scanner);
        while (true) {
            if (fechaAlta.equals("x")) {
                System.out.println("Operación cancelada.");
                return;
            }
            if (!Validaciones.validarFechaDeAlta(fechaAlta, curso.getFechaInicial())) {
                System.out.println("Fecha de alta incorrecta. Ingrese nuevamente (o 'x' para cancelar):");
                continue;
            }
            break;
        }

        // Validar correo 
        System.out.println("Ingrese correo electrónico: ");
        String correoElectronico = scanner.nextLine().trim();
        while (true) {
            if (correoElectronico.equalsIgnoreCase("x")) {
                System.out.println("Operación cancelada.");
                return;
            }
            if (!Validaciones.validarMail(correoElectronico)) {
                System.out.println("Correo electrónico incorrecto. Ingrese nuevamente (o 'x' para cancelar):");
                continue;
            }
            break;
        }

        // Validando Asignatura
        System.out.println("Asignatura que impartirá el profesor (BD, ED, FOL, ING, LMSGI, PROG, SI): ");
        String asignaturaString = scanner.nextLine().trim();
        Asignaturas asignaturaImparte = Asignaturas.fromString(asignaturaString);

        while (true) {
            if (asignaturaString.equalsIgnoreCase("x")) {
                System.out.println("Operación cancelada.");
                break; // Cancelar la operación si se ingresa 'x'
            }
            if (!Validaciones.validarAsignatura(asignaturaImparte)) {
                System.out.println("Asignatura incorrecta. Ingrese nuevamente (o 'x' para cancelar):");
                continue;
            }
            break;
        } 

        Profesor profesor = new Profesor(dni, nombreCompleto, correoElectronico, identificadorProfesor, fechaAlta, asignaturaImparte);
        listaProfesores.add(profesor);
        System.out.println("¡Profesor creado exitosamente!");
    }


    private static void nuevoEstudiante(Scanner scanner) {
       
        System.out.println("Ingrese su DNI/NIE: ");
        String dni = scanner.nextLine().trim();
        while (true) {
            

            if (dni.equalsIgnoreCase("x")) {
                System.out.println("Operación cancelada.");
                return;
            }

            if (!Validaciones.validaDNI(dni)) {
                System.out.println("DNI. Ingrese nuevamente (o 'x' para cancelar):");
                continue;
            }
       
          break;
        }


           // Validar el identificador
    String identificador;
    while (true) {
        System.out.println("Ingrese el identificador del estudiante:");
        identificador = scanner.nextLine().trim();

        if (identificador.equalsIgnoreCase("x")) {
            System.out.println("Operación cancelada.");
            return;
        }

        if (!Validaciones.validarIdentificadorAlumno(identificador)) {
            System.out.println("Identificador incorrecto. Ingrese nuevamente (o 'x' para cancelar):");
            continue;
        }

        // Verificar si el identificador ya está en uso por otro estudiante
        if (curso.buscarEstudiantesPorIdentificador(identificador) != null) {
            System.out.println("El identificador ingresado ya pertenece a otro estudiante. Inténtelo de nuevo.");
            continue;
        }

        break;
    }

        
        while (!Validaciones.validarIdentificadorAlumno(identificador)) {
            System.out.println("Identificador incorrecto. Ingrese nuevamente (o 'x' para cancelar):");
            identificador = scanner.nextLine().trim();
            if (identificador.equalsIgnoreCase("x")) {
                System.out.println("Operación cancelada.");
                return;
            }
        }
        
        // Validar correo 
        System.out.println("Ingrese correo electrónico: ");
        String correoElectronico = scanner.nextLine().trim();
        while (true) {
            if (correoElectronico.equalsIgnoreCase("x")) {
                System.out.println("Operación cancelada.");
                return;
            }
            if (!Validaciones.validarMail(correoElectronico)) {
                System.out.println("Correo electrónico incorrecto. Ingrese nuevamente (o 'x' para cancelar):");
                continue;
            }
            break;
        }
        
        
        // Validar el nombre
            System.out.println("Ingrese el nombre del estudiante:");
            String nombreCompleto = scanner.nextLine().trim();
        while(true) {
            if (nombreCompleto.isEmpty() || nombreCompleto.length() > 40) {
                System.out.println("Nombre incorrecto. Debe tener entre 1 y 40 caracteres.");  
            }       
         break;
        }
        
        
        // Validar Fecha de matriculacion
            System.out.println("Ingrese la fecha de matriculacion del estudiante (formato dd-MM-yyyy):");
            LocalDate fechaMatriculacion = obtenerFecha(scanner);
        while (true) {
            

            if (fechaMatriculacion.equals("x")) {
                System.out.println("Operación cancelada.");
                return;
            }

            if (!Validaciones.validarFechaDeMatriculacion(fechaMatriculacion, curso.getFechaInicial(), curso.getFechaFinal())) {
                System.out.println("Fecha de alta incorrecta. Ingrese nuevamente (o 'x' para cancelar):");
                continue;
            }
       
          break;
        }
        
         Estudiante estudiante = new Estudiante(dni, nombreCompleto, correoElectronico, identificador, fechaMatriculacion);
        
        
        
         System.out.println("Ingrese las notas para el estudiante:");
            double[] notas = new double[Curso.NUM_ASIGNATURAS];
            for (int i = 0; i < Curso.NUM_ASIGNATURAS; i++) {
                System.out.print("Nota para la asignatura " + Asignaturas.values()[i] + ": ");
                notas[i] = scanner.nextInt();
                if (notas[i] < 0 || notas[i] > 10) {
                    System.out.println("La nota debe estar en el rango de 0 a 10. Inténtelo de nuevo.");
                    i--; // Repetir la iteración para volver a solicitar la nota
                }
            }
        curso.agregarEstudiante(estudiante, notas);
        
         System.out.println("Estudiante agregado correctamente.");
         System.out.println("Posición del estudiante en la lista: " + curso.getNumAlumnosMatriculados());
       
    }

    
    private static void actualizarNota(Scanner scanner) {
        System.out.println("ID de estudiantes registrados:");
        String[] identificadores = curso.getIdentificadoresEstudiantes();
        for (String id : identificadores) {
          System.out.println(id);
        }
        
        
        // Solicitar el ID del alumno
        System.out.println("Ingrese el ID del alumno:");
        String idAlumno = scanner.nextLine().trim();
        
        // Buscar el alumno con el ID proporcionado
        int indiceAlumno = -1;
        for (int i = 0; i < curso.getNumAlumnosMatriculados(); i++) {
            if  (curso.getIdentificadoresEstudiantes()[i].equals(idAlumno)) {
                indiceAlumno = i;
                break;
            }
        }
        // Verificar si se encontró al alumno
        if (indiceAlumno == -1) {
            System.out.println("El alumno con ID " + idAlumno + " no está registrado en este curso.");
            return;
        }
        
        
       
        

        
        // Mostrar los códigos de las asignaturas registradas para ayudar en la entrada de datos
        System.out.println("Códigos de asignaturas registradas:");
        String[] asignaturasLista = curso.getAsignaturas();
        for (String codigo : asignaturasLista ) {
            System.out.println(codigo);
        }
        
        // Solicitar el código de la asignatura
        System.out.println("Ingrese el código de la asignatura: ");
        String codigoAsignatura = scanner.nextLine().trim();
        
        // Verificar si la asignatura existe
        int indiceAsignatura = -1;
        for (int i = 0; i < NUM_ASIGNATURAS; i++) {
            if (curso.getAsignaturas()[i].equals(codigoAsignatura)) {
                indiceAsignatura = i;
                break;
            }
        }        
        // Verificar si se encontró la asignatura
        if (indiceAsignatura == -1) {
            System.out.println("La asignatura con código " + codigoAsignatura + " no está registrada en este curso.");
            return;
        }
        
 
        
        // Mostrar la nota actual del alumno en esa asignatura
        double notaActual = curso.getNotas()[indiceAlumno][indiceAsignatura];
        System.out.println("La nota actual del alumno con ID: " + idAlumno + " en la asignatura: " +
                           codigoAsignatura + " es: " + notaActual);
        
        // Solicitar la nueva nota
        int nuevaNota;
        do {
            System.out.println("Ingrese la nueva nota para esta asignatura (entre 0 y 10):");
            nuevaNota = Integer.parseInt(scanner.nextLine().trim());
        } while (nuevaNota < 0 || nuevaNota > 10);
        
        // Actualizar la nota correspondiente
        curso.getNotas()[indiceAlumno][indiceAsignatura] = nuevaNota;
        
        System.out.println("La nota del alumno con ID " + idAlumno + " en la asignatura " +
                           codigoAsignatura + " ha sido actualizada correctamente.");
    }


    private static void informeAsignatura(Scanner scanner) {
    // Solicitar por teclado el ID del profesor
    System.out.println("Ingrese el ID del profesor:");
    String idProfesor = scanner.nextLine().trim();

    // Verificar que el ID del profesor está en la lista de profesores
    Profesor profesor = curso.buscarProfesorPorId(idProfesor, listaProfesores);
    if (profesor == null) {
        System.out.println("El ID del profesor no está en la lista.");
        return;
    }

    // Obtener el nombre de la asignatura que imparte el profesor
    Asignaturas nombreAsignatura = profesor.getAsignaturaImparte();

    // Calcular estadísticas de la asignatura
    double[][] notas = curso.getNotas();
    int numAlumnos = curso.getNumAlumnosMatriculados();
    int aprobados = curso.contarAprobados(notas);
    int suspendidos = numAlumnos - aprobados;
    double porcentajeAprobados = (double) aprobados / numAlumnos * 100;
    double porcentajeSuspendidos = 100 - porcentajeAprobados;
    double notaMedia = curso.calcularNotaMedia(notas);
    double notaMinima = curso.calcularNotaMinima(notas);
    double notaMaxima = curso.calcularNotaMaxima(notas);

    // Mostrar estadísticas de la asignatura
    System.out.println("Información de la asignatura:");
    System.out.println("Nombre del profesor: " + profesor.getNombreCompleto());
    System.out.println("ID del profesor: " + profesor.getIdentificadorProfesor());
    System.out.println("Nombre de la asignatura: " + nombreAsignatura);
    System.out.println("Número de alumnos aprobados: " + aprobados);
    System.out.printf("Porcentaje de aprobados: %.2f%%\n", porcentajeAprobados);
    System.out.println("Número de alumnos suspendidos: " + suspendidos);
    System.out.printf("Porcentaje de suspendidos: %.2f%%\n", porcentajeSuspendidos);
    System.out.printf("Nota media de la asignatura: %.2f\n", notaMedia);
    System.out.println("Nota mínima: " + notaMinima);
    System.out.println("Nota máxima: " + notaMaxima);
}


    private static void informeEstudiante(Scanner scanner) {
        
        // Solicitar por teclado el ID del profesor
            System.out.println("Ingrese el ID del estudiante:");
            String idAlumno = scanner.nextLine().trim();
          // Buscar al alumno por su ID
        Estudiante estudiante = curso.buscarEstudiantesPorId(idAlumno, listaEstudiantes);
        if (estudiante == null) {
            System.out.println("El ID del alumno no está en la lista.");
            return;
        }

        // Mostrar datos identificativos del alumno
        System.out.println("Datos identificativos del alumno:");
        System.out.println("DNI: " + estudiante.getDni());
        System.out.println("Nombre completo: " + estudiante.getNombreCompleto());
        System.out.println("Correo electrónico: " + estudiante.getCorreoElectronico());
        System.out.println("Fecha de matriculación: " + estudiante.getFechaMatriculacion());

        // Mostrar relación de notas de todas las asignaturas
        double[][] notas = curso.getNotas();
       System.out.println("Relación de notas de todas las asignaturas:");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Asignatura " + (i+1) + ": ");
            for (int j = 0; j < notas[i].length; j++) {
                System.out.print(notas[i][j] + " ");
            }
            System.out.println();
        }

        // Calcular estadísticas
        double aprobados = curso.contarAprobados(notas);
        double suspendidos = notas.length - aprobados;
        double notaMedia = curso.calcularNotaMedia(notas);
        double porcentajeAprobadas = ((double) aprobados / notas.length) * 100;

        // Mostrar resumen
        System.out.println("Resumen:");
        System.out.println("Número de aprobados: " + aprobados);
        System.out.println("Número de suspensos: " + suspendidos);
        System.out.printf("Nota media: %.2f\n", notaMedia);
        System.out.printf("Porcentaje de asignaturas aprobadas: %.2f%%\n", porcentajeAprobadas);
    }

    
    private static void informeGeneral() {
        
      // Si el curso es null, significa que no se pudo obtener la información, mostrar mensaje y salir
      if (curso == null) {
          System.out.println("No se pudo obtener la información del curso.");
          return;
        }
      
        // Obtener año de inicio y fin del curso
        int yearInicio = curso.getFechaInicial().getYear();
        int yearFin = curso.getFechaFinal().getYear();
        String titulo = String.format("Informe general del curso %d/%d\n", yearInicio, yearFin);
        System.out.println(titulo);

        // Nombre del curso
        System.out.println("Nombre del curso: " + curso.getNombreCurso());

        // Cabeceras de las columnas
        System.out.printf("%-15s %-40s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-15s\n",
                "ID Alumno", "Nombre", "BD", "ED", "FOL", "ING", "LMSGI", "PROG", "SI", "Nota Media");
         
             // Separador
        System.out.println("----------------------------------------------------------------------------------------------------------------------");

        // Recorrer cada estudiante
        for (int i = 0; i < curso.getNumAlumnosMatriculados(); i++) {
            Estudiante estudiante = curso.buscarEstudiantesPorIndice(i, listaEstudiantes);
            double[][] notasEstudiante = curso.getNotas();
            double notaMediaAsignatura = curso.calcularNotaMedia(notasEstudiante);

            // Imprimir información del estudiante y sus notas
            System.out.printf("%-15s %-40s ", estudiante.getIdentificador(), estudiante.getNombreCompleto());
            for (int j = 0; j < notasEstudiante[i].length; j++) {
                double nota = notasEstudiante[i][j];
                System.out.printf("%-10.2f ", nota);
            }
            System.out.printf("%-10.2f\n", notaMediaAsignatura);
        }


        
        
                // Separador
            System.out.println("----------------------------------------------------------------------------------------------------------------------");

            // Totales
            System.out.printf("%-15s %-40s ", "Totales", "");
            double[][] todasLasNotas = curso.getNotas();
            double[] mediasPorAsignatura = curso.calcularMediasPorAsignatura(todasLasNotas);
            double notaMediaCurso = curso.calcularNotaMediaCurso(todasLasNotas);
            for (double media : mediasPorAsignatura) {
                System.out.printf("%-10.2f ", media);
            }
            System.out.printf("%-10.2f\n", notaMediaCurso);
    }
    

    
    
    
   public static LocalDate obtenerFecha(Scanner scanner) {
        LocalDate fecha = null;
        boolean fechaValida = false;
        
        while (!fechaValida) {
            System.out.println("Ingrese la fecha (formato dd-MM-yyyy):");
            String input = scanner.nextLine().trim();

            try {
                // Intentar convertir la cadena ingresada en un objeto LocalDate
                fecha = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                fechaValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Inténtelo de nuevo.");
            }
        }
        
        return fecha;
    }
   
   private static void eliminarEstudiante(Scanner scanner) {
        // Solicitar al usuario el código del estudiante a eliminar
        System.out.println("Ingrese el código del estudiante que desea eliminar:");
        String codigoEstudiante = scanner.nextLine().trim();
        
         if (curso == null) {
            System.out.println("No hay ningún curso asignado actualmente.");
            return;
        }

        // Buscar al estudiante por su código
        Estudiante estudiante = curso.buscarEstudiantesPorIdentificador(codigoEstudiante);
        if (estudiante == null) {
            System.out.println("El estudiante con el código ingresado no está registrado.");
            return;
        }

        // Eliminar al estudiante del curso
        if (curso.eliminarEstudiante(codigoEstudiante)) {
            System.out.println("El estudiante ha sido eliminado correctamente del curso.");
        } else {
            System.out.println("Error al eliminar al estudiante del curso.");
        }

        // Eliminar al estudiante de la lista de estudiantes
        if (listaEstudiantes.remove(estudiante)) {
            System.out.println("El estudiante ha sido eliminado correctamente de la lista de estudiantes.");
        } else {
            System.out.println("Error al eliminar al estudiante de la lista de estudiantes.");
        }
    }
   
   
}


