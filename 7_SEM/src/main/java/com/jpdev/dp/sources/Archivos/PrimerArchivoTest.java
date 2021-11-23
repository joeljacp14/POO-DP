package com.jpdev.dp.sources.Archivos;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Díaz
 */

import java.util.Scanner;

public class PrimerArchivoTest {
    
    public static void main(String[] args) {
        PrimerArchivo xx = new PrimerArchivo("Ejemplo.txt");
        Scanner lee = new Scanner(System.in);
        String nombre,matricula,telefono,carrera;
        double calif;
        /*System.out.print("Teclee Matricula: "); matricula = lee.nextLine();
        System.out.print("Teclee Nombre   : "); nombre = lee.nextLine();
        System.out.print("Teclee Telefono : "); telefono = lee.nextLine();
        System.out.print("Teclee Carrera  : "); carrera = lee.nextLine();
        System.out.print("Teclee Promedio : "); calif = lee.nextDouble();
        //xx.grabaArch("s12345678 Lola 1234567890 INF 10.00");
        xx.grabaArch(matricula+"|"+nombre+"|"+telefono+"|"+carrera+"|"+calif);*/
        //xx.leeArch();
        xx.promedio();
        
    }
    
}
