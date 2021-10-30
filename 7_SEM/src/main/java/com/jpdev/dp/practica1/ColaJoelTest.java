package com.jpdev.dp.practica1;

/*
 * @author: Joel Jacome Pioquinto - S18001428
 * */

public class ColaJoelTest {
    public static void main(String[] args) {
        ColaJoel cola = new ColaJoel();
        cola.push(89);
        cola.push(23);
        cola.push(745);
        cola.push(4);
        cola.push(819247);
        cola.show();
        System.out.println("Elemento eliminado: "+cola.pop().dato);
        cola.show();
    }
}
