package com.example.clinicaOdontologica_Rodo.dominio;

import java.time.LocalDate;

public class Turno {
    private int id;
    private Paciente paciente;
    private Odontologos odontologo;
    private LocalDate fechaYhora;

    public Turno(int id, Paciente paciente, Odontologos odontologo, LocalDate fechaYhora) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaYhora = fechaYhora;
    }

    public Turno(Paciente paciente, Odontologos odontologo, LocalDate fechaYhora) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaYhora = fechaYhora;
    }

    public Turno(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologos getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologos odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(LocalDate fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

}
