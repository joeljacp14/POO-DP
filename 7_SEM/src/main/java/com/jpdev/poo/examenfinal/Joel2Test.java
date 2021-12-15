package com.jpdev.poo.examenfinal;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

import java.util.Scanner;

public class Joel2Test {
    public static void main(String[] args) {
        int dato;
        Scanner sc = new Scanner(System.in);
        Joel2 xx = new Joel2();
        xx.quickSort(0, xx.array.length - 1);
        System.out.print("Ingresa un dato a buscar: ");
        dato = sc.nextInt();
        xx.busquedaBinaria(dato);
        xx.imprime();
    }
}
