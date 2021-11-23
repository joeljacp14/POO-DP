/*
Manejo basico de una pila
 *
 * @author Pedro Diaz
 */

import java.util.ArrayList;

public class Cola {
    ArrayList<String> arr = new ArrayList<String>();
    
    public void mete(String dato){
        arr.add(dato);
    }
    
    public void elimina(){
        if (arr.isEmpty()) System.out.println("Cola Vacia");
        else arr.remove(0);
    }
    
    public String frente(){
        if (arr.isEmpty()) return "Cola Vacia";
        else               return arr.get(0);        
    }
    
    public void imprime(){
        System.out.print("Frente -> ");
        for (int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println(" <-Atras");
    }
}
