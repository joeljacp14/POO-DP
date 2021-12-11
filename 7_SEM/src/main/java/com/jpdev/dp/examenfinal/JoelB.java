package com.jpdev.dp.examenfinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

public class JoelB {
    String line;
    int med = 0, dato;
    public File f;
    JoelB.Arbol arbol = null;

    public JoelB(){
        try {
            f = new File("Numeros100.txt");
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
                dato = Integer.parseInt(line);
                if (arbol == null)
                    arbol = new JoelB.Arbol(dato);
                else arbol.agrega(dato);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public class Arbol{
        int dato;
        JoelB.Arbol izq;
        JoelB.Arbol der;

        public Arbol(int nDato){
            dato = nDato;
            izq = null;
            der = null;
        }

        public void agrega(int nDato){
            if (nDato < this.dato) {
                if (this.izq == null) {
                    this.izq = new JoelB.Arbol(nDato);
                    return;
                }
                this.izq.agrega(nDato);
                return;
            }
            if (nDato >= this.dato){
                if (this.der == null){
                    this.der = new JoelB.Arbol(nDato);
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

        public int menor(){
            if (this.izq == null)
                return this.dato;
            return this.izq.menor();
        }

        public void busqueda(int sDato, int iter){
            if (this == null){
                System.out.println("El arbol se encuentra vacio, llenelo por favor!");
                return;
            }
            iter++;
            if (sDato == this.dato){
                System.out.println("Dato encontrado");
                System.out.println("Iteraciones: "+iter);
                return;
            }
            if (sDato < this.dato){
                if (this.izq == null){
                    System.out.println("El dato no existe");
                    System.out.println("Iteraciones: "+iter);
                    return;
                }else {
                    this.izq.busqueda(sDato, iter);
                }
            }
            if (sDato > this.dato){
                if (this.der == null){
                    System.out.println("El dato no existe");
                    System.out.println("Iteraciones: "+iter);
                }else {
                    this.der.busqueda(sDato, iter);
                }
            }
        }
    }

    public static void main(String[] args) {
        JoelB abb = new JoelB();
        Scanner sc = new Scanner(System.in);
        int dato, iter = 0;
        System.out.print("ARBOL INORDEN: ");
        abb.arbol.inOrden();
        System.out.print("\nIngresa un dato a buscar: ");
        dato = sc.nextInt();
        abb.arbol.busqueda(dato, iter);
        System.out.println("El numero menor en el arbol es: "+abb.arbol.menor());
    }
}
