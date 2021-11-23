/*
Impelmentar la busqueda binaria
Agregar cuantas iteraciones realizo para encontrar el dato

La busqueda binaria en un metodo recursivo

 * @author Pedro Diaz
 */
public class BuscaBin {
    int arr[] = {2,4,6,8,9,11,13,15,17,20};
    int med=0;
    
    public void buscaWhile(int dato){
        int ini = 0, fin = arr.length-1, con=0;
        while (ini<=fin){
            med = (ini+fin)/2;
            con++;
            if (arr[med]==dato){ System.out.println("Dato encontrado"); break;}
            else
                if (dato>arr[med]) ini = med +1;
                else               fin = med -1;
        }
        if (ini>fin) System.out.println("Dato NO encontrado");
        System.out.println("Total de iteraciones: "+con);
    }
    
    public static void main(String[] args) {
        
        BuscaBin xx= new BuscaBin();
        int num=9;
        xx.buscaWhile(num);

    }
}
