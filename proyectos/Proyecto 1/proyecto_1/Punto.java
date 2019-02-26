import java.util.*;

public class Punto {
    // Declaracion de variables de la clase
    private float x, y;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {

            System.out.println("Vamos a crear un nuevo punto");
            System.out.print("Escribe la coordenada de x: ");
            float x = sc.nextFloat();
            sc.nextLine();

            System.out.print("Escribe la coordenada de y: ");
            float y = sc.nextFloat();
            sc.nextLine();
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

    // Contructor
    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // regresa la coordenada x del punto
    public float obtenerCoordenadaX() {
        return this.x;
    }

    // regresa la coordenada y del punto
    public float obtenerCoordenadaY() {
        return this.y;
    }

    // cambia el valor de la coordenada x del punto
    public void modificaX(float x) {
        this.x = x;
    }

    // cambia el valor de la coordenada y del punto
    public void modificaY(float y) {
        this.y = y;
    }

    // imprime las coordenadas del punto
    public void imprimeCoordenadas() {
        System.out.printf("Coordenada x: %.2f\nCoordenada y: %.2f\n", this.x, this.y);
    }
}