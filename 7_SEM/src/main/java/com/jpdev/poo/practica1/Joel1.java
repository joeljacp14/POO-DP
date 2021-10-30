/*
Cree una clase Pedro1.java que tenga 3 atributos enteros con valores por default. 

1.	       Crear un método que regrese el número mayor 
2.	       Crear un método que pases como parámetro un número y regrese si es par o impar. 
3.	       Crear un método que imprima los 3 atributo ordenados (mayor a menor) 

Crear la clase Pedro1Test.java que instancie un objeto de la clase Pedro1.java, lea del teclado los 3 atributos
y los envíe por el método constructor. 
Mande llamar los métodos anteriores.  
Para el método 2(par o impar), lee por teclado el parámetro que le enviaras al método. 
 
Ejemplo: 
Si se leen: 3 1 2 
Mayor = 3 
ParImpar(11):   es Impar 
Orden: 3 2 1 

 */
package com.jpdev.poo.practica1;
import java.util.Scanner;

/**
 *
 * @author joel jacome
 */
public class Joel1 {
    int n1, n2, n3;
    
    public Joel1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero 1: ");
        n1 = sc.nextInt();
        System.out.print("Numero 2: ");
        n2 = sc.nextInt();
        System.out.print("Numero 3: ");
        n3 = sc.nextInt();
    }
    
    public int metodo1(){//regresa el numero mayor
        if((n1 > n2) && (n1 > n3)){
            return n1;
        }
        if((n2 > n1) && (n2 > n3)){
            return n2;
        }
        return n3;
    }
    
    public void metodo2(int n){//numero par o inpar
        System.out.print(n);
        if((n%2) == 0){
            System.out.print(" es par\n");
        }else{
            System.out.print(" es inpar\n");
        }
    }
    
    public void metodo3(){//ordena de mayor a menor
        if(n1 > n2){
            if(n2 > n3){
                System.out.print(n1+", "+n2+", "+n3+"\n");
            }else{
                System.out.print(n1+", "+n3+", "+n2+"\n");
            }
        }else{
            if(n2 > n1){
                if(n1 > n3){
                    System.out.print(n2+", "+n1+", "+n3+"\n");
                }else{
                    System.out.print(n2+", "+n3+", "+n1+"\n");
                }
            }else{
                if(n3 > n1){
                    if(n1 > n2){
                        System.out.print(n3+", "+n1+", "+n2+"\n");
                    }else{
                        System.out.print(n3+", "+n2+", "+n1+"\n");
                    }
                }
            }
        }
    }
}
