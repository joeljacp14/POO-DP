package com.jpdev.poo.exa1part1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

class Exac00 {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int arr[] = {6,8,0,5,2};
        String a1;
        int resul=0;
 
        FileInputStream entrada = null; // Esta linea esta bien no lleva modificacion
        try {
            entrada = new FileInputStream( "fich1.txt" ); // Esta linea esta bien no lleva modificacion
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
            //e.printStackTrace();
        }

        while (true){
            try {
                System.out.print("Inserta numero: ");
                a1= sc.next();

                resul = arr[Integer.parseInt(a1)];
                System.out.println("El dato dentro del arreglo es: "+resul);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Indice fuera del arreglo");
                System.out.println("La pocision 0 del arreglo es: "+arr[0]);
                continue;
            }catch (InputMismatchException e){
                System.out.println("Dato erroneo");
                continue;
            }catch (NumberFormatException e){
                System.out.println("Dato erroneo");
                continue;
            }
            break;
        }
      }
}
     


