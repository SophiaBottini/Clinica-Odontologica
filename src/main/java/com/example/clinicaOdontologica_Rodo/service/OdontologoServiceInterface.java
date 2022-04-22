package com.example.clinicaOdontologica_Rodo.service;

import com.example.clinicaOdontologica_Rodo.dominio.Odontologos;
import com.example.clinicaOdontologica_Rodo.dominio.Paciente;

import java.util.List;

public interface OdontologoServiceInterface {

    List<Odontologos> ListarOdontologos();
    Odontologos buscarXId(int id);
}
