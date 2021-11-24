package com.jpdev.dp.tarea3;

/**
 * @author Joel jp
 * */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class JoelTarea3 {
    String line;
    int med = 0;
    int array[] = new int[1000];
    public File f;
    Arbol arbol = null;

    public JoelTarea3(){
        try {
            f = new File("Numeros1000.txt");
            f.createNewFile();
            if (!f.exists()){
                System.out.println("El archivo no existe");
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            while(true){
                line = br.readLine();
                if (line == null)
                    break;
                array[i] = Integer.parseInt(line);
                if (arbol == null)
                    arbol = new Arbol(Integer.parseInt(line));
                else arbol.agrega(Integer.parseInt(line));
                i++;
            }
            quickSort(0, array.length - 1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void imprime(){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+", ");
        }
        System.out.println("fin");
    }

    public void quickSort(int primero, int ultimo){
        int i, j, central;
        int pivote;
        central = (primero + ultimo) / 2;
        pivote = array[central];
        i = primero;
        j = ultimo;
        do {
            while (array[i] < pivote) {
                i++;
            }
            while (array[j] > pivote) {
                j--;
            }
            if (i <= j) {
                int tmp;
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            quickSort(primero, j);
        }
        if (i < ultimo) {
            quickSort(i, ultimo);
        }
    }

    public void busquedaBinaria(int sDato){
        int ini = 0, fin = array.length-1, iter = 0;
        while (ini <= fin){
            med = (ini + fin) / 2;
            iter++;
            if (array[med] == (sDato)){
                System.out.println("Dato encontrado");
                break;
            } else {
                if (sDato > (array[med]))
                    ini = med + 1;
                else
                    fin = med - 1;
            }
        }
        if (ini > fin)
            System.out.println("El dato no existe");
        System.out.println("Iteraciones: "+iter);
    }

    public class Arbol{
        int dato;
        Arbol izq;
        Arbol der;

        public Arbol(int nDato){
            dato = nDato;
            izq = null;
            der = null;
        }

        public void agrega(int nDato){
            if (nDato == this.dato){
                System.out.println("El dato ya existe en el arbol y no se puede repetir");
                return;
            }
            if (nDato < this.dato) {
                if (this.izq == null) {
                    this.izq = new Arbol(nDato);
                    return;
                }
                this.izq.agrega(nDato);
                return;
            }
            if (nDato > this.dato){
                if (this.der == null){
                    this.der = new Arbol(nDato);
                    return;
                }
                this.der.agrega(nDato);
                return;
            }
        }

        public void inOrden(){
            if (this.izq != null)
                this.izq.inOrden();
            System.out.print(this.dato+", ");
            if (this.der != null)
                this.der.inOrden();
            return;
        }

        public void busqueda(int sDato, int iter){
            if (this == null){
                System.out.println("El arbol se encuentra vacio, llenelo por favor!");
                return;
            }
            if (dato == this.dato){
                System.out.println("Dato encontrado con busqueda de arbol");
                System.out.println("Iteraciones realizadas: "+iter);
                return;
            }
            if (dato < this.dato){
                if (this.izq == null){
                    System.out.println("El dato no existe");
                    System.out.println("Iteraciones realizadas: "+iter);
                    return;
                }else {
                    this.izq.busqueda(sDato, ++iter);
                }
            }
            if (dato > this.dato){
                if (this.der == null){
                    System.out.println("El dato no existe");
                    System.out.println("Iteraciones realizadas: "+iter);
                }else {
                    this.der.busqueda(sDato, ++iter);
                }
            }
        }
    }

    public static void main(String[] args) {
        JoelTarea3 numeros = new JoelTarea3();
        System.out.print("ARREGLO: ");
        numeros.imprime();
        System.out.print("ARBOL: ");
        numeros.arbol.inOrden();
        //implementar busqueda
    }
}


