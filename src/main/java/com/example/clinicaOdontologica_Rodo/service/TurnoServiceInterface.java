package com.example.clinicaOdontologica_Rodo.service;

import com.example.clinicaOdontologica_Rodo.dominio.Odontologos;
import com.example.clinicaOdontologica_Rodo.dominio.Turno;

import java.util.List;

public interface TurnoServiceInterface {
    List<Turno> ListarTurnos();
    void eliminar(Integer id);

}
