import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int opcion;
        String continuar;

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

            switch (opcion) {

                case 1: {
                    System.out.println("ENVÍO NACIONAL");

                    String codigo;
                    String destinatario;
                    double pesoKg;
                    String departamento;
                    double distanciaKm;

                    do {
                        System.out.print("Ingrese el código del envío: ");
                        codigo = teclado.nextLine();

                        if (codigo.isEmpty()) {
                            System.out.println("El código no puede estar vacío.");
                        }

                    } while (codigo.isEmpty());

                    do {
                        System.out.print("Ingrese el nombre del destinatario: ");
                        destinatario = teclado.nextLine();

                        if (destinatario.isEmpty()) {
                            System.out.println(
                                    "El destinatario no puede estar vacío.");
                        }

                    } while (destinatario.isEmpty());

                    do {

                        System.out.print("Ingrese el peso en kg: ");

                        if (teclado.hasNextDouble()) {
                            pesoKg = teclado.nextDouble();
                            teclado.nextLine();

                            if (pesoKg <= 0) {
                                System.out.println(
                                        "El peso debe ser mayor que cero.");
                            }

                        } else {
                            System.out.println(
                                    "Debe ingresar un número válido.");
                            teclado.nextLine();
                            pesoKg = 0;
                        }

                    } while (pesoKg <= 0);

                    do {
                        System.out.print("Ingrese el departamento de destino: ");
                        departamento = teclado.nextLine();

                        if (departamento.isEmpty()) {
                            System.out.println(
                                    "El departamento no puede estar vacío.");
                        }

                    } while (departamento.isEmpty());

                    do {

                        System.out.print("Ingrese la distancia en km: ");

                        if (teclado.hasNextDouble()) {
                            distanciaKm = teclado.nextDouble();
                            teclado.nextLine();

                            if (distanciaKm <= 0) {
                                System.out.println(
                                        "La distancia debe ser mayor que cero.");
                            }

                        } else {
                            System.out.println(
                                    "Debe ingresar un número válido.");
                            teclado.nextLine();
                            distanciaKm = 0;
                        }

                    } while (distanciaKm <= 0);

                    Envio envio = new EnvioNacional(
                            codigo,
                            destinatario,
                            pesoKg,
                            departamento,
                            distanciaKm);

                    envio.mostrarResumen(true);

                    System.out.print("¿Desea registrar otro envío? (s/n): ");
                    continuar = teclado.nextLine();

                    if (continuar.equalsIgnoreCase("n")) {
                        opcion = 3;
                    }

                    break;
                }

                case 2: {
                    System.out.println("ENVÍO INTERNACIONAL");

                    String codigo;
                    String destinatario;
                    double pesoKg;
                    String paisDestino;

                    do {
                        System.out.print("Ingrese el código del envío: ");
                        codigo = teclado.nextLine();

                        if (codigo.isEmpty()) {
                            System.out.println("El código no puede estar vacío.");
                        }

                    } while (codigo.isEmpty());

                    do {
                        System.out.print("Ingrese el nombre del destinatario: ");
                        destinatario = teclado.nextLine();

                        if (destinatario.isEmpty()) {
                            System.out.println(
                                    "El destinatario no puede estar vacío.");
                        }

                    } while (destinatario.isEmpty());

                    do {

                        System.out.print("Ingrese el peso en kg: ");

                        if (teclado.hasNextDouble()) {
                            pesoKg = teclado.nextDouble();
                            teclado.nextLine();

                            if (pesoKg <= 0) {
                                System.out.println(
                                        "El peso debe ser mayor que cero.");
                            }

                        } else {
                            System.out.println(
                                    "Debe ingresar un número válido.");
                            teclado.nextLine();
                            pesoKg = 0;
                        }

                    } while (pesoKg <= 0);

                    do {
                        System.out.print("Ingrese el país de destino: ");
                        paisDestino = teclado.nextLine();

                        if (paisDestino.isEmpty()) {
                            System.out.println(
                                    "El país no puede estar vacío.");
                        }

                    } while (paisDestino.isEmpty());

                    Envio envio = new EnvioInternacional(
                            codigo,
                            destinatario,
                            pesoKg,
                            paisDestino);

                    envio.mostrarResumen(true);

                    System.out.print("¿Desea registrar otro envío? (s/n): ");
                    continuar = teclado.nextLine();

                    if (continuar.equalsIgnoreCase("n")) {
                        opcion = 3;
                    }

                    break;
                }

                case 3:
                    System.out.println("Programa finalizado.");
                    break;
            }

        } while (opcion != 3);
    }
}