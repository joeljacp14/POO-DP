package com.jpdev.poo.programa3;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

import java.util.Scanner;

public class Joel3Test {
    public static void main(String[] args) {
        String city;
        Scanner sc = new Scanner(System.in);
        Joel3 clientes = new Joel3();
        clientes.deuda();
        System.out.print("Ingresa una ciudad que quieras mostrar: ");
        city = sc.nextLine();
        clientes.deudoresCiudad(city);
        clientes.cambiaTipo();
    }
}
