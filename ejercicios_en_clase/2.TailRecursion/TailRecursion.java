public class TailRecursion {
    int[] A = { 1, 9, 11, 4, 5 };

    public static void main(String[] args) {
        TailRecursion obj = new TailRecursion();
        // System.out.println(obj.factTail(3, 1));
        // System.out.println(obj.multFactTail(2, 7, 0));
        System.out.println(obj.maximoTail(obj.A.length, 0, obj.A[0]));
    }

    public int maximoTail(int n, int pos, int a) {
        if (pos == n)
            return a;
        else
            return maximoTail(n, pos + 1, max(A[pos], a));
    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public int factTail(int n, int a) {
        if (n == 0) {
            return a;
        } else {
            return factTail(n - 1, n * a);
        }
    }

    public int multFactTail(int x, int y, int a) {
        if (y == 0) {
            return a;
        } else {
            return multFactTail(x, y - 1, x + a);
        }
    }

}