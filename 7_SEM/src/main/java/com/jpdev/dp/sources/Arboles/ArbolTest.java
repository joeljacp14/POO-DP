package com.jpdev.dp.sources.Arboles;/*
Manejo general de Colas en Java
 * @author Peter Days
 */

import java.util.Scanner;

public class ArbolTest {
    
    public static void menu(){
        System.out.println("1.- Alta");
        System.out.println("2.- Baja");
        System.out.println("3.- Top");
        System.out.println("4.- Recorrido PRE-orden");
        System.out.println("5.- Recorrido IN-orden");
        System.out.println("6.- Recorrido POST-orden");
        System.out.println("0.- Salir");
        System.out.print("Teclea Opciòn --> ");
    }
    
    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);
        int opcion = 9, valor = 0;
        Arbol root=null;
        while (opcion!=0){ 
          menu();
          opcion = lee.nextInt();
          switch (opcion){
              case 1: System.out.print("Teclea el valor a ingresar: ");
                      valor = lee.nextInt();
                      if (root==null) root = new Arbol(valor);
                      else root.add(valor);
                      System.out.println("root "+root);
                      break;
              /*case 2: try { frente = frente.saca();}catch(NullPointerException e){
                          System.out.println("Cola vacia");
                          frente = null; atras = null;
                      }
                      break;
              case 3: try { System.out.println("El frente --> "+frente.top());}catch(NullPointerException e){
                          System.out.println("Cola vacia");
                          frente = null; atras = null;
                      }
                      break; */      
              case 4: try { root.preOrden();}catch(NullPointerException e){
                          System.out.println("Arbol vacio");
                          root = null;
                      }
                      break;  
              case 5: try { root.inOrden();}catch(NullPointerException e){
                          System.out.println("Arbol vacio");
                          root = null;
                      }
                      break;  
              case 6: try { root.postOrden();}catch(NullPointerException e){
                          System.out.println("Arbol vacio");
                          root = null;
                      }
                      break;  
              case 0: System.out.println("Eso es todo amigos");        
                      return;
          }        
        }
    }
}
// 10 5 3 20 