package com.jpdev.poo.programa5;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

import java.util.ArrayList;
import java.util.Collections;

public class Joel5 {
    ArrayList<String> calificaciones = new ArrayList<>();

    public void agregar(String cal){
        calificaciones.add(cal);
        Collections.sort(calificaciones);
    }

    public void eliminar(String del){
        for (int i = 0; i < calificaciones.size(); i++){
            if (calificaciones.get(i).equals(del)){
                calificaciones.remove(i);
                System.out.println("Elemento eliminado");
                return;
            }
        }
        System.out.println("El elemento no se encontro en la lista");
    }

    public void imprime(){
        for (int i = 0; i < calificaciones.size(); i++){
            System.out.print(calificaciones.get(i)+" -> ");
        }
        System.out.println("Fin");
    }

    public int cuenta(){
        if (!calificaciones.isEmpty())
            return calificaciones.size();
        else
            return 0;
    }

    public void firstLast(){
        System.out.println("Primer elemento -> "+calificaciones.get(0));
        System.out.println("Ultimo elemtno -> "+calificaciones.get(calificaciones.size() - 1));
    }
}
