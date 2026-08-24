import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int opcion;

        do {

            System.out.println();
            System.out.println("SISTEMA DE ENVÍOS");
            System.out.println("1. Registrar envío nacional");
            System.out.println("2. Registrar envío internacional");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            if (teclado.hasNextInt()) {

                opcion = teclado.nextInt();
                teclado.nextLine();

                if (opcion < 1 || opcion > 3) {
                    System.out.println("Opción no válida.");
                }

            } else {

                System.out.println(
                        "Debe ingresar un número entero.");

                teclado.nextLine();
                opcion = 0;
            }

        } while (opcion != 3);
    }
}