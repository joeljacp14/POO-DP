package com.jpdev.poo.tarea6;

import java.util.Scanner;

public class Joel6Test {
    public static void main(String[] args) {
        int dato;
        Scanner sc = new Scanner(System.in);
        Joel6 nombres = new Joel6();
        nombres.quickSort(0, nombres.array.length - 1);
        System.out.print("Ingresa un dato a buscar: ");
        dato = sc.nextInt();
        nombres.busquedaBinaria(dato);
        nombres.imprime();
    }
}
