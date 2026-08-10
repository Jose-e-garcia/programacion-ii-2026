import java.util.Scanner;

public class CajeroAutomatico {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Datos iniciales
        String titular = "Jose Ernesto Garcia";
        String numeroCuenta = "3121";
        int pinCorrecto = 2026;

        double saldoInicial = 1000.00;
        double saldo = saldoInicial;
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
                    double saldoAnterior = saldo;
                    saldo = procesarDeposito(teclado, saldo);

                    if (saldo != saldoAnterior) {
                        depositosExitosos++;
                        totalDepositado = totalDepositado + (saldo - saldoAnterior);
                    }
                    break;
                case 3:
                    double saldoAnteriorRetiro = saldo;
                    saldo = procesarRetiro(teclado, saldo);

                    if (saldo != saldoAnteriorRetiro) {
                        retirosExitosos++;
                        totalRetirado = totalRetirado + (saldoAnteriorRetiro - saldo);
                    } else {
                        operacionesRechazadas++;
                    }
                    break;

                case 4:
                    double saldoAnteriorComision = saldo;
                    saldo = procesarRetiro(teclado, saldo, comision);

                    if (saldo != saldoAnteriorComision) {
                        retirosExitosos++;
                        totalRetirado = totalRetirado + (saldoAnteriorComision - saldo - comision);
                        totalComisiones = totalComisiones + comision;
                    } else {
                        operacionesRechazadas++;
                    }
                    break;

                case 5:
                    mostrarResumen(titular, numeroCuenta, saldoInicial, saldo,
                            depositosExitosos, totalDepositado, retirosExitosos,
                            totalRetirado, totalComisiones, operacionesRechazadas,
                            opcionesInvalidas);
                    break;

                case 6:
                    mostrarResumen(titular, numeroCuenta, saldoInicial, saldo,
                            depositosExitosos, totalDepositado, retirosExitosos,
                            totalRetirado, totalComisiones, operacionesRechazadas,
                            opcionesInvalidas);

                    System.out.println("\nGracias por utilizar el cajero automático.");
                    System.out.println("¡Hasta pronto!");
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

    // Método para procesar un depósito
    public static double procesarDeposito(Scanner teclado, double saldo) {

        double monto;

        System.out.print("\nIngrese el monto a depositar: Q");
        monto = teclado.nextDouble();

        while (monto <= 0 || monto > 5000) {

            if (monto <= 0) {
                System.out.println("Error: el monto debe ser mayor que Q0.00.");
            } else {
                System.out.println("Error: el monto no puede superar Q5000.00.");
            }

            System.out.print("Ingrese nuevamente el monto: Q");
            monto = teclado.nextDouble();
        }

        double saldoAnterior = saldo;

        saldo = saldo + monto;

        System.out.println("\n===== DEPÓSITO REALIZADO =====");
        System.out.println("Monto depositado: Q" + monto);
        System.out.println("Saldo anterior: Q" + saldoAnterior);
        System.out.println("Saldo actualizado: Q" + saldo);

        return saldo;
    }

    // Método para procesar un retiro normal
    public static double procesarRetiro(Scanner teclado, double saldo) {

        double monto;

        System.out.print("\nIngrese el monto a retirar: Q");
        monto = teclado.nextDouble();

        if (monto <= 0) {
            System.out.println("Retiro rechazado: el monto debe ser mayor que Q0.00.");
            return saldo;
        }

        if (monto % 20 != 0) {
            System.out.println("Retiro rechazado: el monto debe ser múltiplo de Q20.00.");
            return saldo;
        }

        if (monto > 2000) {
            System.out.println("Retiro rechazado: el monto no puede superar Q2000.00.");
            return saldo;
        }

        if (monto > saldo) {
            System.out.println("Retiro rechazado: fondos insuficientes.");
            return saldo;
        }

        double saldoAnterior = saldo;

        saldo = saldo - monto;

        System.out.println("\n===== RETIRO REALIZADO =====");
        System.out.println("Monto solicitado: Q" + monto);
        System.out.println("Saldo anterior: Q" + saldoAnterior);
        System.out.println("Total debitado: Q" + monto);
        System.out.println("Saldo actualizado: Q" + saldo);

        return saldo;
    }

    // Método para procesar un retiro con comisión
    public static double procesarRetiro(Scanner teclado, double saldo, double comision) {

        double monto;

        System.out.print("\nIngrese el monto a retirar: Q");
        monto = teclado.nextDouble();

        if (monto <= 0) {
            System.out.println("Retiro rechazado: el monto debe ser mayor que Q0.00.");
            return saldo;
        }

        if (monto % 20 != 0) {
            System.out.println("Retiro rechazado: el monto debe ser múltiplo de Q20.00.");
            return saldo;
        }

        if (monto > 2000) {
            System.out.println("Retiro rechazado: el monto no puede superar Q2000.00.");
            return saldo;
        }

        double totalDebitado = monto + comision;

        if (totalDebitado > saldo) {
            System.out.println("Retiro rechazado: el saldo no cubre el monto más la comisión.");
            return saldo;
        }

        double saldoAnterior = saldo;

        saldo = saldo - totalDebitado;

        System.out.println("\n===== RETIRO CON COMISIÓN =====");
        System.out.println("Monto solicitado: Q" + monto);
        System.out.println("Comisión: Q" + comision);
        System.out.println("Total debitado: Q" + totalDebitado);
        System.out.println("Saldo anterior: Q" + saldoAnterior);
        System.out.println("Saldo actualizado: Q" + saldo);

        return saldo;
    }

    // Método para mostrar el resumen de la sesión
    public static void mostrarResumen(String titular, String numeroCuenta,
                                      double saldoInicial, double saldo,
                                      int depositosExitosos,
                                      double totalDepositado, int retirosExitosos,
                                      double totalRetirado, double totalComisiones,
                                      int operacionesRechazadas, int opcionesInvalidas) {

        System.out.println("\n===== RESUMEN DE LA SESIÓN =====");
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo inicial: Q" + saldoInicial);
        System.out.println("Depósitos exitosos: " + depositosExitosos);
        System.out.println("Total depositado: Q" + totalDepositado);
        System.out.println("Retiros exitosos: " + retirosExitosos);
        System.out.println("Total entregado en retiros: Q" + totalRetirado);
        System.out.println("Total cobrado en comisiones: Q" + totalComisiones);
        System.out.println("Operaciones rechazadas: " + operacionesRechazadas);
        System.out.println("Opciones inválidas: " + opcionesInvalidas);
        System.out.println("Saldo actual: Q" + saldo);
    }
}