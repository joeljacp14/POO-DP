/*
Manejo basico de una pila
 *
 * @author Pedro Diaz
 */

// 1.- Importar la utileria de ArrayList
package com.jpdev.poo.sources.Estructuras;

import java.util.ArrayList;

public class Pila1 {
    // 2.- Declarar el arreglo
    ArrayList<String> arr = new ArrayList<String>();
    ArrayList<String> list = new ArrayList<>();
    
    // 3.- Agregar un dato a la pila (add)
    public void push(String dato){
        arr.add(dato);
    }
    
    // 4.- Eliminar el elemento que esta en la cima de la pila (ultimo) (remove)
    public void pop(){
        if (arr.isEmpty()) System.out.println("Pila Vacia");
        else arr.remove(arr.size()-1);
    }
    
    //5.- Mostrar el elemento que esta en el top (get)
    public String top(){
        if (arr.isEmpty()) return "Pila Vacia";
        else               return arr.get(arr.size()-1);        
    }

    public void frente_final(){
        if (arr.isEmpty()){
            System.out.println("Lista vacia");
            return;
        }
        System.out.println("Frente -> "+arr.get(0));
        System.out.println("Final -> "+arr.get(arr.size()-1));
    }
    
    public void imprime(){
        for (int i=arr.size()-1; i>=0; i--){
            if (i==arr.size()-1) System.out.println("Top --> "+arr.get(i));
            else                 System.out.println("        "+arr.get(i));
        }
    }

    public void imprime_lista(){
        for (int i = 0; i < arr.size(); i++){
            if (i == 0)
                System.out.print("Frente -> ");
            if (i == (arr.size()-1))
                System.out.print("Final -> ");
            System.out.println(arr.get(i));
        }
    }
}
