public class Arreglo2 {
    private static int[] A = { 1, 2, 3, 4, 5, 6, 7, 8 };

    public static void main(String[] args) {
        Arreglo obj = new Arreglo();
        System.out.println("Recursión:");
        System.out.println(obj.longitud(0));
        System.out.println("Recursión de cola:");
        System.out.println(obj.longitudCola(0, 0));
    }

    public int longitud(int posicion) {
        try {
            int n = A[posicion];
            return 1 + longitud(posicion + 1);
        } catch (Exception e) {
            return 0;
        }
    }

    public int longitudCola(int posicion, int acumulador) {
        try {
            int n = A[posicion];
            return longitudCola(posicion + 1, acumulador + 1);
        } catch (Exception e) {
            return acumulador;
        }
    }
}