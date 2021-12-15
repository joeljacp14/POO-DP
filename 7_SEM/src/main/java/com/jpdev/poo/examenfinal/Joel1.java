package com.jpdev.poo.examenfinal;

/**
 *
 * @author Pedro Diaz
 * modificado por Joel Jacome Pioquinto - S18001428
 */

import java.util.ArrayList;

class Exaa21 {
    ArrayList<String> pila = new ArrayList<>();
    
    public void mete(String dato){ pila.add(dato); }
    
    public void imprime(){
        for(int i = 0; i < pila.size(); i++){
            System.out.println(pila.get(i));
        }
    }
    
    public String vacia(){
        if (pila.isEmpty())
            return("Pila Vacia");
        else
            return "Pila NO Vacía";
    }
    
    public void saca(){
        if (pila.isEmpty())
            System.out.println("Pila Vacia");
        else
            pila.remove(pila.size()-1);
        
    }
    
    public static void main(String[] args) {
        Exaa21 pila = new Exaa21();
        pila.mete("Lola");
        pila.mete("Ana");
        System.out.println(pila.vacia());
        pila.saca();
        pila.imprime();
        pila.saca();
        pila.saca();
    }
}
