package com.estudiante.semana13bibliotecaapi.controller;

import com.estudiante.semana13bibliotecaapi.entity.Libro;
import com.estudiante.semana13bibliotecaapi.repository.LibroRepository;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class LibroController {

    private final LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping("/api/libros")
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    @GetMapping("/api/libros/{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable Long id) {

        Optional<Libro> libro = libroRepository.findById(id);

        if (libro.isPresent()) {
            return ResponseEntity.ok(libro.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/libros")
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {

        Libro nuevoLibro = libroRepository.save(libro);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }

    @PutMapping("/api/libros/{id}")
    public ResponseEntity<Libro> actualizarLibro(
            @PathVariable Long id,
            @RequestBody Libro libro) {

        Optional<Libro> libroExistente = libroRepository.findById(id);

        if (libroExistente.isPresent()) {
            Libro actualizado = libroExistente.get();

            actualizado.setCodigo(libro.getCodigo());
            actualizado.setTitulo(libro.getTitulo());
            actualizado.setAutor(libro.getAutor());
            actualizado.setCategoria(libro.getCategoria());
            actualizado.setAnioPublicacion(libro.getAnioPublicacion());
            actualizado.setPrecio(libro.getPrecio());
            actualizado.setDisponible(libro.getDisponible());

            Libro guardado = libroRepository.save(actualizado);

            return ResponseEntity.ok(guardado);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/libros/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {

        Optional<Libro> libro = libroRepository.findById(id);

        if (libro.isPresent()) {
            libroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/api/libros/categoria/{categoria}")
    public List<Libro> buscarPorCategoria(
            @PathVariable String categoria) {

        return libroRepository.findByCategoria(categoria);
    }

    @GetMapping("/api/libros/disponibles")
    public List<Libro> listarDisponibles() {
        return libroRepository.findByDisponibleTrue();
    }

}