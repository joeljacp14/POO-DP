package com.jpdev.dp.sources.Arboles;/*
Creacion y manejo de un arbol

Cuantos nodos tiene el arbol

Cual es el dato mayor
 */

/**
 *
 * @author Pedro Diaz
 */
public class Arbol {
    private int dato;
    private Arbol izq, der;
    
    public Arbol(int xvalor){
        this.dato = xvalor;
        this.izq = null;
        this.der = null;
    }
    
    public void preOrden(){
        System.out.print(" "+dato);
        if (izq != null) izq.preOrden();
        if (der != null) der.preOrden();
    }

    public void inOrden(){
        if (izq != null) izq.inOrden();
        System.out.print(" "+dato);
        if (der != null) der.inOrden();
    }

    public void postOrden(){
        if (izq != null) izq.postOrden();
        if (der != null) der.postOrden();
        System.out.print(" "+dato);
    }
    
    public void add(int xvalor){
        // Si el valor es menor al nodo darlo de alta a la izquierda
        // Si el valor es mayor al nodo darlo de alta a la derecha
        if (xvalor < this.dato){
            if (izq==null) izq = new Arbol(xvalor);
            else           izq.add(xvalor);
        }
        else{
            if (der==null) der = new Arbol(xvalor);
            else           der.add(xvalor);        
        }
    }
    
}
