package com.jpdev.dp.tarea1;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

public class ListaJoel {
    //elementos de la lista
    int dato;
    ListaJoel sig;

    public ListaJoel(int newDato){
        dato = newDato;
        sig = null;
    }

    public ListaJoel alta(int newDato, ListaJoel originalTope){
        ListaJoel nuevo = new ListaJoel(newDato);
        if (this == null){//el elemento de la lista se encentra vacio
            return nuevo;
        }
        if (newDato == this.dato){//el dato ya existe
            return originalTope;
        }
        if (newDato < this.dato){//si es menor
            nuevo.sig = this;
            return nuevo;
        }
        if (newDato > this.dato){//valida si el dato es mayor
            if (this.sig == null){//si no hay otro elemento despues de this
                this.sig = nuevo;
                return originalTope;
            }
            if (newDato < this.sig.dato){//si el elemento necesita insertarse entre este y el siguiente
                nuevo.sig = this.sig;
                this.sig = nuevo;
                return originalTope;
            }
        }
        return this.sig.alta(newDato, originalTope);
    }

    public ListaJoel baja(int suprDato, ListaJoel originalTope){
        if (this == null){
            System.out.println("El dato no se encontro");
            return originalTope;
        }
        if (suprDato == this.dato){//si el primero es el valor a eliminar
            originalTope = this.sig;
            this.sig = null;
            System.out.println("Dato eliminado");
            return originalTope;
        }
        if (this.sig == null){
            System.out.println("El dato no existe en la lista");
            return originalTope;
        }else {
            if (suprDato == this.sig.dato){
                this.sig = this.sig.sig;
                System.out.println("Dato eliminado");
                return originalTope;
            }
        }
        return this.sig.baja(suprDato, originalTope);
    }

    public void imprime(){
        System.out.print(dato+" -> ");
        if (sig == null){
            System.out.println("fin");
            return;
        }
        sig.imprime();
    }

    public void busca(int findDato, int intents){//mandar a llamar con el valor de 1
        if (findDato == this.dato){
            System.out.println("Dato encontrado en la pocision "+intents);
            return;
        }
        if (this.sig == null){
            System.out.println("El dato no existe en la lista");
            System.out.println("Intentos realizados: "+intents);
            return;
        }
        this.sig.busca(findDato, ++intents);
    }

}
