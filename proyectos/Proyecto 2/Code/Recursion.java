// Se requiere escribir 4 funciones que resuelvan problemas en forma recursiva. Las 4 funcione son:

// • Dado un string, regresar el string “limpio”, lo que significa que si hay caracteres adyacentes iguales, sólo deja uno de ellos.
// • Por ejemplo, “aabbbbcccccdd”, debe regresar “abcd”.

// • Contar el número de veces que un substring dado aparece en un string.
// • e.g. “ab” en el string “abbaaabba”, debe regresar un 2.

// • Dado un entero no negativo, regresar la suma de sus dígitos.
// • e.g. “12345” debe regresar 15.

// • Dado un string formado por paréntesis anidados, regresar TRUE si están anidados correctamente o FALSE en caso contrario.
// • e.g. “(())” regresa TRUE, “((())” regresa FALSE.

public class Recursion {

    public static void main(String[] args) {
        Recursion obj = new Recursion();

        // 1
        // String str = "aabbbbcccccdd";
        // String limpio = obj.limpiaString(str);
        // System.out.println(limpio);

        // 2
        // String str = "abbaababbbababba";
        // String subStr = "ab";
        // int cuenta = obj.cuentaSubstring(str, subStr);
        // System.out.println(cuenta);

        // 3
        // int n = 12345;
        // int sumaDigitos = obj.sumaDigitos(n);
        // System.out.println(sumaDigitos);

        // 4
        // String str = "(())()()";
        // boolean anidacionCorrecta = obj.anidacionCorrecta(str);
        // System.out.println(anidacionCorrecta);
    }

    // recibe un string y regresa el string “limpio”
    // wrapper
    String limpiaString(String s) {
        return rLimpiaString(s, s.length(), 0, "");
    }

    // funcion recursiva
    String rLimpiaString(String s, int n, int pos, String a) {
        if (pos == n) {
            return a;
        } else if (pos == 0) {
            return rLimpiaString(s, n, pos + 1, String.valueOf(s.charAt(pos)));
        } else {
            if (s.charAt(pos) == a.charAt(a.length() - 1)) {
                return rLimpiaString(s, n, pos + 1, a);
            } else {
                return rLimpiaString(s, n, pos + 1, a + s.charAt(pos));
            }
        }
    }

    // recibe un string s y un substring sub y regresa el número de veces que
    // aparece el substring en el string.
    // wrapper
    int cuentaSubstring(String s, String sub) {
        return rCuentaSubstring(s, s.length(), sub, sub.length(), 0, 0);
    }

    // funcion recursiva
    int rCuentaSubstring(String s, int n, String sub, int nSub, int pos, int a) {
        if (pos == n + 1 - nSub){
            return a;
        } else {
            return rCuentaSubstring(s, n, sub, nSub, pos+1, a + sameStr(s.substring(pos, pos + nSub), sub));
        }
    }

    // funcion auxiliar para evaluar si el string es igual y regresar un valor numérico
    int sameStr(String s1, String s2){
        return ((s1.equals(s2)) ? 1 : 0);
    }

    // recibe un entero n y regresa la suma de sus dígitos
    // wrapper
    int sumaDigitos(int n){
        String nStr = String.valueOf(n);
        return rSumaDigitos(nStr, nStr.length(), 0, 0);
    }

    // funcion recursiva
    int rSumaDigitos(String n, int len, int pos, int a){
        if(pos == len){
            return a;
        } else {
            return rSumaDigitos(n, len, pos + 1, a + Integer.valueOf(String.valueOf(n.charAt(pos))));
        }
    }

    // recibe un string s formado con paréntesis anidados y regresa true si los
    // paréntesis están correctamente anidados y false si no lo están.
    // wrapper
    boolean anidacionCorrecta(String s){
        int len = s.length();
        // verifica que el número de caracteres sea par
        if (len % 2 != 0) {
            return false;
        }
        return rAnidacionCorrecta(s, len, 0, 0, 0, true);
    }

    // funcion recursiva
    boolean rAnidacionCorrecta(String s, int len, int pos, int abiertos, int cerrados, boolean a){
        if(pos == len){
            return a;
        } else {
            if (s.charAt(pos) == '(') {
                return rAnidacionCorrecta(s,len, pos + 1, abiertos + 1, cerrados, abiertos + 1 == cerrados);
            }
            return rAnidacionCorrecta(s,len ,pos + 1, abiertos, cerrados + 1, abiertos == cerrados + 1);
        }
    }
}
