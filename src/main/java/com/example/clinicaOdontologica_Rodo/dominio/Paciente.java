package com.example.clinicaOdontologica_Rodo.dominio;

import java.time.LocalDate;

public class Paciente {
    private int id;
    private String apellido;
    private String nombre;
    private int dni;
    private String email;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;
    private Odontologos odontologos;

    public Paciente(int id, String apellido, String nombre, int dni, String email, LocalDate fechaIngreso, Domicilio domicilio, Odontologos odontologos) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.odontologos = odontologos;
    }

    public Paciente(String apellido, String nombre, int dni, String email, LocalDate fechaIngreso, Domicilio domicilio, Odontologos odontologos) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.odontologos = odontologos;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni=" + dni +
                ", fechaIngreso=" + fechaIngreso +
                ", domicilio=" + domicilio +
                '}';
    }
}
