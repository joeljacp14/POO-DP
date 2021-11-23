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
public class NodoPilaTest {
    
    public static void menu(){
            System.out.println("1. Altas");    
            System.out.println("2. Bajas");    
            System.out.println("3. Top");    
            System.out.println("4. Imprime");    
            System.out.println("0. Salir");    
    }
    
    public static void main(String[] args) {
        // OJO: Validar la condicion de NullPointerException
        NodoPila top = new NodoPila(10);
        try{
           top = top.push(20);
           top = top.push(30);
           top = top.push(40);
           top = top.pop();
           top = top.pop();
           top = top.pop();
           //top = top.pop();
           //top = top.push(100);
           System.out.println("El top de la pila es: "+top.top());
           top.imprime();
        }catch (NullPointerException e){
            System.out.println("Pila vacia "+e);
            top = null;
        }
    }
    
}
