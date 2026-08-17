import java.util.Scanner;

public class ControlParqueo {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int cantidadVehiculos;

        // Cantidad de vehículos
        do {
            System.out.print("Ingrese la cantidad de vehículos: ");
            cantidadVehiculos = teclado.nextInt();
        } while (cantidadVehiculos <= 0);

        // Registro de vehículos
        for (int i = 1; i <= cantidadVehiculos; i++) {

            System.out.println("\n--- Vehículo " + i + " ---");

            String placa;
            int tipoVehiculo;
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

        }

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

}