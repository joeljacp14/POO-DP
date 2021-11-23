package com.jpdev.dp.sources.Estructuras;

/*
Manejo general de la estructura de lista

 * @author Pedro Diaz
 */
public class NodoLista {
    public int dato;
    public NodoLista next;
    
    public NodoLista(int xdato){
        dato = xdato;
        next = null;
    }
    
    public NodoLista guarda(int xdato){
            NodoLista actual = this;
            NodoLista anterior=null,nuevo;
            while(xdato>actual.dato && actual.next!=null){
               anterior = actual;
               actual = actual.next;
            }
            if (actual.next==null){ 
                if(xdato>actual.dato){ anterior=actual; actual=null;} 
            }
            nuevo = new NodoLista(xdato);
            nuevo.next = actual;
            if (anterior!=null) anterior.next=nuevo;
        return nuevo;
    }
    
   public void busca(int xdato){
        int con=1;
        NodoLista actual=this;
        while(actual.dato!=xdato && actual.next!=null){
            actual = actual.next;
            con++;
        }
        if (actual.next==null && actual.dato!=xdato)
            System.out.println("No se encontro el dato "+xdato);
        else
            System.out.println("El dato "+xdato+" esta en la posicion: "+ con);

    }
    
    public void baja(int xdato){
        NodoLista actual=this,anterior=null;
        while(actual.dato!=xdato && actual.next!=null){
            anterior = actual;
            actual = actual.next;
        }
        if (actual.next==null && actual.dato!=xdato)
            System.out.println("No se encontro el dato "+xdato);
        else{
           anterior.next = actual.next;
            System.out.println(xdato+" dado de baja");
        }
    }
    
    public void imprime(){
        System.out.print(dato+"  ");
        if (next==null) return;
        next.imprime();
    }
    
}
