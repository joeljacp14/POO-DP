/*
Obtener el factorial de un numero
Num = 5
fac = 5*4*3*2*1=120

Recursividad: Cuando un metodo se llama a si mismo.
Problema: Si se tiene un mal manejo(condición final del metodo) se cicla y puede
afectar el manejo de la memoria.

Utilizar: 
Para repetir la misma funcion n veces
Para suplir un bucle

/**
 *
 * @author Pedro Diaz
 */
package com.jpdev.dp.sources.Recursividad;

public class FactorialTotal {
    
     public int factorial(int xnum){
         int resul = 1;
         for(int con=xnum; con>1 ; resul = resul * con--);
         return resul;
     }
     
     public int factorialRecursivo(int xnum){
         if (xnum<=1) return 1;
         return xnum * factorialRecursivo(xnum-1);
     }
    
     public static void main(String[] args) {
       FactorialTotal xx= new FactorialTotal();
       System.out.println("El factorial FOR es: "+xx.factorial(5));
       System.out.println("El factorial REC es: "+xx.factorialRecursivo(5));
     } 
}
