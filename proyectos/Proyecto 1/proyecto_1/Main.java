import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Vamos a crear un nuevo punto");
            System.out.print("Escribe la coordenada de x: ");
            float x = sc.nextFloat();
            sc.nextLine();
            // checkType(x);

            System.out.print("Escribe la coordenada de y: ");
            float y = sc.nextFloat();
            sc.nextLine();
            // checkType(y);
            System.out.println();

            Punto punto1 = new Punto(x, y);

            System.out.println("Estas son las coordenadas:");
            punto1.imprimeCoordenadas();

            System.out.println();
            System.out.println("Cambiemos x");
            System.out.print("Escribe la nueva coordenada de x: ");
            x = sc.nextFloat();
            sc.nextLine();
            punto1.modificaX(x);

            System.out.println();
            System.out.println("Estas son las nuevas coordenadas:");
            punto1.imprimeCoordenadas();
        } catch (InputMismatchException ime) {
            System.out.println(ime.toString());
            sc.next(); // Flush the buffer from all data
        }
    }

    // public static void checkType(float n) throws Exception {
    // if (n % 1 == 0) {
    // throw new Exception("Wrong type");
    // }
    // }
}