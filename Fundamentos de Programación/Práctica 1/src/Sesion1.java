import java.util.Scanner;

public class Sesion1 {
    public static void main (String [] args) {
        System.out.println("1. Comprobar si un número es primo.\n2. Escribir los n primeros números primos.\n3. Escribir números primos gemelos entre dos valores.\n4. Número par como suma de dos primos.\n0. Finalizar la ejecución.");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Introduzca la opción deseada: ");
        int option = keyboard.nextInt();
        while(option < 0 || option > 4) {
            System.out.print("Opción incorrecta, por favor, introduzca de nuevo la opción deseada: ");
            option = keyboard.nextInt();
        }
        System.out.println("Ha elegido la opción "+option);
        System.out.print("Introduzca un número mayor que cero y menor que 1000: ");
        int num = keyboard.nextInt();
        while ((num <= 0) || (num >= 1000)) {
            if(num <= 0) System.out.print("El número es menor o igual a 0, por favor, introduzca un número mayor que cero y menor que 1000: ");
            else System.out.print("El número es mayor o igual a 1000, por favor, introduzca un número mayor que cero y menor que 1000: ");
            num = keyboard.nextInt();
        }
        System.out.println("El número es "+num);
        System.out.print("Introduzca dos números enteros: ");
        int num1 = keyboard.nextInt();
        int num2 = keyboard.nextInt();
        while ((num1 >= num2) || (num2 % num1 != 0)) {
            if (num1 >= num2) System.out.println("El primer número es mayor o igual que el segundo.");
            else System.out.println("El segundo número no es divisible entre el primero.");
            System.out.print("Vuelva a introducir dos números enteros: ");
            num1 = keyboard.nextInt();
            num2 = keyboard.nextInt();
        }
        System.out.println("El número "+num1+" es menor o igual que "+num2+" y "+num2+" es divisible entre "+num1);
        keyboard.close();
    }
}
