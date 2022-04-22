package com.example.clinicaOdontologica_Rodo.service;

import com.example.clinicaOdontologica_Rodo.dominio.Paciente;

import java.util.List;

//nos devuelve a todos los pacientes y al paciente segun el email
//definimos que responsabilidades debe tener un servicio
public interface PacientyeServiceInterface {

    //el que quiera buscar el email va a tener que implementar estos metodos
    List<Paciente>ListarPacientes();
    Paciente buscarXEmail(String email);
    Paciente buscarlo(Integer id);

}
