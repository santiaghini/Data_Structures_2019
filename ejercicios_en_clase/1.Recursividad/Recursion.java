public class Recursion {

    int[] A = { 1, 2, 3, 4, 5 };

    public static void main(String[] args) {
        int res = 0;
        Recursion obj = new Recursion();

        // res = obj.factRec(5);
        // System.out.println(res);

        // System.out.println("Multiplicación");
        // int res1 = obj.multRec(10, 3);
        // System.out.println(res1);

        // System.out.println("Potencia");
        // int res2 = obj.potenciaRec(2, 6);
        // System.out.println(res2);
        // System.out.println("Silabas en 'Arbol'");
        // String str = "Parangaricutirimicuaro";
        // int vocales = obj.countVowels(str, 0);
        // System.out.println(vocales);

        int n = 6;
        System.out.println("Suma Fibonacci de " + n);
        int fib = obj.fibonacciSum(n);
        System.out.println(fib);
    }

    public int fibonacciSum(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciSum(n - 1) + fibonacciSum(n - 2);
        }
    }

    public int countVowels(String str, int pos) {
        int n = str.length();
        str = str.toLowerCase();
        if (pos == n - 1) {
            return checkIfVowel(str.charAt(pos));
        } else {
            return checkIfVowel(str.charAt(pos)) + countVowels(str, pos + 1);
        }
    }

    public int checkIfVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return 1;
        } else {
            return 0;
        }
    }

    public int factRec(int n) {
        if (n == 0)
            return 1;
        else
            return n * factRec(n - 1);
    }

    public int multRec(int a, int b) {
        if (b == 0)
            return 0;
        else
            return a + multRec(a, b - 1);
    }

    public int potenciaRec(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else {
            return multRec(a, potenciaRec(a, b - 1));
        }
    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public int maximo(int n, int pos) {
        if (pos == n - 1)
            return A[pos];
        else
            return max(A[pos], maximo(n, pos + 1));
    }
}