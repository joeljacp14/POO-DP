/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpdev.dp.sources.Recursividad;
/**
 *
 * @author ADMIN
 */
public class Recursividad1 {

    public void imprimir(int x) {
        for(int con = 1; con<=x; con++) System.out.println(con);            
    }    
    
    public void imprimirRec(int x){
        if (x>0){
          imprimirRec(x-1);   //Siempre el metodo recursivo debe estar dentro de una condiciòn
          System.out.println(x);
        }
    }
    
    public static void main(String[] ar) {
        Recursividad1 xx=new Recursividad1();
        xx.imprimirRec(5);
    }
}
