/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones;

import Persona.Asignaturas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 * @author Usuario
 */
public class Validaciones {
    // Método estático para validar DNI/NIE
    public static boolean validaDNI(String dni) {
        // Expresión regular para DNI/NIE
        String dniPattern = "\\b\\d{8}[A-HJ-NP-TV-Z]\\b|\\b[A-HJ-NP-TV-Z]\\d{7}[A-HJ-NP-TV-Z]\\b";

        // Validar el DNI/NIE con la expresión regular
        return dni.matches(dniPattern);
    }

    // Método estático para validar correo electrónico
    public static boolean validarMail(String email) {
        // Expresión regular para validar correo electrónico
        String emailPattern = "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$";

        // Validar el email con la expresión regular
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
   
    
     public static boolean validarFechaDeAlta(LocalDate fechaAltaProfesor, LocalDate fechaInicioCurso) {
        // Verificar que la fecha de alta no sea nula y sea anterior a la fecha de inicio del curso
        if (fechaAltaProfesor != null && fechaAltaProfesor.isBefore(fechaInicioCurso)) {
            return true; // La fecha de alta es válida
        } else {
            return false; // La fecha de alta no es válida
        }
   }
     

    public static boolean validarFechaDeMatriculacion(LocalDate fechaMatriculacion, LocalDate fechaInicioCurso, LocalDate fechaFinCurso) {
        // Verificar si la fecha de matriculación está dentro del rango del curso
        if (fechaMatriculacion.isBefore(fechaInicioCurso) || fechaMatriculacion.isAfter(fechaFinCurso)) {
            System.out.println("La fecha de matriculación debe estar dentro del rango del curso.");
            return false;
        }
        return true;
    }


     
    
    public static boolean validarIdentificadorProfesor(String identificador) {
        // Comprobar si el identificador tiene el formato adecuado
        if (!identificador.matches("(590|591|592)\\d{5}(INF|ING|FOL|SIA)")) {
            return false;
        }
        return true;
    }
    
    public static boolean validarIdentificadorAlumno(String identificador) {
    // Comprobar si el identificador tiene el formato adecuado
    if (!identificador.matches("NIES\\d{6}[ABCRGUTOESX]{2}")) {
        return false;
    }
    return true;
}
    
    
    public static boolean validarAsignatura(Asignaturas asignatura) {
        String codigoAsignatura = asignatura.getCodigo();

        return Arrays.stream(Asignaturas.values())
                .anyMatch(asig -> asig.getCodigo().equalsIgnoreCase(codigoAsignatura));
    }
    
     public static LocalDate obtenerFecha(Scanner scanner) {
        while (true) {
            System.out.println("Ingrese la fecha (formato dd-MM-yyyy):");
            String fechaStr = scanner.nextLine().trim();

            if (fechaStr.equalsIgnoreCase("x")) {
                System.out.println("Operación cancelada.");
                return null;
            }

            try {
                return LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Introduce la fecha en formato dd-MM-yyyy.");
            }
        }
    }
    
}
