import java.util.*;

public class Rectangulo {
    private float x, y, desplazamientoX, desplazamientoY;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ahora crearemos un Rectangulo");
        System.out.print("Escribe la coordenada de x del vértice superior izquierdo: ");
        float x = sc.nextFloat();
        sc.nextLine();
        System.out.print("Escribe la coordenada de y del vértice superior izquierdo: ");
        float y = sc.nextFloat();
        sc.nextLine();
        System.out.print("Escribe el desplazamiento de x (largo): ");
        float desplazamientoX = sc.nextFloat();
        sc.nextLine();
        System.out.print("Escribe el desplazamiento de y (alto): ");
        float desplazamientoY = sc.nextFloat();
        sc.nextLine();

        Rectangulo obj = new Rectangulo(x, y, desplazamientoX, desplazamientoY);

        System.out.println("El área del Rectangulo es: " + obj.obtenerArea());
        System.out.println();

        System.out.println("Ahora cambiaremos el alto");
        System.out.print("Escribe el nuevo desplazamiento de y (alto): ");
        desplazamientoY = sc.nextFloat();
        sc.nextLine();
        obj.modificarDesplazamientoY(desplazamientoY);

        System.out.println("La nueva área del Rectangulo es: " + obj.obtenerArea());
        System.out.println();

    }

    public Rectangulo(float x, float y, float desplazamientoX, float desplazamientoY) {
        this.x = x;
        this.y = y;
        this.desplazamientoX = desplazamientoX;
        this.desplazamientoY = desplazamientoY;
    }

    public float obtenerCoordenadaX() {
        return this.x;
    }

    public float obtenerCoordenadaY() {
        return this.y;
    }

    public float obtenerDesplazamientoX() {
        return this.desplazamientoX;
    }

    public float obtenerDesplazamientoY() {
        return this.desplazamientoY;
    }

    public void modificarY(float y) {
        this.y = y;
    }

    public void modificarX(float x) {
        this.x = x;
    }

    public void modificarDesplazamientoX(float desplazamientoX) {
        this.desplazamientoX = desplazamientoX;
    }

    public void modificarDesplazamientoY(float desplazamientoY) {
        this.desplazamientoY = desplazamientoY;
    }

    public float obtenerArea() {
        return this.desplazamientoX * this.desplazamientoY;
    }

}