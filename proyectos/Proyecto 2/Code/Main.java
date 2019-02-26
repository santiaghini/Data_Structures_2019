public class Main {
    public static void main(String[] args) {
        Recursion obj = new Recursion();

        // 1
        String str = "aabbbbcccccdd";
        System.out.println("El string a limpiar es: " + str);
        String limpio = obj.limpiaString(str);
        System.out.println("El string limpio es: " + limpio);

        // 2
        String str = "abbaababbbababba";
        String subStr = "ab";
        System.out.println("El string es: " + str);
        System.out.println("El substring es: " + subStr);
        int cuenta = obj.cuentaSubstring(str, subStr);
        System.out.println("El string " + subStr + " aparece " + cuenta + " veces");

        // 3
        int n = 12345;
        int sumaDigitos = obj.sumaDigitos(n);
        System.out.println("La suma de los dígitos de " + n + " es " + sumaDigitos);

        // 4
        String str = "(())()()";
        boolean anidacionCorrecta = obj.anidacionCorrecta(str);
        System.out.println("El string anidado '" + str + "' está "
                + (anidacionCorrecta ? "correctamente" : "incorrectamente") + " anidado");
    }
}