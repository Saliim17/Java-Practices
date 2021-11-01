import java.util.Scanner;

public class upmbank {

    static String email = "", dni = "", nombre = "", apellidos = "", numeroCuenta = "", day = "",month = "", year = "", datos = "";
    static boolean userChecker = false;
    public static void main(String[] args) {
        int option, option1, option2, dineroIngresado = 0, dineroExtraido = 0, dinero = 0, dineroEnviado = 0, dineroPedido = 0;
        String numeroCuenta = "", registro = "", listaCuentas = "", transacciones = "", cuentaDestino, cuentaOrigen = "";
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        do {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("$                                                                                   $");
            System.out.println("$   /$$   /$$ /$$$$$$$  /$$      /$$       /$$$$$$$   /$$$$$$  /$$   /$$ /$$   /$$  $");
            System.out.println("$  | $$  | $$| $$__  $$| $$$    /$$$      | $$__  $$ /$$__  $$| $$$ | $$| $$  /$$/  $");
            System.out.println("$  | $$  | $$| $$  \\ $$| $$$$  /$$$$      | $$  \\ $$| $$  \\ $$| $$$$| $$| $$ /$$/   $");
            System.out.println("$  | $$  | $$| $$$$$$$/| $$ $$/$$ $$      | $$$$$$$ | $$$$$$$$| $$ $$ $$| $$$$$/    $");
            System.out.println("$  | $$  | $$| $$____/ | $$  $$$| $$      | $$__  $$| $$__  $$| $$  $$$$| $$  $$    $");
            System.out.println("$  | $$  | $$| $$      | $$\\  $ | $$      | $$  \\ $$| $$  | $$| $$\\  $$$| $$\\  $$   $");
            System.out.println("$  |  $$$$$$/| $$      | $$ \\/  | $$      | $$$$$$$/| $$  | $$| $$ \\  $$| $$ \\  $$  $");
            System.out.println("$   \\______/ |__/      |__/     |__/      |_______/ |__/  |__/|__/  \\__/|__/  \\__/  $");
            System.out.println("$                                                                                   $");
            System.out.println("$  Tu banco universitario de confianza.                                             $");
            System.out.println("$  Todos los derechos reservados a Universidad Politécnica de Madrid®               $");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("$                              1. Alta de clientes                                  $");
            System.out.println("$                     2. Creacion de una cuenta bancaria                            $");
            System.out.println("$                        3. Depósitos y extracciones                                $");
            System.out.println("$                             4. Transferencias                                     $");
            System.out.println("$                         5. Préstamos hipotecarios                                 $");
            System.out.println("$                    6. Datos del cliente y cuenta asociada                         $");
            System.out.println("$                               0. Cerrar sesión                                    $");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            option = keyboard.nextInt();
            if (option < 0 || option > 6){
                System.out.print("vuelve a introducir una opción: ");
                option = keyboard.nextInt();
            }

            switch (option) {
                case 0:
                    keyboard.close();
                    keyboard2.close();
                    System.exit(0);

                    break;
                case 1:
                    altaClientes(keyboard);
                    break;
                case 2:
                    numeroCuenta = altaCuentas(keyboard);
                    listaCuentas += "["+numeroCuenta+"]" + "\n";
                    break;
                case 3:
                    do {
                        option1 = depositosYextracciones(keyboard);
                        switch (option1) {
                            case 1:
                                dineroIngresado = ingresarDinero(keyboard);
                                dinero += dineroIngresado;
                                registro += "["+numeroCuenta+"] +" + dineroIngresado + "€\n";
                                System.out.println("Dinero disponible: " + dinero + "€");
                                break;
                            case 2:
                                dineroExtraido = sacarDinero(keyboard);
                                if (dinero < dineroExtraido) {
                                    System.out.println("No hay suficiente saldo");
                                }
                                else {
                                    System.out.println("Ha extraído " + dineroExtraido + "€");
                                    dinero -= dineroExtraido;
                                    registro += "[" + numeroCuenta + "] -" + dineroExtraido + "€\n";
                                    System.out.println("Dinero disponible: " + dinero + "€");
                                }
                                break;
                            case 3:
                                System.out.println(registro);
                                break;
                        }
                    }while(option1 != 0);
                    break;
                case 4:
                    do {
                        option2 = transacciones(keyboard);
                        switch (option2) {
                            case 1:
                                System.out.println("Introduce la cuenta de origen: ");
                                cuentaOrigen = keyboard2.next();
                                System.out.println("Introduce la cuenta de destino: ");
                                cuentaDestino = keyboard.next();
                                dineroEnviado = enviarDinero(keyboard);
                               if (dinero < dineroEnviado) {
                                    System.out.println("No hay suficiente saldo");
                               }
                               else {
                                   transacciones += dineroEnviado + "€ enviados de " + cuentaOrigen + " a " + cuentaDestino + "\n";
                                   dinero -= dineroEnviado;
                                   System.out.println("Dinero disponible: " + dinero + "€");
                               }
                                break;
                            case 2:
                                dineroPedido = pedirDinero(keyboard);
                                System.out.println("Introduce la cuenta de origen: ");
                                cuentaOrigen = keyboard.next();
                                System.out.println("Introduce la cuenta destinatario a solicitar: ");
                                cuentaDestino = keyboard2.nextLine();
                                System.out.println("Enviando solicitud...\nEspera un poco...\nSolicitud confirmada.");
                                dinero += dineroPedido;
                                System.out.println("Dinero disponible: "+dinero+"€");
                                transacciones += "Con cuenta origen: "+cuentaOrigen+", se pide y recibe "+dineroPedido+"€ por "+cuentaDestino+"\n";
                                break;
                            case 3:
                                System.out.println(transacciones);
                                break;
                            case 4:
                                System.out.println(listaCuentas);
                                break;
                        }
                    }while(option2 != 0);
                    break;
                case 5:
                    prestamoHipotecario(keyboard);
                    break;
                case 6:
                    if (!userChecker) System.out.println("No hay ningún usuario creado.");
                    else {
                        System.out.println("Datos del cliente: ");
                        System.out.println("Lista de cuentas: ");
                        System.out.println(listaCuentas);
                        System.out.println(datos);

                    }
                    break;
                default:
                    System.out.println("La opcion introducida no es valida.");
            }
        } while (option != 0);

    }

    public static void altaClientes(Scanner keyboard) {
        System.out.println("Todo  personal  de  la  UPM  podrá  ser  dado  de  alta  en  la  aplicación  como cliente proporcionando los siguientes datos:");
        System.out.print("  - Nombre: ");
        nombre = keyboard.next();
        System.out.print("  - Apellidos: ");
        apellidos = keyboard.next();
        System.out.print("  - Fecha de nacimiento. En formato dd/mm/aaaa: ");
        System.out.print("\n      - Día: ");
        int day = keyboard.nextInt();
        System.out.print("      - Mes: ");
        int month = keyboard.nextInt();
        System.out.print("      - Año: ");
        int year = keyboard.nextInt();
        while (day <= 0 || day > 31 || month <= 0 || month > 12 || year > 2021 || month == 2 && day > 28) {
            System.out.print("Fecha introducida incorrecta, por favor, introduzca una fecha de nacimiento en formato dd/mm/aaaa: ");
            System.out.print("\n      - Día: ");
            day = keyboard.nextInt();
            System.out.print("      - Mes: ");
            month = keyboard.nextInt();
            System.out.print("      - Año: ");
            year = keyboard.nextInt();
        }
        System.out.print("  - DNI: ");
        String dni = keyboard.next();
        System.out.print("  - Correo electrónico: ");
        String email = keyboard.next();

        datos += "- Nombre: "+nombre+"\n- Apellidos: "+apellidos+"\n- Fecha de nacimiento: "+day+"/"+month+"/"+year+"\n- DNI: "+dni+"\n- Correo electrónico: "+email;
        userChecker = true;
    }

    public static String altaCuentas(Scanner keyboard) {
        int CE = 0, CS = 0, NC = 0, DC = 0;
        if (userChecker == false) System.out.println("No hay ningún usuario creado.");
        else {
            System.out.println("Seleccione el tipo de cuenta:");
            System.out.println("  1. Corriente: ");
            System.out.println("  2. Ahorro: ");
            System.out.println("  3. Remunerada: ");
            int option = keyboard.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Ha elegido cuenta corriente.");
                    break;
                case 2:
                    System.out.println("Ha elegido cuenta ahorro.");
                    break;
                case 3:
                    System.out.println("Ha elegido cuenta remunerada.");
                    break;
            }
            int c1 = (11 - ((6 * 0 + 3 * 1 + 7 * 2 + 9 * 0 + 10 * 0 + 5 * 1 + 8 * 0 + 4 * 9) % 11));
            if (c1 == 11) c1 = 0;
            if (c1 == 10) c1 = 1;
            int d1 = (int) (Math.random() * 10);
            int d2 = (int) (Math.random() * 10);
            int d3 = (int) (Math.random() * 10);
            int d4 = (int) (Math.random() * 10);
            int d5 = (int) (Math.random() * 10);
            int d6 = (int) (Math.random() * 10);
            int d7 = (int) (Math.random() * 10);
            int d8 = (int) (Math.random() * 10);
            int d9 = (int) (Math.random() * 10);
            int d10 = (int) (Math.random() * 10);
            int c2 = (11 - ((d1 + 2 * d2 + 4 * d3 + 8 * d4 + 5 * d5 + 10 * d6 + 9 * d7 + 7 * d8 + 3 * d9 + 6 * d10) % 11));
            if (c2 == 11) c2 = 0;
            if (c2 == 10) c2 = 1;
            DC = (c1 * 10) + c2;
            NC = (int) ((d1 * (Math.pow(10, 9))) + (d2 * Math.pow(10, 8)) + (d3 * (Math.pow(10, 7))) + (d4 * Math.pow(10, 6)) + (d5 * (Math.pow(10, 5))) + (d6 * Math.pow(10, 4)) + (d7 * (Math.pow(10, 3))) + (d8 * Math.pow(10, 2)) + d9 * 10 + d10);
            CE = 9010;
            CS = 210;

            System.out.format("Número de cuenta bancaria: %04d %04d %02d %010d", CE, CS, DC, NC);
            int moner = 0;
            System.out.println("\nDinero disponible: " + moner + "€");

        }
        return CE + " " + CS + " " + DC + " " + NC;
    }

    public static int depositosYextracciones(Scanner keyboard) {
        int opcion = 0;
        if (userChecker == false) System.out.println("No hay ningún usuario creado.");
        else {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("$                               1. Ingresar dinero                                  $");
            System.out.println("$                                2. Sacar dinero                                    $");
            System.out.println("$                       3. Registro de depositos/extracciones                       $");
            System.out.println("$                                0. Cerrar sesión                                   $");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            opcion = keyboard.nextInt();
        }
        return opcion;
    }
    public static int ingresarDinero(Scanner keyboard) {
        int dineroIngresado = 0;
        if (userChecker == false) System.out.println("No hay ningún usuario creado.");
        else {
            System.out.print("Introduce el importe a ingresar: ");
            dineroIngresado = keyboard.nextInt();
        }
        return dineroIngresado;
    }
    public static int sacarDinero(Scanner keyboard) {
        int dineroExtraido = 0;
        if (userChecker == false) System.out.println("No hay ningún usuario creado.");
        else {
            System.out.print("Introduce el importe a extraer: ");
            dineroExtraido = keyboard.nextInt();
        }
        return dineroExtraido;
    }

    public static int transacciones (Scanner keyboard) {
        int opcion = 0;
        if (userChecker == false) System.out.println("No hay ningún usuario creado.");
        else {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("$                          1. Enviar dinero a otra cuenta                           $");
            System.out.println("$                           2. Pedir dinero a otra cuenta                           $");
            System.out.println("$                           3. Registro de transacciones                            $");
            System.out.println("$                           4. Lista de cuentas bancarias                           $");
            System.out.println("$                                0. Cerrar sesión                                   $");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            opcion = keyboard.nextInt();
        }
        return opcion;
    }

    public static int enviarDinero (Scanner keyboard) {
        int dineroEnviado = 0;
        if (userChecker == false) System.out.println("No hay ningún usuario creado.");
        else {
            System.out.println("Introduce el importe a enviar: ");
            dineroEnviado = keyboard.nextInt();
        }
        return dineroEnviado;
    }
    public static int pedirDinero (Scanner keyboard) {
        int dineroPedido = 0;
        if (userChecker == false) System.out.println("No hay ningún usuario creado.");
        else {
            System.out.println("Introduce el importe a pedir: ");
            dineroPedido = keyboard.nextInt();
        }
        return dineroPedido;
    }
    public static void prestamoHipotecario(Scanner keyboard) {
        if (userChecker == false) System.out.println("No hay ningún usuario creado.");
        else {
            System.out.print("Introduzca la cantidad  de  dinero  o capital  solicitado,  el  cual  será  depositado  en  la  cuenta  bancaria  del  Cliente al realizar el préstamo: ");
            double C = keyboard.nextFloat();
            System.out.print("Interés  anual  (en  tanto  por  ciento)  que  se  debe  abonar  por  dicho  préstamo: ");
            double interesAnual = keyboard.nextFloat();
            double I = interesAnual / 12;
            System.out.print("Número de años en los que se debe devolver el préstamo: ");
            int años = keyboard.nextInt();
            int n = años * 12;
            double Cuota = (double) (C * I * ((Math.pow((1 + I), n)) / ((Math.pow(1 + I, n)) - 1)));
            double intereses = 0, amortizado = 0;
            System.out.printf("\tPAGO MENSUAL       INTERESES       AMORTIZADO      CAPITAL VIVO\n");
            System.out.printf("\t      0.00            0.00            0.00         %.2f\n", C);
            for (int i = 1; i <= n; i++) {
                intereses = C * I;
                amortizado = Cuota - intereses;
                C -= amortizado;
                System.out.printf("%d\t\t%.2f\t\t\t%.2f\t\t\t%.2f\t\t\t%.2f\n", i, Cuota, intereses, amortizado, C);
            }
        }
    }
}
