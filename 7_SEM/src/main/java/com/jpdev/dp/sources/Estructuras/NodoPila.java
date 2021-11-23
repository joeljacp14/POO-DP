package com.jpdev.dp.sources.Estructuras;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Diaz
 */
public class NodoPila {
    public int dato;
    public NodoPila next;
    
    public NodoPila(int xdato){
        dato = xdato;
        next = null;
    }
    
    public NodoPila push(int xdato){
        NodoPila top1 = this;
        NodoPila aux = top1;
        top1 = new NodoPila(xdato);
        top1.next = aux;
        return top1;
    }
    
    public int top(){
        return dato;
    }
    
    // Dar de baja el elemento
    public NodoPila pop(){
        return this.next;
    }
    
    public void imprime(){
        System.out.println(dato);
        if (next==null) return;
        next.imprime();
    }
    
}
