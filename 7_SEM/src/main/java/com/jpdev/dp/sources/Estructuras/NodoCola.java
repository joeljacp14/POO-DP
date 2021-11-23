package com.jpdev.dp.sources.Estructuras;

/*
Manejo general de la etructura de cola

 * @author Pedro Diaz
 */
public class NodoCola {
    public int dato;
    public NodoCola next;
    
    public NodoCola(int xdato){
        dato = xdato;
        next = null;
    }
    
    public NodoCola guarda(int xdato){
        NodoCola atras = this;
        NodoCola aux;
        aux = new NodoCola(xdato);
        atras.next = aux;
        return aux;
    }
    
    public int top(){
        return dato;
    }
    
    public NodoCola baja(){
        return this.next;
    }
    
    public void imprime(){
        System.out.print(dato+"  ");
        if (next==null) return;
        next.imprime();
    }
    
}
