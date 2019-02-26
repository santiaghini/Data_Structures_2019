public class Arreglo {
    private Integer[] A = { 1, 2, 3, 4, 5, 6, 7, 8 };

    public static void main(String[] args) {
        Arreglo obj = new Arreglo();
        System.out.println("Recursión:");
        System.out.println(obj.longitud(0));
        System.out.println("Recursión de cola:");
        System.out.println(obj.longitudCola(0, 0));
    }

    int longitud(int posicion) {
        if (A[posicion] == null) {
            return 0;
        }
        return 1 + longitud(posicion + 1);
    }

    int longitudCola(int posicion, int acumulador) {
        if (A[posicion] == null) {
            return acumulador;
        }
        return longitudCola(posicion + 1, acumulador + 1);
    }

}