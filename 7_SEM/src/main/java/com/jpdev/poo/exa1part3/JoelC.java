package com.jpdev.poo.exa1part3;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 * @modify by Joel Jacome Pioquinto
 */
import java.util.Scanner;

interface Interfase {
    String nombre = "Productos Jarochos S.A. de C.V.";
    String BIENVENIDA = "Bienvenido";
    double DESC = 10.00;
    
    void total(double xprecio);
}

class Exaa2020 implements Interfase {
    private double IVA = 0.16;
    private double descuento = DESC;
     
    public void saludo(){
        System.out.println(BIENVENIDA);
    }

    @Override
    public void total(double xprecio) {
        xprecio += (xprecio * IVA);
        System.out.println("Precio : "+xprecio);
        System.out.println("El precio total es: "+(xprecio-xprecio*(DESC/100)));
    }
    
    public static void main(String[] args) {
        Exaa2020 xx = new Exaa2020();
        Scanner lee = new Scanner(System.in);
        System.out.print("Teclee el costo del articulo: ");
        double costo = lee.nextDouble();
        xx.saludo();
        xx.total(costo);
    }

}

