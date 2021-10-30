package com.jpdev.poo.exa1part2;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

import java.util.Scanner;

public class Exab00Test {
    public static void main(String[] args) {
        long rm1, ry1, rm2, ry2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa limite menor rango 1: ");
        rm1 = sc.nextLong();
        System.out.print("Ingresa limite mayor rango 1: ");
        ry1 = sc.nextLong();
        System.out.print("Ingresa limite menor rango 2: ");
        rm2 = sc.nextLong();
        System.out.print("Ingresa limite mayor rango 2: ");
        ry2 = sc.nextLong();

        new Exab00("Rango 1", rm1, ry1);
        new Exab00("Rango 2", rm2, ry2);

        for (int i = 0; i < 10000; i++){
            try {
                Thread.sleep(300);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("Time: "+i*300+" ms");
        }
    }
}
