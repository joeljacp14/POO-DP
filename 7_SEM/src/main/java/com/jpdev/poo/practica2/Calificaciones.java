/*
*Instrucciones
Manejar un arreglo de 10 posiciones de tipo entero
Llenar el arreglo en el método constructor con números random entre 0 y 10
Un método que imprima el arreglo
Un método que regrese la calificación mayor
Un método que me indique cuantos reprobaron (calif < 6)
* */

//@author Joel Jacome - S18001428

package com.jpdev.poo.practica2;

public class Calificaciones {
    int[] registro;// = {5, 7, 5,4,2,5,78,8,9};

    public Calificaciones() {
        for (int i = 0; i < registro.length; i++){
            registro[i] = (int) (Math.random() * 10);
        }
        System.out.println("Las calificaciones han sido capturadas correctamente");
    }

    public void imprime() {
        System.out.println("Registro de calificaciones");
        for (int i = 0; i < registro.length; i++){
            System.out.println("Alumno "+(i+1)+": "+registro[i]);
        }
    }

    public int getMayor() {
        int mayor = 0;
        for (int i = 0; i < registro.length; i++){
            if (registro[i] > mayor){
                mayor = registro[i];
            }else {
                continue;
            }
        }
        return mayor;
    }

    public int getReprobados() {
        int cont = 0;
        for (int i = 0; i < registro.length; i++){
            if (registro[i] < 6){
                cont++;
            }else {
                continue;
            }
        }
        return cont;
    }

    public double promedio() {
        int suma = 0;
        double prom;
        for (int i = 0; i < registro.length; i++) {
            suma += registro[i];
        }
        prom = suma / registro.length;
        return  prom;
    }
}
