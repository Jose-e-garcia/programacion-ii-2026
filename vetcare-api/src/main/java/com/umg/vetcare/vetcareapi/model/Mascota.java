package com.umg.vetcare.vetcareapi.model;

public class Mascota {

    private Long id;
    private String nombre;
    private String especie;
    public String nada ;

    public Mascota(Long id, String nombre, String especie, String nada) {

        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.nada = nada;



    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }
}