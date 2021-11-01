import java.util.Scanner;

public class Sesion2 {
    public static void main (String [] args) {
        System.out.print("Introduzca un número entero mayor que cero y menor que 1000: ");
        Scanner keyboard = new Scanner(System.in);
        int num = keyboard.nextInt();
        while ((num <= 0) || (num >= 1000)) {
            if (num <= 0) System.out.print("El número es menor o igual que cero, por favor, introduzca un número entero mayor que cero y menor que 1000: ");
            else System.out.print("El número es mayor o igual que 1000, por favor, introduzca un número entero mayor que cero y menor que 1000: ");
            num = keyboard.nextInt();
        }
        /*
        1.  Inicialiamos el booleano "prime" a true.
        2.  Iteramos desde el número 2(*) hasta el numero introducido/2, es decir, iteramos hasta sus divisores.
            2.1.  Si el número entre el número iterado da de módulo 0, significa que tiene al menos un divisor diferente al propio numero y 1, por lo tanto es compuesto, cambiando el booleano prime a false.
            (*) = no iteramos desde 1 porque para que sea compuesto tiene que tener divisores diferentes de 1 y el mismo número.
        3.  Si la condición no se cumple, mantendrá el booleano de prime en true.
        4.  Asignamos para condición booleana una frase que se mostrará por pantalla el número y la confirmación de si es primo o no.
         */
        boolean prime = true;
        int i = 2;
        while (i <= num / 2 && prime) {
            if (num % i == 0) {
                prime = false;
            }
            i++;
        }
        if (prime) System.out.println(num + " es un número primo.");
        else System.out.println(num + " no es un número primo.");

        System.out.print("Introduzca un número entero comprendido entre 5 y 20: ");
        int n = keyboard.nextInt();
        while ((n < 5) || (n > 20)) {
            if (n < 5) System.out.println("El número es menor que 5 , por favor, introduzca un número entero comprendido entre 5 y 20: ");
            else System.out.println("El número es mayor que 20, por favor, introduzca un número entero comprendido entre 5 y 20: ");
            n = keyboard.nextInt();
        }
        /*
        1. Inicializamos las variables contPrimos, numPrint y numero.
            1.1 La variable contPrimos es un contador de primos.
            1.2 La variable numPrint cuenta las veces que un primo ha sido impreso en pantalla.
            1.3 La variable numero sirve para recorrer número a número.
                1.3.1 Se inicializa en 1 para que en el programa itere de 1 en 1, empezando en 2, ya que el número no se considera como primo.
        2.  El programa se ejecutará las n veces que el usuario a introducido en teclado. (Línea)
        3.  Incrementamos numero (numero = 2) e inicializamos el booleano primo a true;
        4.  Iteramos todos los números menores que la variable numero para encontrar un numero que sea divisor, siempre que siga siendo primo.(*)
            4.1 Ejemplo: numero = 4, itera i = 4 - 1 = 3, donde i > 1 y primo = true. 4 % 3 == 1, entonces vuelve a iterar (i--) con i = 2, donde
                sigue siendo i > 1 y primo = true. 4 % 2 == 0, entonces primo = false y sale de la iteración incrementando el número (numero++).
        5.  Si un número itera todos sus divisores y sigue manteniendo primo = true, al salir de la iteración (gracias a la condición de que debe ser
            i > 1), se incrementa en 1 el contador de primos (contPrimos++) y entrará en la condición de primo = true, donde si todavía no ha impreso
            4 primos (numPrint < 4), imprime el numero primo e incrementa en 1 numPrint. Si numPrint es mayor que 4, imprimirá un salto de linea y
            luego el numero primo, reiniciando el valor de numPrint en 1.
         */
        int contPrimos = 0, numPrint = 0, numero = 1, j;
        while (contPrimos < n) {
            boolean primo = true;
            numero++;
            j = numero - 1;
            while (j > 1 && primo) {
                if (numero % j == 0) primo = false;
                j--;
            }
            if (primo) {
                contPrimos++;
                if (numPrint < 4) {
                    System.out.format("%8d", numero);
                    numPrint++;
                } else {
                    System.out.format("\n%8d", numero);
                    numPrint = 1;
                }
            }
        }
        keyboard.close();
    }
}

