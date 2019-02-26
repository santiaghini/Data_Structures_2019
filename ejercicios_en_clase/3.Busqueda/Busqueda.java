
/**
 * Busqueda
 */

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Busqueda {
    static Scanner sc = new Scanner(System.in);
    final static int SECUENCIAL = 0;
    final static int MEJORADA = 1;
    final static int BINARIA = 2;

    public int[] arregloAleatorio(int n, int k) {
        int[] arr = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(k) + 1;
        }
        Arrays.sort(arr);
        return arr;
    }

    public int secuencial(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return i;
            }
        }
        return -1;
    }

    public int mejorado(int[] arr, int k, int batchSize) {
        int n = 0;
        int len = arr.length;
        if (arr[0] > k || arr[len - 1] < k) {
            return -1;
        }

        int jump = batchSize;
        boolean less;

        for (int i = 0; i < arr.length; i = i + batchSize) {
            jump = batchSize;
            int a = arr[i];
            if (k > a) {
                continue;
            } else if (k < a) {
                less = true;
                for (int j = batchSize; j > 0; j--) {
                    if (less) {
                        a = arr[i - j];
                        if (k > a) {
                            continue;
                        } else if (a == k) {
                            return i - j;
                        }
                    } else {
                        a = arr[i + j];
                        if (k < a) {
                            continue;
                        } else if (a == k) {
                            return i + j;
                        }
                    }
                }
            } else {
                // el elemento es el que estoy buscando
                return i;
            }
        }
        return -1;
    }

    public int binaria(int[] arr, int primero, int ultimo, int k) {
        int indice;
        if (ultimo < primero) {
            indice = -1;
        } else {
            int medio = Math.floorDiv(primero + ultimo, 2);
            if (k == arr[medio]) {
                indice = medio;
            } else if (k < arr[medio]) {
                indice = binaria(arr, primero, medio - 1, k);
            } else {
                indice = binaria(arr, medio + 1, ultimo, k);
            }
        }
        return indice;
    }

    public void printArr(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Busqueda b = new Busqueda();

        System.out.print("Tamaño del arreglo: ");
        int arraySize = sc.nextInt();
        sc.nextLine();

        System.out.print("Rango de los números en el arreglo: ");
        int rango = sc.nextInt();
        sc.nextLine();

        int[] arr = b.arregloAleatorio(arraySize, rango);

        System.out.print("Tamaño del batch (para búsqueda mejorada): ");
        int batchSize = sc.nextInt();
        sc.nextLine();

        System.out.println("Arreglo:");
        b.printArr(arr);

        System.out.print("Número de iteraciones de búsqueda: ");
        int iterations = sc.nextInt();
        sc.nextLine();

        ArrayList<nBusqueda> busquedas = new ArrayList<nBusqueda>();

        for (int i = 0; i < iterations; i++) {
            Random r = new Random();
            int k = r.nextInt(rango) + 1;

            nBusqueda busqueda = new nBusqueda(k);

            // busqueda secuencial naive
            long startTime = System.nanoTime();
            int resultadoBusquedaSecuencial = b.secuencial(arr, k);
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            busqueda.setResultadoSecuencial(resultadoBusquedaSecuencial);
            busqueda.setTiempoSecuencial(timeElapsed);

            // busqueda mejorada
            startTime = System.nanoTime();
            int resultadoBusquedaMejorada = b.mejorado(arr, k, batchSize);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            busqueda.setResultadoMejorada(resultadoBusquedaMejorada);
            busqueda.setTiempoMejorada(timeElapsed);

            // busqueda binaria
            startTime = System.nanoTime();
            int resultadoBusquedaBinaria = b.binaria(arr, 0, arr.length - 1, k);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            busqueda.setResultadoBinaria(resultadoBusquedaBinaria);
            busqueda.setTiempoBinaria(timeElapsed);

            busquedas.add(busqueda);
        }

        long tiempoPromedioSecuencial = tiempoPromedio(busquedas, "secuencial");
        long tiempoPromedioMejorada = tiempoPromedio(busquedas, "mejorada");
        long tiempoPromedioBinaria = tiempoPromedio(busquedas, "binaria");
        printResultados(busquedas, tiempoPromedioSecuencial, tiempoPromedioMejorada, tiempoPromedioBinaria);

    }

    private static void printResultado(int resultado) {
        switch (resultado) {
        case -1:
            System.out.println("El elemento no está en el arreglo");
            break;

        default:
            System.out.println("La posición del elemento es: " + resultado);
            break;
        }
    }

    private static void printResultados(ArrayList<nBusqueda> busquedas, long tiempoPromedioSecuencial,
            long tiempoPromedioMejorada, long tiempoPromedioBinaria) {
        int victoriasSecuencial = 0;
        int victoriasMejorada = 0;
        int victoriasBinaria = 0;

        System.out.println();
        for (int i = 0; i < busquedas.size(); i++) {
            nBusqueda busqueda = busquedas.get(i);
            System.out.println("Iteración " + (i + 1));
            System.out.println("Valor: " + busqueda.getValor());
            System.out.println("Resultado Secuencial: " + busqueda.getResultadoSecuencial());
            System.out.println("Tiempo Secuencial: " + busqueda.getTiempoSecuencial());
            System.out.println("Resultado Mejorada: " + busqueda.getResultadoMejorada());
            System.out.println("Tiempo Mejorada: " + busqueda.getTiempoMejorada());
            System.out.println("Resultado Binaria: " + busqueda.getResultadoBinaria());
            System.out.println("Tiempo Binaria: " + busqueda.getTiempoBinaria());
            int ganador = getGanador(busqueda.getTiempoSecuencial(), busqueda.getTiempoMejorada(),
                    busqueda.getTiempoBinaria());

            String ganadorStr = "";
            switch (ganador) {
            case SECUENCIAL:
                victoriasSecuencial++;
                ganadorStr = "Secuencial";
                break;
            case MEJORADA:
                victoriasMejorada++;
                ganadorStr = "Mejorada";
                break;
            case BINARIA:
                victoriasBinaria++;
                ganadorStr = "Binaria";
                break;
            default:
                break;
            }
            System.out.println("Mejor tiempo: " + ganadorStr);
            System.out.println();
        }

        System.out.print("-----------------------\n\n");
        System.out.println("Victorias");
        System.out.println("Secuencial: " + victoriasSecuencial);
        System.out.println("Mejorada: " + victoriasMejorada);
        System.out.println("Binaria: " + victoriasBinaria);

        System.out.println("Tiempos promedio:");
        System.out.println("Secuencial: " + tiempoPromedioSecuencial);
        System.out.println("Mejorada: " + tiempoPromedioMejorada);
        System.out.println("Binaria: " + tiempoPromedioBinaria);
    }

    private static int getGanador(long tSecuencial, long tMejorada, long tBinaria) {
        int ganador = 0;

        if (tBinaria < tMejorada && tBinaria < tSecuencial) {
            ganador = 2;
        } else if (tMejorada < tBinaria && tMejorada < tSecuencial) {
            ganador = 1;
        } else if (tSecuencial < tBinaria && tSecuencial < tMejorada) {
            ganador = 0;
        }

        return ganador;
    }

    private static long tiempoPromedio(ArrayList<nBusqueda> busquedas, String key) {
        int n = busquedas.size();
        long suma = 0;
        for (int i = 0; i < n; i++) {
            nBusqueda busqueda = busquedas.get(i);
            if (key.equals("secuencial")) {
                suma += busqueda.getTiempoSecuencial();
            } else if (key.equals("mejorada")) {
                suma += busqueda.getTiempoMejorada();
            } else if (key.equals("binaria")) {
                suma += busqueda.getTiempoBinaria();
            }
        }
        return suma / n;
    }

}