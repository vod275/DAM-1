package Principal;

import Persona.Asignaturas;
import Persona.Estudiante;
import Persona.Profesor;
import Validaciones.Validaciones;
import static Validaciones.Validaciones.obtenerFecha;
import java.time.LocalDate;
import java.util.Scanner;

public class MenuPrincipal {
    private static Curso curso;
    private static Profesor profesor;
    private static Estudiante estudiante;

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
                    actualizarNota(scanner);
                    break;
                case 5:
                    informeAsignatura(scanner);
                    break;
                case 6:
                    informeEstudiante(scanner);
                    break;
                case 7:
                    informeGeneral();
                    break;
                case 8:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("=== Menú Principal ===");
        System.out.println("1. Crear curso");
        System.out.println("2. Nuevo profesor");
        System.out.println("3. Nuevo estudiante");
        System.out.println("4. Actualizar nota");
        System.out.println("5. Informe de asignatura");
        System.out.println("6. Informe de estudiante");
        System.out.println("7. Informe general");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
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
        String identificador = scanner.nextLine().trim();
        while (true) {
            if (identificador.equalsIgnoreCase("x")) {
                System.out.println("Operación cancelada.");
                return;
            }
            if (!Validaciones.validarIdentificadorProfesor(identificador)) {
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

        profesor = new Profesor(dni, nombreCompleto, correoElectronico, identificador, fechaAlta, asignaturaImparte);
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
            System.out.println("Ingrese el identificador del estudiante:");
            String identificador = scanner.nextLine().trim();

        
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
        
        estudiante = new Estudiante(dni, nombreCompleto, correoElectronico, identificador, fechaMatriculacion);
        System.out.println("¡Estudiante creado exitosamente!");
        
        

        // Implementar lógica para añadir un nuevo estudiante al curso
    }

    private static void actualizarNota(Scanner scanner) {
        // Implementar lógica para actualizar la nota de un estudiante en una asignatura
    }

    private static void informeAsignatura(Scanner scanner) {
        // Implementar lógica para generar informe de una asignatura
    }

    private static void informeEstudiante(Scanner scanner) {
        // Implementar lógica para generar informe de un estudiante
    }

    private static void informeGeneral() {
        // Implementar lógica para generar informe general del curso
    }

    

}


