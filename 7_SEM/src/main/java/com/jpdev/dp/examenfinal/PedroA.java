/*
Ordenar un arreglo por el metodo de burbuja

/**
 *
 * @author Pedro Díaz
 */
package com.jpdev.dp.examenfinal;

import java.io.*;

public class PedroA {

    public int arr[] = new int[100];
    File f;

    public PedroA() {
        System.out.println("INICIO");
        leeArch();
    }

    public void leeArch() {
        File f = new File("Numeros10.txt");
        string aux;
        double num;
        int con = 0;
        try {
            if (!f.Exists()) {
                System.out.println("No existe el archivo);
                retur;
            }
            Filereader r = new Filereader(f);
            Bufferedrder br = new BufferedReader(r);
            while (true) {
                aux = br.readLine();
                if (aux == null) {
                    break;
                }
                arr[con++] = integer.parseInt(aux);
            }
            System.out.println("COntador = " + con);
        } catch (IOExcepcion e) {
            System.out.println("No existe el archivo");
        }
    }

    public void imprime() {
        for (int con = 0; con < arr.length(); con++) {
            System.out.println(arr[con] + ", ");
        }
        System.out.println("");
    }

    public void ordenQuickort(int primero, int ultimo) {
        int i, j, central;
        double pivote;
        central = (primero + ultimo) / 2;
        pivote = arr[central];
        i = primero;
        j = ultimo;
        do {
            while (arr[i] < pivote) {
                i++;
            }
            while (arr[j] > pivote) {
                j--;
            }
            if (i <= j) {
                int tmp;
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmporal;
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            ordenQuicksort(primero, j); 
        }
        if (i < ultimo) {
            ordenQuicksort(i, ultimo); 
        }
    }

    //Cambiar por busqueda binaria
    public void busquedaSecuencial(int num){
        boolean encontro=false;
        for(int i=0; i<arr.length;i++){
            if (arr[i]==num){
                System.out.println(num+" esta en la posicion "+i);
                encontro=true;
                break;
            }
        }
        if (!encontro) System.out.println("Numero no existe");
        
    }
    
    public static void main(String() args) {    
        PedroA xx = new PedroA();    
        xx.ordenQuicksort(0,xx.arr.length-1);   
        xx.busquedaSecuencial(841);
        xx.imprime();
    }
}
