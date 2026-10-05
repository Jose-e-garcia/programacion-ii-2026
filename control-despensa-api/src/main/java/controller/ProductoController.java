package com.estudiante.despensa.controller;

import com.estudiante.despensa.model.Producto;
import com.estudiante.despensa.model.ResumenInventario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private List<Producto> productos = new ArrayList<>();

    public ProductoController() {
        agregarProducto(new Producto(1L, "Arroz", "Granos", 5, 12.00));
        agregarProducto(new Producto(2L, "Frijoles", "Granos", 3, 10.00));
        agregarProducto(new Producto(3L, "Leche", "Lacteos", 2, 8.50));
        agregarProducto(new Producto(4L, "Queso", "Lacteos", 4, 25.00));
        agregarProducto(new Producto(5L, "Jabon", "Limpieza", 1, 15.00));
        agregarProducto(new Producto(6L, "Cafe", "Bebidas", 6, 30.00));
    }

    private void agregarProducto(Producto producto) {
        if (producto.getId() == null || producto.getId() <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0.");
        }

        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }

        if (producto.getCategoria() == null || producto.getCategoria().trim().isEmpty()) {
            throw new IllegalArgumentException("La categoria es obligatoria.");
        }

        if (producto.getCantidad() < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }

        if (producto.getPrecioUnitario() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        }

        for (Producto existente : productos) {
            if (existente.getId().equals(producto.getId())) {
                throw new IllegalArgumentException("No se permiten IDs repetidos.");
            }
        }

        productos.add(producto);
    }

    @GetMapping
    public List<Producto> obtenerTodos() {
        return productos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return ResponseEntity.ok(producto);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/categoria/{categoria}")
    public List<Producto> obtenerPorCategoria(@PathVariable String categoria) {
        List<Producto> resultado = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(producto);
            }
        }

        return resultado;
    }

    @GetMapping("/stock-bajo")
    public List<Producto> obtenerStockBajo() {
        List<Producto> resultado = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCantidad() <= 3) {
                resultado.add(producto);
            }
        }

        return resultado;
    }

    @GetMapping("/mayor-valor")
    public ResponseEntity<Producto> obtenerMayorValor() {
        if (productos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Producto mayor = productos.get(0);

        for (Producto producto : productos) {
            if (producto.calcularSubtotal() > mayor.calcularSubtotal()) {
                mayor = producto;
            }
        }

        return ResponseEntity.ok(mayor);
    }

    @GetMapping("/resumen")
    public ResumenInventario obtenerResumen() {
        int cantidadProductos = productos.size();
        int totalUnidades = 0;
        double valorTotal = 0;

        for (Producto producto : productos) {
            totalUnidades += producto.getCantidad();
            valorTotal += producto.calcularSubtotal();
        }

        return new ResumenInventario(cantidadProductos, totalUnidades, valorTotal);
    }
}
