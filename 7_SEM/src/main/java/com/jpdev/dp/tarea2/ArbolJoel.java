package com.jpdev.dp.tarea2;

/**
 * @author Joel Jacome Pioquinto - S18001428
 * */

import java.io.BufferedWriter;
import java.io.IOException;

public class ArbolJoel {//clase de arbol binario de busqueda (ABB)
    int dato;
    ArbolJoel izq, der;

    public ArbolJoel(int nDato){
        dato = nDato;
        izq = null;
        der = null;
        System.out.println("Nodo creado: "+nDato);
    }

    public void inserta(int nDato){
        if (nDato == this.dato){
            System.out.println("El dato ya existe en el arbol y no se puede repetir");
            return;
        }
        if (nDato < this.dato) {
            if (this.izq == null) {
                this.izq = new ArbolJoel(nDato);
                return;
            }
            this.izq.inserta(nDato);
            return;
        }
        if (nDato > this.dato){
            if (this.der == null){
                this.der = new ArbolJoel(nDato);
                return;
            }
            this.der.inserta(nDato);
            return;
        }
    }

    public void preOrden(){//incluye el contador de nodos y el numero mayor
        System.out.print(this.dato+", ");
        if (this.dato > ArbolJoelTest.mayor)
            ArbolJoelTest.mayor = this.dato;
        ArbolJoelTest.cont++;
        if (this.izq != null)
            this.izq.preOrden();
        if (this.der != null)
            this.der.preOrden();
        return;
    }

    public void inOrden(){
        if (this.izq != null)
            this.izq.inOrden();
        System.out.print(this.dato+", ");
        if (this.der != null)
            this.der.inOrden();
        return;
    }

    public void postOrden(){
        if (this.izq != null)
            this.izq.postOrden();
        if (this.der != null)
            this.der.postOrden();
        System.out.print(this.dato+", ");
        return;
    }

    public void guarda(BufferedWriter bw){//en preorden
        try {
            bw.write(this.dato+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (this.izq != null)
            this.izq.guarda(bw);
        if (this.der != null)
            this.der.guarda(bw);
        return;
    }

    public int altura(){
        if (this == null)
        {
            return 0;
        }
        if ((this.izq == null) || (this.der == null))
        {
            return 0;
        }
        if (this.izq.altura() > this.izq.altura())
            return 1 + this.izq.altura();
        else
            return 1 + this.der.altura();
    }

    public int elimina(int dDato){
        if (this == null)
            return -1;
        //si el nodo a eliminar es la raiz
        if (this.dato == dDato){
            if (this.izq == null && this.der == null)
                return 1;
            if (this.izq != null && this.der == null)
                return 2;
            if (this.izq == null && this.der != null)
                return 3;
            if (this.izq != null && this.der != null)
                return 4;
        }
        if (this.izq != null && this.der != null){
            //si el nodo a eliminar es el izquierdo
            if (this.izq.dato == dDato){
                //case 1: el nodo a eliminar es hoja
                if (this.izq.izq == null && this.izq.der == null){
                    this.izq = null;
                    return 0;
                }
                //case 2: el nodo a eliminar solo tiene un hijo
                if (this.izq.izq != null && this.izq.der == null){
                    this.izq = this.izq.izq;
                    return 0;
                }
                if (this.izq.izq == null && this.izq.der != null){
                    this.izq = this.izq.der;
                    return 0;
                }
                //case 3: el nodo tiene dos hijos
                if (this.izq.izq != null && this.izq.der != null){
                    int flag;
                    //case A: con predecesor
                    flag = this.izq.izq.predecesor();
                    if (flag == -1) {
                        flag = this.izq.der.sucesor();//case B: con sucesor
                        if (flag == -1){//no se pudo con el predecesor
                            this.izq.dato = this.izq.der.dato;
                            this.izq.der = null;
                            return 0;
                        }
                        this.izq.dato = flag;
                        return 0;
                    }
                    this.izq.dato = flag;
                    return 0;
                }
            }
            //si el derecho el el dato a eliminar
            if (this.der.dato == dDato){
                if (this.der.izq == null && this.der.der == null){
                    this.der = null;
                    return 0;
                }
                if (this.der.izq != null && this.der.der == null){
                    this.der = this.der.izq;
                    return 0;
                }
                if (this.der.izq == null && this.der.der != null){
                    this.der = this.der.der;
                    return 0;
                }
                if (this.der.izq != null && this.der.der != null){
                    int flag;
                    flag = this.der.izq.predecesor();
                    if (flag == -1) {
                        flag = this.der.der.sucesor();//case B: con sucesor
                        if (flag == -1){
                            this.der.dato = this.der.der.dato;
                            this.der.der = null;
                            return 0;
                        }
                        this.der.dato = flag;
                        return 0;
                    }
                    this.der.dato = flag;
                    return 0;
                }
            }
        }
        if (this.izq != null)
            this.izq.elimina(dDato);
        if (this.der != null)
            this.der.elimina(dDato);
        return -1;
    }

    public int predecesor(){
        if (this.der == null)
            return -1;
        if (this.der.der == null) {
            int nodo = this.der.dato;
            this.der = null;
            return nodo;
        }
        return this.der.predecesor();
    }

    public int sucesor(){
        if (this.izq.izq == null){
            int nodo = this.izq.dato;
            this.izq = null;
            return nodo;
        }
        return this.izq.sucesor();
    }

//    public void busca(int bDato){//indicar quien es el padre del dato encontrado
//        if (this == null){
//            System.out.println("El dato no existe");
//            return;
//        }
//        if (this.dato == bDato){
//            System.out.println("Dato encontrado: "+this.dato);
//            return;
//        }
//        if (bDato < this.dato)
//            this.izq.busca(bDato);
//        if (bDato > this.dato)
//            this.der.busca(bDato);
//    }

}
