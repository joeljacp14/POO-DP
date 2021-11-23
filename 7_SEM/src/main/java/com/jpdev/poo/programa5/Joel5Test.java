package com.jpdev.poo.programa5;

import java.util.Scanner;

/**
 * @author Joel Jacome Pioquinto  S18001428
 * */

public class Joel5Test {
    public static void instrucciones(){
        System.out.println("ARRAYLIST DE CALIFICACIONES");
        System.out.println("Elija una opcion");
        System.out.println("1)  Agregar");
        System.out.println("2)  Eliminar");
        System.out.println("3)  Cantidad de elementos");
        System.out.println("4)  Primer y ultimo elemento");
        System.out.println("5)  Imprimir lista");
        System.out.println("6)  Salir");
        System.out.print("-> ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cal;
        int op = 0;
        float aux;
        Joel5 calificaciones = new Joel5();

        while (op != 6){
            instrucciones();
            op = sc.nextInt();

            switch (op){
                case 1:{
                    System.out.println("Ingresa valor: ");
                    aux = sc.nextFloat();
                    cal = String.valueOf(aux);
                    calificaciones.agregar(cal);
                    break;
                }

                case 2:{
                    System.out.println("Ingresa valor: ");
                    aux = sc.nextFloat();
                    cal = String.valueOf(aux);
                    calificaciones.eliminar(cal);
                    break;
                }

                case 3:{
                    System.out.println("La lista contiene "+calificaciones.cuenta()+" elementos");
                    break;
                }

                case 4:{
                    calificaciones.firstLast();
                    break;
                }

                case 5:{
                    System.out.println("======Contenido de la lista======");
                    calificaciones.imprime();
                    System.out.println("=================================");
                    break;
                }

                case 6:{
                    System.out.println("Saliendo...");
                    break;
                }

                default:{
                    System.out.println("La opcion ingresada es incorrecta\nIntente nuevamente");
                    break;
                }
            }
        }
    }
}
