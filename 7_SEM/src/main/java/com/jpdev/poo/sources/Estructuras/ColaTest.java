/*
Test de Pila1
 * @author Pedro Diaz
 */

public class ColaTest {
    public static void main(String[] args) {
        Cola xx = new Cola();
        xx.mete("A");
        xx.mete("B");
        xx.mete("C");
        xx.imprime();
        xx.elimina();
        xx.elimina();
        xx.mete("D");
        xx.imprime();
        xx.elimina();
        System.out.println("EL TOP ES: "+xx.frente());
        xx.elimina();
        xx.elimina();
    }
}
