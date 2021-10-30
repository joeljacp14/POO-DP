/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpdev.poo.practica1;
import java.util.Scanner;

/**
 *
 * @author joel jacome
 */
public class Joel1Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        Joel1 constr = new Joel1();
        System.out.print("El numero mayor es: "+constr.metodo1()+"\n");
        System.out.print("Ingresa un numero: ");
        n = sc.nextInt();
        constr.metodo2(n);
        constr.metodo3();
    }
    
}
