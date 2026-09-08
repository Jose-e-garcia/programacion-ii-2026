import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;

public class MainControlCompras {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();

        HashSet<String> categorias = new HashSet<>();

        HashMap<String, Double> totalesPorCategoria = new HashMap<>();

        double totalGeneral = 0;

        double pagoMasAlto = 0;
        double pagoMasBajo = 0;

        String productoMasCaro = "";
        String productoMasBarato = "";

        String categoriaMayorGasto = "";
        double mayorGastoCategoria = 0;

        Scanner teclado = new Scanner(System.in);

        while (productos.size() < 5) {

            System.out.print("Nombre del producto: ");
            String nombre = teclado.nextLine();

            if (nombre.isEmpty()) {
                System.out.println("Producto no registrado: el nombre no puede estar vacío.");
                continue;
            }

            System.out.print("Categoría: ");
            String categoria = teclado.nextLine();

            if (categoria.isEmpty()) {
                System.out.println("Producto no registrado: la categoría no puede estar vacía.");
                continue;
            }

            System.out.print("Precio unitario: ");
            double precioUnitario = teclado.nextDouble();

            if (precioUnitario <= 0) {
                System.out.println("Producto no registrado: el precio debe ser mayor que cero.");
                teclado.nextLine();
                continue;
            }

            System.out.print("Cantidad: ");
            int cantidad = teclado.nextInt();

            if (cantidad <= 0) {
                System.out.println("Producto no registrado: la cantidad debe ser mayor que cero.");
                teclado.nextLine();
                continue;
            }

            teclado.nextLine();

            Producto producto = new Producto(nombre, categoria, precioUnitario, cantidad);

            productos.add(producto);
            categorias.add(categoria);

        }

        System.out.println("\n===== PRODUCTOS REGISTRADOS =====");

        for (Producto producto : productos) {
            System.out.printf("%s - Subtotal: Q%.2f%n", producto.getNombre(), producto.calcularSubtotal());
        }


        System.out.println("\n===== CATEGORÍAS =====");

        for (String categoria : categorias) {
            System.out.println(categoria);
        }

        for (Producto producto : productos) {

            String categoria = producto.getCategoria();
            double subtotal = producto.calcularSubtotal();

            totalGeneral = totalGeneral + subtotal;

            if (subtotal > pagoMasAlto) {
                pagoMasAlto = subtotal;
                productoMasCaro = producto.getNombre();
            }

            if (subtotal < pagoMasBajo || pagoMasBajo == 0) {
                pagoMasBajo = subtotal;
                productoMasBarato = producto.getNombre();
            }

            if (totalesPorCategoria.containsKey(categoria)) {
                double totalActual = totalesPorCategoria.get(categoria);
                totalesPorCategoria.put(categoria, totalActual + subtotal);
            } else {
                totalesPorCategoria.put(categoria, subtotal);
            }

        }

        System.out.printf("\nTotal general: Q%.2f%n", totalGeneral);

        System.out.println("Total de productos registrados: " + productos.size());

        System.out.printf("Producto con mayor gasto: %s - Q%.2f%n", productoMasCaro, pagoMasAlto);
        System.out.printf("Producto con menor gasto: %s - Q%.2f%n", productoMasBarato, pagoMasBajo);

        System.out.println("\n===== TOTAL POR CATEGORÍA =====");

        for (String categoria : totalesPorCategoria.keySet()) {
            System.out.printf("%s: Q%.2f%n", categoria, totalesPorCategoria.get(categoria));
        }

        for (String categoria : totalesPorCategoria.keySet()) {

            double totalCategoria = totalesPorCategoria.get(categoria);

            if (totalCategoria > mayorGastoCategoria) {
                mayorGastoCategoria = totalCategoria;
                categoriaMayorGasto = categoria;
            }
        }

        System.out.printf("Categoría con mayor gasto: %s - Q%.2f%n",
                categoriaMayorGasto, mayorGastoCategoria);

        System.out.print("\nIngrese una categoría para consultar: ");
        String categoriaConsulta = teclado.nextLine();

        if (totalesPorCategoria.containsKey(categoriaConsulta)) {
            System.out.printf("Total gastado en %s: Q%.2f%n",
                    categoriaConsulta, totalesPorCategoria.get(categoriaConsulta));
        } else {
            System.out.println("La categoría no existe.");
        }

    }

}
