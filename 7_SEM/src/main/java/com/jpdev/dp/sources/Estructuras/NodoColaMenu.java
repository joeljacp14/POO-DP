package com.jpdev.dp.sources.Estructuras;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Peter Days
 */

import java.util.Scanner;
public class NodoColaMenu {
    
    public static void menu(){
            System.out.println("1. Altas");    
            System.out.println("2. Bajas");    
            System.out.println("3. Top");    
            System.out.println("4. Imprime");    
            System.out.println("0. Salir");   
            System.out.print("Opcion : ");
    }
    
    public static void main(String[] args) {
        // OJO: Validar la condicion de NullPointerException
        Scanner lee = new Scanner(System.in);
        int opcion = 9, dato;
        NodoCola frente = null, atras=null;
        while(opcion!=0){
            menu();
            opcion = lee.nextInt();
            try{
            switch (opcion){
                case 1: System.out.print("Numero Alta: ");
                        dato = lee.nextInt();
                        if (atras == null){
                            frente = atras = new NodoCola(dato);
                        }
                        else             atras = atras.guarda(dato);
                        break;
                case 2: frente = frente.baja(); break;
                case 3: System.out.println("El frente de la cola es: "+frente.top()); break;
                case 4: frente.imprime(); System.out.println(); break;
                case 0: System.out.println("Hasta la vista Baby");return;
            }
            }catch (NullPointerException e){ 
                System.out.println("Cola vacia ");
                frente = null; atras=null;
             }
        }
    }
    
}
