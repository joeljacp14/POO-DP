package com.jpdev.dp.practica1;

/*
* @author: Joel Jacome Pioquinto - S18001428
* */

public class ColaJoel {
    int dato;
    ColaJoel sig;

    public ColaJoel() {
        dato = 0;
        sig = null;
    }

    public void push(int dato) {
        if(this.sig == null){
            ColaJoel nuevo = new ColaJoel();
            nuevo.dato = dato;
            nuevo.sig = this.sig;
            this.sig = nuevo;
            return;
        }
        this.sig.push(dato);
    }

    public ColaJoel pop(){
        if (this.sig == null) {
            return null;
        }
        ColaJoel elemento = this.sig;
        this.sig = this.sig.sig;
        return elemento;
    }

    public void show(){
        if(this.sig == null) {
            System.out.println("fin");
            return;
        }
        System.out.print(this.sig.dato+" -> ");
        this.sig.show();
    }
}
