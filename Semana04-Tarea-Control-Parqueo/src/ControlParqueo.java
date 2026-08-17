import java.util.Scanner;

public class ControlParqueo {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Nombre: José Ernesto García");
        System.out.println("Carnet: 9941-10-13121");
        System.out.println("=================================");

        Scanner teclado = new Scanner(System.in);

        int cantidadVehiculos;

        // Cantidad de vehículos
        do {
            System.out.print("Ingrese la cantidad de vehículos: ");
            cantidadVehiculos = teclado.nextInt();
        } while (cantidadVehiculos <= 0);

        // Contadores
        int cantidadMotocicletas = 0;
        int cantidadAutomoviles = 0;
        int cantidadPickups = 0;
        int cantidadTicketsPerdidos = 0;

        // Acumulador
        double totalRecaudado = 0.00;

        // Pago más alto
        double pagoMasAlto = 0.00;
        String placaPagoMasAlto = "";


        // Registro de vehículos
        for (int i = 1; i <= cantidadVehiculos; i++) {

            System.out.println("\n--- Vehículo " + i + " ---");

            String placa;
            int tipoVehiculo;
            // Agregamos el nombre del tipo de vehiculo
            String nombreVehiculo;
            int horas;
            String ticketPerdido;

            double tarifa;
            double subtotal;
            double descuento;
            double recargo;
            double total;

            // Placa
            System.out.print("Ingrese el número de placa: ");
            placa = teclado.next();

            // Tipo de vehículo
            do {
                System.out.print("Ingrese el tipo de vehículo (1-Motocicleta, 2-Automóvil, 3-Pickup): ");
                tipoVehiculo = teclado.nextInt();
            } while (tipoVehiculo < 1 || tipoVehiculo > 3);

            tarifa = obtenerTarifa(tipoVehiculo);

            nombreVehiculo = obtenerNombreVehiculo(tipoVehiculo);

            // Contar tipo de vehículo
            switch (tipoVehiculo) {
                case 1:
                    cantidadMotocicletas++;
                    break;
                case 2:
                    cantidadAutomoviles++;
                    break;
                case 3:
                    cantidadPickups++;
                    break;
            }

            // Horas estacionado
            do {
                System.out.print("Ingrese las horas estacionado: ");
                horas = teclado.nextInt();
            } while (horas <= 0);

            subtotal = horas * tarifa;

            descuento = calcularDescuento(subtotal, horas);

            // Ticket perdido
            do {
                System.out.print("¿Perdió el ticket? (S/N): ");
                ticketPerdido = teclado.next();
            } while (!ticketPerdido.equals("S") && !ticketPerdido.equals("N"));

            // Calcular recargo
            if (ticketPerdido.equals("S")) {
                recargo = 50.00;
            } else {
                recargo = 0.00;
            }

            if (ticketPerdido.equals("S")) {
                cantidadTicketsPerdidos++;
            }

            // Calcular total
            if (ticketPerdido.equals("S")) {
                total = calcularPago(horas, tarifa, recargo) - descuento;
            } else {
                total = calcularPago(horas, tarifa) - descuento;
            }

            // Acumular dinero recaudado
            totalRecaudado = totalRecaudado + total;

            // Verificar pago más alto
            if (total > pagoMasAlto) {
                pagoMasAlto = total;
                placaPagoMasAlto = placa;
            }

            // Mostrar comprobante
            mostrarComprobante(placa, nombreVehiculo, horas, tarifa, subtotal,
                    descuento, recargo, total);

        }

        // Resumen de la jornada
        System.out.println("\n========== RESUMEN DE LA JORNADA ==========");
        System.out.println("Cantidad de motocicletas: " + cantidadMotocicletas);
        System.out.println("Cantidad de automóviles: " + cantidadAutomoviles);
        System.out.println("Cantidad de pickups o camionetas: " + cantidadPickups);
        System.out.println("Cantidad de tickets perdidos: " + cantidadTicketsPerdidos);
        System.out.println("Total de dinero recaudado: Q" + totalRecaudado);
        System.out.println("Pago más alto: Q" + pagoMasAlto);
        System.out.println("Placa del pago más alto: " + placaPagoMasAlto);
        System.out.println("============================================");

        }

    // Método obtener tarifa
    public static double obtenerTarifa(int tipoVehiculo) {
        switch (tipoVehiculo) {
            case 1:
                return 5.00;
            case 2:
                return 8.00;
            case 3:
                return 12.00;
            default:
                return 0.00;
        }
    }

    // Método calcular descuento
    public static double calcularDescuento(double subtotal, int horas) {
        if (horas > 8) {
            return subtotal * 0.15;
        } else {
            return 0.00;
        }
    }

    // Método obtener el nombre de tipo de Vehículo
    public static String obtenerNombreVehiculo(int tipoVehiculo) {
        switch (tipoVehiculo) {
            case 1:
                return "Motocicleta";
            case 2:
                return "Automóvil";
            case 3:
                return "Pickup o camioneta";
            default:
                return "Tipo desconocido";
        }
    }

    // Método calcular pago normal
    public static double calcularPago(int horas, double tarifa) {
        return horas * tarifa;
    }

    // Método calcular pago con recargo
    public static double calcularPago(int horas, double tarifa, double recargo) {
        return (horas * tarifa) + recargo;
    }

    // Método mostrar comprobante
    public static void mostrarComprobante(String placa, String nombreVehiculo, int horas,
                                          double tarifa, double subtotal, double descuento,
                                          double recargo, double total) {

        System.out.println("\n========== COMPROBANTE ==========");
        System.out.println("Placa: " + placa);
        System.out.println("Tipo: " + nombreVehiculo);
        System.out.println("Horas estacionado: " + horas);
        System.out.println("Tarifa por hora: Q" + tarifa);
        System.out.println("Subtotal: Q" + subtotal);
        System.out.println("Descuento: Q" + descuento);
        System.out.println("Recargo por ticket perdido: Q" + recargo);
        System.out.println("TOTAL: Q" + total);
        System.out.println("=================================");
    }

}