package com.jpdev.poo.practica3;
/*
Vamos a crear un arreglo de 5 elementos (7  8 9  10  6)

Vamos a leer del teclado la posición del numerador y denominador dentro del
arreglo para realizar la división.

Si lea num = 1   y den = 4   divide 8 / 6  1.22
 *
 * @author Pedro Diaz
 * Edited by: Joel Jacome Pioquinto
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class SegundaExepcion {
    
    public static void main(String[] args) {
         Scanner lee = new Scanner(System.in);
         double arr[] = {0,8,9,10,6};
         int num=10, div=0;
         double resul=0;
         while(true){
           try{
               System.out.print("Teclea la posicion del numerador: ");
               num = lee.nextInt();
               System.out.print("Teclea la posicion del divisor: ");
               div = lee.nextInt();
               resul = arr[num]/arr[div];
           }catch(ArithmeticException e){
               System.out.println("Error.Division entre cero. Checa el divisor");
               //resul = 0;
           }catch(ArrayIndexOutOfBoundsException e){
             System.out.println("Error. El indice esta fuera del rango");
             continue;
           }catch (InputMismatchException e){
               System.out.println("Error: El valor de un indice es incorrecto");
           }
           break;
         }   
         System.out.println("El resultado es: "+resul);
    }     
}
