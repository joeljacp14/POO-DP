

/**
 *
 * @author Pedro Díaz
 * modificado por: Joel Jacome Pioquinto - S18001428
 */
package com.jpdev.dp.examenfinal;

import java.io.*;

public class Joel1 {

    public int arr[] = new int[100];
    File f;
    int med = 0;

    public Joel1() {
        System.out.println("INICIO");
        leeArch();
    }

    public void leeArch() {
        f = new File("Numeros100.txt");
        String aux;
        double num;
        int con = 0;
        try {
            if (!f.exists()) {
                System.out.println("No existe el archivo");
                return;
            }
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while (true) {
                aux = br.readLine();
                if (aux == null) {
                    break;
                }
                arr[con] = Integer.parseInt(aux);
                con++;
            }
            System.out.println("COntador = " + con);
        } catch (IOException e) {
            System.out.println("No existe el archivo");
        }
    }

    public void imprime() {
        for (int con = 0; con < arr.length; con++) {
            System.out.println(arr[con] + ", ");
        }
        System.out.println("");
    }

    public void ordenQuicksort(int primero, int ultimo) {
        int i, j, central;
        double pivote;
        central = (primero + ultimo) / 2;
        pivote = arr[central];
        i = primero;
        j = ultimo;
        do {
            while (arr[i] > pivote) {
                i++;
            }
            while (arr[j] < pivote) {
                j--;
            }
            if (i <= j) {
                int tmp;
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
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

    public void busquedaBinaria(int sDato){
        int ini = 0, fin = arr.length-1, iter = 0;
        while (ini <= fin){
            med = (ini + fin) / 2;
            iter++;
            if (arr[med] == (sDato)){
                System.out.println(sDato+" encontrado en la pocision "+med);
                break;
            } else {
                if (sDato > (arr[med]))
                    ini = med + 1;
                else
                    fin = med - 1;
            }
        }
        if (ini > fin)
            System.out.println("El dato no existe");
        System.out.println("Iteraciones: "+iter);
    }

    public static void main(String[] args) {
        Joel1 xx = new Joel1();
        xx.ordenQuicksort(0,xx.arr.length-1);
        //xx.busquedaSecuencial(841);
        xx.busquedaBinaria(841);
        xx.imprime();
    }
}
