package com.jpdev.poo.practica4;

/*
 * @author: Joel Jacome Pioquinto - S18001428
 * */

/*
* Instrucciones
Imprimir el nombre de los alumnos que estudien informática.
Un método que indique el nombre(s) del(os) alumno(s) con mayor promedio
Un método que me obtenga el promedio de los alumnos de la carrera que le pases como parámetro
Un método que indique cuantos alumnos han reprobado (Calif <6)
* */

import java.util.Scanner;

public class JoelAlumnosTest {
    public static void main(String[] args) {
        JoelAlumnos arch = new JoelAlumnos("Alumnos.txt");
        Scanner scan = new Scanner(System.in);
        String matricula, nombre, telefono, carrera;
        double calificacion;
        boolean opcion;

        System.out.print("¿Deseas ingresar alumno? escribe 'true' o 'false': ");
        opcion = scan.nextBoolean();

        while (opcion == true){
            System.out.print("Ingresa matricula: ");
            matricula = scan.nextLine();
            System.out.print("Ingresa nombre: ");
            nombre = scan.nextLine();
            System.out.print("Ingresa telefono: ");
            telefono = scan.nextLine();
            System.out.print("Ingresa carrera: ");
            carrera = scan.nextLine();
            System.out.print("Ingresa calificacion: ");
            calificacion = scan.nextDouble();
            arch.grabaArch(matricula+"|"+nombre+"|"+telefono+"|"+carrera+"|"+calificacion);
            System.out.print("¿Deseas ingresar otro? escribe 'true' o 'false': ");
            opcion = scan.nextBoolean();
        }

        //los parametros pueden ser cambiados por el desarrollador :)
        arch.leeTodo();
        arch.leeCarrera("INF");
        arch.leePromedioAlto();
        arch.promedioCarrera("INF");
        arch.leeReprobados();

    }
}
