/*
Ordenar un arreglo por el metodo de burbuja

/**
 *
 * @author Pedro Díaz
 */

import java.io.*;

public class Ordenamiento {

    public int arr[] = new int[150000];
    //public int arr[] = {6,5,4,8,1,9,7,2};
    File f;

    public Ordenamiento() {
        System.out.println("INICIO");
        leeArch();
    }

    public void leeArch() {
        File f = new File("Numeros200000.txt");
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
                //System.out.println(aux);
                arr[con++] = Integer.parseInt(aux);
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

    public void ordenBurbuja() {
        int aux = 0;
        int ciclo = 0;
        for (int y = 0; y < arr.length - 1; y++) {
            for (int x = 0; x < arr.length - 1 - y; x++) {
                if (arr[x] > arr[x + 1]) {
                    aux = arr[x];
                    arr[x] = arr[x + 1];
                    arr[x + 1] = aux;
                }
                ciclo++;
            }
        }
        System.out.println("Numero de ciclos: " + ciclo);
    }

    public void ordenSeleccion() {
        int aux = 0;
        int indiceMenor = 0;
        int ciclo = 0;
        for (int y = 0; y < arr.length - 1; y++) {
            indiceMenor = y;
            for (int x = y; x < arr.length; x++) {
                if (arr[x] < arr[indiceMenor]) {
                    indiceMenor = x;
                }
                ciclo++;
            }
            aux = arr[y];
            arr[y] = arr[indiceMenor];
            arr[indiceMenor] = aux;
        }
        System.out.println("Numero de ciclos: " + ciclo);
    }

    public void ordenInserccion() {
        int aux = 0, pos = 0, ciclo = 0;
        for (int i = 0; i < arr.length; i++) {
            pos = i;
            aux = arr[pos];
            for (pos = i; pos > 0 && aux < arr[pos - 1]; pos--) {
                //while(pos>0 && aux<arr[pos-1]){
                arr[pos] = arr[pos - 1];
                ciclo++; //pos--;
            }
            arr[pos] = aux;
        }
        System.out.println("Ciclos: " + ciclo);
    }

    public void ordenQuicksort(int primero, int ultimo) {
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
                arr[j] = tmp;
                /* intercambia a[i] con a[j] */
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            ordenQuicksort(primero, j); /* mismo proceso con sublista izqda */
        }
        if (i < ultimo) {
            ordenQuicksort(i, ultimo); /* mismo proceso con sublista drcha */
        }
    }

    public void ordenShell(){
         int intervalo, i, j, k;
         int n= arr.length;
         intervalo = n / 2;
         while (intervalo > 0){
             for (i = intervalo; i < n; i++){
                  j = i - intervalo;
                  while (j >= 0){
                     k = j + intervalo;
                     if (arr[j] <= arr[k])
                       j = -1; 
                     else{
                       int temp;
                       temp = arr[j];
                       arr[j] = arr[k];
                       arr[k] = temp;
                       j -= intervalo;
                     }
                  }
             }
            intervalo = intervalo / 2;
        }
    }
    
    public static void main(String[] args) {    // Burbuja 1225      31579 
        Ordenamiento xx = new Ordenamiento();   // Seleccio 1118     19626 
        //xx.imprime();                         // Inserccion  913   10279    14873 
        long ini = System.currentTimeMillis();  // QuickSort          8435    11833
        //xx.ordenQuicksort(0,xx.arr.length-1);   // ShellSort          8600  12390 
        xx.ordenInserccion();
        xx.imprime();
        long fin = System.currentTimeMillis();
        System.out.println("Tardo en ordenar: " + (fin - ini) + " milisegundos");
    }
}
