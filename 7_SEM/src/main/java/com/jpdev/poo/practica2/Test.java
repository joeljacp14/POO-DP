//@author Joel Jacome - S18001428

package com.jpdev.poo.practica2;

public class Test {
    public static void main(String[] args) {
        Calificaciones cal = new Calificaciones();

        cal.imprime();
        System.out.println("La calificacion mayor es: "+cal.getMayor());
        System.out.println("La cantidad de reprobados es: "+cal.getReprobados());
        System.out.println("El prmedio del grupo es: "+cal.promedio());
    }
}
