import java.util.Scanner;

public class Sesion4 {
    public static void main(String[] args) {
        int option, num, p, q, base, exponente;
        double resultado;
        boolean prime;
        Sesion3 sesion3 = new Sesion3();
        Scanner keyboard = new Scanner(System.in);
        option = menu(keyboard);
        do {
            switch (option) {
                case 0:
                    System.out.println("Adiós.");
                    keyboard.close();
                    break;
                case 1:
                    System.out.print("Introduce un número: ");
                    num = keyboard.nextInt();
                    prime = sesion3.esPrimo(num, keyboard);
                    if (prime) System.out.println("El número " + num + " es primo.");
                    else System.out.println("El número " + num + " no es primo.");
                    option = menu(keyboard);
                    break;
                case 2:
                    System.out.print("Introduce un número entre 5 y 20: ");
                    num = keyboard.nextInt();
                    Sesion3.escribePrimos(num, keyboard);
                    System.out.println();
                    option = menu(keyboard);
                    break;
                case 3:
                    System.out.println("Primer valor: ");
                    p = keyboard.nextInt();
                    System.out.println("Segundo valor: ");
                    q = keyboard.nextInt();
                    primosGemelos(p, q, keyboard);
                    option = menu(keyboard);
                    break;
                case 4:
                    System.out.print("Introduce un número par: ");
                    num = keyboard.nextInt();
                    mostrarSumasDePrimos(num, keyboard);
                    option = menu(keyboard);
                    break;
                case 5:
                    System.out.print("Introduce un número: ");
                    num = keyboard.nextInt();
                    while (num < 1 || num > 1000) {
                        System.out.print("El número debe estar comprendido entre 1 y 1000: ");
                        num = keyboard.nextInt();
                    }
                    prime = esPrimoRecursivo(num);
                    if (prime) System.out.println("El número " + num + " es primo.");
                    else System.out.println("El número " + num + " no es primo.");
                    option = menu(keyboard);
                    break;
                case 6:
                    System.out.print("Introduce la base: ");
                    base = keyboard.nextInt();
                    System.out.print("Introduce el exponente: ");
                    exponente = keyboard.nextInt();
                    while (base < -100 || base > 100 || exponente < 0 || exponente > 10) {
                        if (base < -100 || base > 100) {
                            System.out.print("La base tiene que estar comprendido entre -100 y 100: ");
                            base = keyboard.nextInt();
                        }
                        else {
                            System.out.print("El exponente tiene que estar comprendido entre 0 y 10: ");
                            exponente = keyboard.nextInt();
                        }
                    }
                    resultado = potencia(base, exponente);
                    System.out.println(resultado);
                    option = menu(keyboard);
                    break;
                default:
                    System.out.println("Opción incorrecta, vuelva a introducir una opción válida.");
                    option = menu(keyboard);
            }
        } while (option != 0);
    }

    public static int menu(Scanner keyboard) {
        int option;
        System.out.println("1. Comprobar si un número es primo.\n2. Escribir los n primeros números primos.\n3. Escribir números primos gemelos entre dos valores.\n4. Número par como suma de dos primos.\n5. Comprobar si un número es primo recursivamente.\n6. Calcular potencias recursivamente.\n0. Finalizar ejecución.");
        System.out.print("Introduzca la opción deseada: ");
        option = keyboard.nextInt();
        while (option < 0 || option > 6) {
            System.out.println("Opción incorrecta, vuelve a introducir una opción valida: ");
            option = keyboard.nextInt();
        }
        return option;
    }

    public static void primosGemelos(int p, int q, Scanner keyboard) {
        while (p < 1 || p > 500 || q < 1 || q > 500) {
            if (p < 1) System.out.println("El número " + p + " es menor que 1.");
            else if (p > 500) System.out.println("El número " + p + " es mayor que 500.");
            else if (q < 1) System.out.println("El número " + q + " es menor que 1.");
            else System.out.println("El número " + q + " es mayor que 500.");
            System.out.println("Introduce dos números enteros comprendidos entre 1 y 500: ");
            System.out.print("Primer número: ");
            p = keyboard.nextInt();
            System.out.print("Segundo número: ");
            q = keyboard.nextInt();
        }
        int j, contPrimosGemelos = 1, primerGemelo = 0, segundoGemelo;
        boolean encontradoPrimerGemelo = false;
        if (p > q) {
            while (q <= p) {
                boolean primo = true;
                q++;
                j = q - 1;
                while (j > 1 && primo) {
                    if (q % j == 0) primo = false;
                    j--;
                }
                if (primo) {
                    if (!encontradoPrimerGemelo) {
                        primerGemelo = q;
                        encontradoPrimerGemelo = true;
                    } else {
                        segundoGemelo = q;
                        if (segundoGemelo == primerGemelo + 2) {
                            System.out.printf("%8d. %8d %8d\n", contPrimosGemelos, primerGemelo, segundoGemelo);
                            contPrimosGemelos++;
                            encontradoPrimerGemelo = false;
                        } else primerGemelo = q;
                    }
                }
            }
        } else {
            while (p <= q) {
                boolean primo = true;
                j = p - 1;
                while (j > 1 && primo) {
                    if (p % j == 0) primo = false;
                    j--;
                }
                if (primo) {
                    if (!encontradoPrimerGemelo) {
                        primerGemelo = p;
                        encontradoPrimerGemelo = true;
                    } else {
                        segundoGemelo = p;
                        if (segundoGemelo == primerGemelo + 2) {
                            System.out.printf("%8d. %8d %8d\n", contPrimosGemelos, primerGemelo, segundoGemelo);
                            contPrimosGemelos++;
                            encontradoPrimerGemelo = false;
                        } else primerGemelo = p;
                    }
                }
                p++;
            }
        }
    }

    public static boolean esPar(int num) {
        if (num % 2 != 0) return false;
        else return true;
    }

    public static void mostrarSumasDePrimos(int n, Scanner keyboard) {
        while (n < 4 || n > 1000 || esPar(n) == false) {
            System.out.println("El número debe ser par y debe estar comprendido entre 4 y 1000: ");
            n = keyboard.nextInt();
        }
        int numero = 1, numeroSuma, encontrado = 0;
        while (numero < n) {
            boolean primo = true, esPrimo;
            numero++;
            int i = numero - 1;
            while (i > 1 && primo) {
                if (numero % i == 0) primo = false;
                i--;
            }
            if (primo) {
                numeroSuma = n - numero;
                esPrimo = Sesion3.esPrimo(numeroSuma, keyboard);
                if (esPrimo && numero < numeroSuma) {
                    encontrado++;
                    System.out.printf("%8d. %4d+%d = %d\n", encontrado, numero, numeroSuma, n);
                }
            }
        }
    }

    public static boolean esPrimoRecursivo(int num) {
        return (num >= 2) && esPrimoRec(num, (int) (Math.sqrt(num) + 1));
    }

    public static boolean esPrimoRec(int num, int i) {

        if (num == 2)
            return true;

        if(i <= 1)
            return true;

        if(num % i == 0)
            return false;

        return esPrimoRec(num, i - 1);
    }

    /*
    funcion esPrimoRecursivo (int num) {
        return (siempre que sea mayor o igual que 2) y esPrimoRec(num, divisor - 1)
    }
    funcion esPrimoRec (int numero, int divisor) {
        si el numero es 2
            return true //siempre el dos es primo
        si el divisor es menor o igual que 1
            return true //siempre que el divisor solo sea 1, por ejemplo en 11, 11 es primo solo tiene de divisores a 1 y 11
        si el numero % divisor da 0 
            return false //tiene un divisor y no es primo
        return esPrimoRec(numero y divisor - 1)
    }
    */

    public static double potencia(int base, int exponente) {
        /*
        - potencia (2,5) = 2 * (2 * (2 * (2 * (2 * 1)))) = 2 * 16 = 32
          2 * potencia (2,4) = 2 * (2 * (2 * (2 * 1))) = 2 * 8 = 16
              2 * potencia (2*3) = 2 * (2 * (2 * 1)) = 2 * 4 = 8
                  2 * potencia (2*2) = 2 * (2 * 1) = 2 * 2 = 4
                      2 * potencia (2*1) = 2 * 1 = 2
                          2 * potencia (2*0) = 1
        */
        if (exponente == 0) {
            return 1;
        } else if (exponente < 0) {
            return potencia(base, exponente + 1) / base;
        } else {
            return base * potencia(base, exponente - 1);
        }
    }
}
