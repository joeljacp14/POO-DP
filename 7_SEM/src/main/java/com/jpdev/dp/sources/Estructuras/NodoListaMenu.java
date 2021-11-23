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
public class NodoListaMenu {
    
    public static void menu(){
            System.out.println("1. Altas");    
            System.out.println("2. Bajas");    
            System.out.println("3. Busca");    
            System.out.println("4. Imprime");    
            System.out.println("0. Salir");   
            System.out.print("Opcion : ");
    }
    
    public static void main(String[] args) {
        // OJO: Validar la condicion de NullPointerException
        Scanner lee = new Scanner(System.in);
        int opcion = 9, dato;
        NodoLista inicio=null;
        while(opcion!=0){
            menu();
            opcion = lee.nextInt();
            try{
            switch (opcion){
                case 1: System.out.print("Numero Alta: ");
                        dato = lee.nextInt();
                        if (inicio == null){
                            inicio = new NodoLista(dato);
                        }
                        else    if (dato<inicio.dato ) inicio = inicio.guarda(dato);
                                else inicio.guarda(dato);

                        break;
                case 2: System.out.print("Numero Baja : ");
                        dato = lee.nextInt();
                        if (inicio.dato==dato) inicio = inicio.next;
                        else inicio.baja(dato);
                        break;
                case 3: System.out.print("Numero Busca: ");
                        dato = lee.nextInt();
                        inicio.busca(dato); 
                        break;
                case 4: inicio.imprime(); System.out.println(); break;
                case 0: System.out.println("Hasta la vista Baby");return;
            }
            }catch (NullPointerException e){ 
                System.out.println("Lista vacia menu:  ");
                inicio = null;
             }
        }
    }
    
}
