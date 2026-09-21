import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        HashSet<String> placas = new HashSet<>();

        int opcion;

        do {
            System.out.println("\n===== ESTACIONAMIENTO =====");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Mostrar todos los vehículos");
            System.out.println("3. Buscar vehículo por placa");
            System.out.println("4. Mostrar vehículo con mayor costo");
            System.out.println("5. Mostrar total general recaudado");
            System.out.println("6. Mostrar total por tipo de vehículo");
            System.out.println("7. Salir");

            opcion = leerEntero(teclado, "Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    registrarVehiculo(teclado, vehiculos, placas);
                    break;

                case 2:
                    mostrarVehiculos(vehiculos);
                    break;

                case 3:
                    buscarVehiculo(teclado, vehiculos);
                    break;

                case 4:
                    mostrarMayorCosto(vehiculos);
                    break;

                case 5:
                    mostrarTotalGeneral(vehiculos);
                    break;

                case 6:
                    mostrarTotalesPorTipo(vehiculos);
                    break;

                case 7:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        teclado.close();
    }

    public static void registrarVehiculo(Scanner teclado,
                                         ArrayList<Vehiculo> vehiculos,
                                         HashSet<String> placas) {

        System.out.println("\n===== REGISTRAR VEHÍCULO =====");

        String placa;

        do {
            System.out.print("Placa: ");
            placa = teclado.nextLine().trim();

            if (placa.isEmpty()) {
                System.out.println("La placa no puede estar vacía.");
            }

        } while (placa.isEmpty());

        if (placas.contains(placa)) {
            System.out.println("No se puede registrar. La placa ya existe.");
            return;
        }

        String propietario;

        do {
            System.out.print("Propietario: ");
            propietario = teclado.nextLine().trim();

            if (propietario.isEmpty()) {
                System.out.println("El propietario no puede estar vacío.");
            }

        } while (propietario.isEmpty());

        System.out.print("Hora de ingreso: ");
        String horaIngreso = teclado.nextLine();

        int horasUtilizadas;

        do {
            horasUtilizadas = leerEntero(teclado, "Horas utilizadas: ");

            if (horasUtilizadas <= 0) {
                System.out.println("Las horas deben ser mayores que cero.");
            }

        } while (horasUtilizadas <= 0);

        int tipo;

        do {
            System.out.println("\nTipo de vehículo:");
            System.out.println("1. Automóvil");
            System.out.println("2. Motocicleta");

            tipo = leerEntero(teclado, "Seleccione el tipo: ");

            if (tipo != 1 && tipo != 2) {
                System.out.println("Tipo de vehículo inválido.");
            }

        } while (tipo != 1 && tipo != 2);

        Vehiculo vehiculo;

        if (tipo == 1) {
            vehiculo = new Automovil(
                    placa,
                    propietario,
                    horaIngreso,
                    horasUtilizadas
            );
        } else {
            vehiculo = new Motocicleta(
                    placa,
                    propietario,
                    horaIngreso,
                    horasUtilizadas
            );
        }

        vehiculos.add(vehiculo);
        placas.add(placa);

        System.out.println("Vehículo registrado correctamente.");
        System.out.println("Costo calculado: Q" + vehiculo.calcularCosto());
    }

    public static void mostrarVehiculos(ArrayList<Vehiculo> vehiculos) {

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        System.out.println("\n===== VEHÍCULOS REGISTRADOS =====");

        for (Vehiculo vehiculo : vehiculos) {

            System.out.println("------------------------------");
            System.out.println("Placa: " + vehiculo.getPlaca());
            System.out.println("Propietario: " + vehiculo.getPropietario());
            System.out.println("Tipo: " + vehiculo.getClass().getSimpleName());
            System.out.println("Horas utilizadas: " + vehiculo.getHorasUtilizadas());
            System.out.println("Costo: Q" + vehiculo.calcularCosto());
        }
    }

    public static void buscarVehiculo(Scanner teclado,
                                      ArrayList<Vehiculo> vehiculos) {

        System.out.print("Ingrese la placa a buscar: ");
        String placaBuscada = teclado.nextLine().trim();

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.getPlaca().equalsIgnoreCase(placaBuscada)) {

                System.out.println("\nVehículo encontrado:");
                vehiculo.mostrarInformacion();
                System.out.println("Tipo: " + vehiculo.getClass().getSimpleName());
                System.out.println("Costo: Q" + vehiculo.calcularCosto());

                return;
            }
        }

        System.out.println("No se encontró un vehículo con esa placa.");
    }

    public static void mostrarMayorCosto(ArrayList<Vehiculo> vehiculos) {

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        Vehiculo mayor = vehiculos.get(0);

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.calcularCosto() > mayor.calcularCosto()) {
                mayor = vehiculo;
            }
        }

        System.out.println("\n===== MAYOR COSTO =====");
        System.out.println("Placa: " + mayor.getPlaca());
        System.out.println("Propietario: " + mayor.getPropietario());
        System.out.println("Tipo: " + mayor.getClass().getSimpleName());
        System.out.println("Costo: Q" + mayor.calcularCosto());
    }

    public static void mostrarTotalGeneral(ArrayList<Vehiculo> vehiculos) {

        double total = 0;

        for (Vehiculo vehiculo : vehiculos) {
            total = total + vehiculo.calcularCosto();
        }

        System.out.println("\n===== TOTAL GENERAL =====");
        System.out.println("Total recaudado: Q" + total);
    }

    public static void mostrarTotalesPorTipo(ArrayList<Vehiculo> vehiculos) {

        HashMap<String, Double> totalesPorTipo = new HashMap<>();

        for (Vehiculo vehiculo : vehiculos) {

            String tipo = vehiculo.getClass().getSimpleName();
            double costo = vehiculo.calcularCosto();

            if (totalesPorTipo.containsKey(tipo)) {

                double totalActual = totalesPorTipo.get(tipo);
                totalesPorTipo.put(tipo, totalActual + costo);

            } else {

                totalesPorTipo.put(tipo, costo);
            }
        }

        System.out.println("\n===== TOTAL POR TIPO =====");

        for (String tipo : totalesPorTipo.keySet()) {
            System.out.println(tipo + ": Q" + totalesPorTipo.get(tipo));
        }
    }

    public static int leerEntero(Scanner teclado, String mensaje) {

        int numero = -1;

        try {

            System.out.print(mensaje);
            numero = Integer.parseInt(teclado.nextLine());

        } catch (NumberFormatException e) {

            System.out.println("Entrada inválida. Debe ingresar un número.");

        } finally {

            System.out.println("Validación de entrada finalizada.");

        }

        return numero;
    }
}