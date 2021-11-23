/*
Manejador de la implementaciòn de la pila
 *
 * @author Pedro Diaz
 */
public class PilaNodoTest {
    
    public static void main(String[] args) {
        PilaNodo top = new PilaNodo(11); 
        top = top.push(22);
        top = top.push(33);
        top = top.push(44);
        top = top.pop();
        top.imprime();
        System.out.println("Top--> "+top.top());
    }
    
}
