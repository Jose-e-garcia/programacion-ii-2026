import java.util.Scanner;

public class CajeroAutomatico {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Datos iniciales
        String titular = "Jose Ernesto Garcia";
        String numeroCuenta = "3121";
        int pinCorrecto = 2026;

        double saldo = 1000.00;
        double comision = 10.00;

        // Contadores y acumuladores
        int depositosExitosos = 0;
        double totalDepositado = 0.00;

        int retirosExitosos = 0;
        double totalRetirado = 0.00;

        double totalComisiones = 0.00;

        int operacionesRechazadas = 0;
        int opcionesInvalidas = 0;

        // Para validar acceso
        boolean acceso = validarAcceso(teclado, pinCorrecto);

        if (!acceso) {
            System.out.println("Cuenta bloqueada durante esta sesión.");
            return;
        }

        // Menú principal
        int opcion;

        do {
            System.out.println("\n===== CAJERO AUTOMÁTICO =====");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Realizar retiro normal");
            System.out.println("4. Realizar retiro con comisión");
            System.out.println("5. Mostrar resumen de la sesión");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    consultarSaldo(titular, numeroCuenta, saldo);
                    break;

                case 2:
                    System.out.println("Depósito de dinero");
                    break;

                case 3:
                    System.out.println("Retiro normal");
                    break;

                case 4:
                    System.out.println("Retiro con comisión");
                    break;

                case 5:
                    System.out.println("Resumen de la sesión");
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    opcionesInvalidas++;
                    continue;
            }

        } while (opcion != 6);
    }

    // Método para validar el PIN
    public static boolean validarAcceso(Scanner teclado, int pinCorrecto) {

        boolean acceso = false;

        for (int intento = 1; intento <= 3; intento++) {

            System.out.print("Ingrese su PIN: ");
            int pinIngresado = teclado.nextInt();

            if (pinIngresado == pinCorrecto) {
                System.out.println("PIN correcto. Bienvenido.");
                acceso = true;
                break;
            } else {
                int intentosRestantes = 3 - intento;
                System.out.println("PIN incorrecto.");
                System.out.println("Intentos restantes: " + intentosRestantes);
            }
        }

        return acceso;
    }
    // Método para consultar el saldo
    public static void consultarSaldo(String titular, String numeroCuenta, double saldo) {

        System.out.println("\n===== CONSULTA DE SALDO =====");
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo disponible: Q" + saldo);
    }
}