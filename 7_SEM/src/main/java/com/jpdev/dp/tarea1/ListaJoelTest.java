package com.jpdev.dp.tarea1;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaJoelTest {

    public static void intrucciones(){
        System.out.println("=== MANEJO DE LISTAS ===");
        System.out.println("1)  Ingresar dato");
        System.out.println("2)  Eliminar dato");
        System.out.println("3)  Imprimir la lista");
        System.out.println("4)  Buscar dato");
        System.out.println("5)  Salir del programa");
        System.out.print("-> ");
    }

    public static void main(String[] args) {
        ListaJoel lista = new ListaJoel(0);
        int op = 0, dato;
        Scanner scan = new Scanner(System.in);
        ListaJoel frente = null;

        while (op != 5){
            intrucciones();
            try {
                op = scan.nextInt();
                switch (op){
                    case 1:
                        System.out.print("Ingresa el valor: ");
                        dato = scan.nextInt();
                        if (frente == null){
                            frente = new ListaJoel(dato);
                        }else {
                            frente = frente.alta(dato, frente);
                        }
                        break;

                    case 2:
                        System.out.print("Valor del dato que deseas eliminar: ");
                        dato = scan.nextInt();
                        frente = frente.baja(dato, frente);
                        break;

                    case 3:
                        System.out.println("=============================");
                        System.out.println("CONTENIDO DE LA LISTA");
                        frente.imprime();
                        System.out.println("=============================");
                        break;

                    case 4:
                        System.out.print("Valor a buscar: ");
                        dato = scan.nextInt();
                        frente.busca(dato, 1);
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("La opcion ingresada no existe");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("ERROR: "+e);
            }catch (NullPointerException e){
                System.out.println("ERROR: "+e);
            }
        }

    }

}
