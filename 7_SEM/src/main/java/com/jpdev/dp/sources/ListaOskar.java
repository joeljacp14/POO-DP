public class ListaOskar {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.alta(15);
        lista.alta(7);
        lista.alta(3);
        lista.alta(9);
        lista.imprime();
        lista.alta(10);
        lista.imprime();

        lista.baja(9);
        lista.imprime();

        lista.baja(5);
        lista.imprime();

        System.out.println("Se hallo en la " + lista.busca(10) + " posicion");
        System.out.println("No se hallo antes de la " + lista.busca(9) + " posicion");
    }
}

class Lista {
    int dato;
    Lista next;

    public Lista() {
        this.dato = 0;
        this.next = null;
    }

    public void alta (int dato) {
        if (this.next == null || next.dato > dato) {//si el dato es menor
            Lista tmp = new Lista();
            tmp.dato = dato;
            tmp.next = this.next;
            this.next = tmp;
            return;
        }

        this.next.alta(dato);
    }

    public void baja(int dato) {
        if (this.next == null) {
            return;
        }
        if (this.next.dato == dato) {
            this.next = this.next.next;
            return;
        }
        this.next.baja(dato);
    }

    public void imprime() {
        if(this.next == null){
            System.out.println();
            return;
        }
        System.out.print(this.next.dato + "->");
        this.next.imprime();
    }

    public int busca(int dato) {
        if (this.next == null || dato < this.next.dato) {
            return 0;
        }

        if (this.next.dato == dato) {
            return 0;
        }

        return 1 + this.next.busca(dato);
    }
}