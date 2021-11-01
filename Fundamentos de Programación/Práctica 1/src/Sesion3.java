import java.util.Scanner;

public class Sesion3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int num;
        int option = menu(keyboard);
        do {

            switch (option) {
                case 0:
                    System.out.println("Adiós.");
                    keyboard.close();
                    break;
                case 1:
                    System.out.println("El primer número debe ser menor que el segundo.");
                    System.out.print("Primer número: ");
                    int n1 = keyboard.nextInt();
                    System.out.print("Segundo número: ");
                    int n2 = keyboard.nextInt();
                    num = leerNumero(n1, n2, keyboard);
                    if (n1 < n2) System.out.println("El número "+num+" está comprendido entre "+n1+" y "+n2+".");
                    option = menu(keyboard);
                    break;
                case 2:
                    System.out.print("Introduce un número mayor que 0 y menor que 1000: ");
                    num = keyboard.nextInt();
                    boolean primo = esPrimo(num, keyboard);
                    if (primo) System.out.println("El número "+num+" es primo.");
                    else System.out.println("El número "+num+" no es primo.");
                    option = menu(keyboard);
                    break;
                case 3:
                    System.out.print("Introduce un número entre 5 y 20: ");
                    num = keyboard.nextInt();
                    escribePrimos(num, keyboard);
                    option = menu(keyboard);
                    break;
                default:
                    System.out.println("La opción es invalida, vuelve a introducir un número.");
                    option = menu(keyboard);
            }
        }while(option != 0);
    }

    public static int menu(Scanner keyboard) {
        System.out.println("\n1. Introduce un número comprendido entre dos valores.\n2. Comprobar si el número comprendido entre 0 y 1000 introducido es primo.\n3. Escribe los n primeros números primos.\n0. Finalizar la ejecución.");
        System.out.print("Introduzca la opción deseada: ");
        int option = keyboard.nextInt();
        while (option < 0 || option > 4) {
            System.out.print("Opción incorrecta, por favor, introduzca de nuevo la opción deseada: ");
            option = keyboard.nextInt();
        }
        return option;
    }

    public static int leerNumero(int n1, int n2, Scanner keyboard) {
        int num = 0;
        if (n1 >= n2) {
            System.out.println("El número " + n1 + " es mayor o igual a " + n2);
        } else {
            System.out.print("Introduzca un número comprendido entre " + n1 + " y " + n2 + ": ");
            num = keyboard.nextInt();
            while (num < n1 || num > n2) {
                if (num < n1)
                    System.out.print("El número " + num + " es menor que " + n1 + " por favor, introduzca un número comprendido entre " + n1 + " y " + n2 + ": ");
                else
                    System.out.print("El número " + num + " es mayor que " + n2 + " por favor, introduzca un número comprendido entre " + n1 + " y " + n2 + ": ");
                num = keyboard.nextInt();
            }
        }
        return num;
    }

    public static boolean esPrimo(int num, Scanner keyboard) {
        while (num <= 0 || num >= 1000) {
            if (num <= 0) System.out.print("El número es menor o igual a 0, por favor, introduzca un número mayor que cero y menor que 1000: ");
            else System.out.print("El número es mayor o igual a 1000, por favor, introduzca un número mayor que cero y menor que 1000: ");
            num = keyboard.nextInt();
        }
        int i = 2;
        while (i <= num / 2) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void escribePrimos (int n, Scanner keyboard) {
        int contPrimos = 0, numPrint = 0, numero = 1, j;
        while (n < 1 || n > 20) {
            if (n < 5) System.out.println("El número es menor que 5 , por favor, introduzca un número entero comprendido entre 5 y 20: ");
            else System.out.println("El número es mayor que 20, por favor, introduzca un número entero comprendido entre 5 y 20: ");
            n = keyboard.nextInt();
        }
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
    }
}