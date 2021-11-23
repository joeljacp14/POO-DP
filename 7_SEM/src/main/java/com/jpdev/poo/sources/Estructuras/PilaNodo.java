/*
IMplementaciòn de una pila utilizando nodos
 * @author Pedro Dìaz
 */

public class PilaNodo {
    public int dato;
    public PilaNodo next;
    
    public PilaNodo(int xdato){
        dato = xdato;
        next = null;
    }
    
    public PilaNodo push(int xdato){
        PilaNodo top1 = this; // Es el objeto actual el que le pasamos del test
        PilaNodo aux = top1;
        top1 = new PilaNodo(xdato);
        top1.next = aux;
        return top1;
    }
    
    public int top(){
        return dato;
    }

    public PilaNodo pop(){
        return this.next;
    }
    
    public void imprime(){
        System.out.println(dato);
        if (next==null) return;
        next.imprime();
    }
    
    
}
