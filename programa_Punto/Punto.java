import java.util.*;

public class Punto {
    private float x, y;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Punto punto1 = new Punto(1.2f, 3.4f);
        System.out.println("Coordenada x: " + punto1.obtenerCoordenadaX());
        System.out.println("Coordenada y: " + punto1.obtenerCoordenadaY());
        punto1.modificaX(5.0f);
        punto1.imprimeCoordenadas();
        punto1.modificaY(6.1f);
        punto1.imprimeCoordenadas();
    }

    public Punto(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float obtenerCoordenadaX(){
        return this.x;
    }

    public float obtenerCoordenadaY(){
        return this.y;
    }

    public void modificaY(float y){
        this.y = y;
    }

    public void modificaX(float x){
        this.x = x;
    }

    public void imprimeCoordenadas(){
        System.out.printf("Coordenada x: %.2f\nCoordenada y: %.2f\n", this.x, this.y);
    }
}