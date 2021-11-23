/*
Test de Pila1
 * @author Pedro Diaz
 */

public class Pila1Test {
    public static void main(String[] args) {
        Pila1 xx = new Pila1();
        xx.push("A");
        xx.push("B");
        xx.push("C");
        xx.pop();
        xx.pop();
        xx.push("D");
        xx.imprime();
        xx.pop();
        System.out.println("EL TOP ES: "+xx.top());
        xx.pop();
        xx.pop();
    }
}
