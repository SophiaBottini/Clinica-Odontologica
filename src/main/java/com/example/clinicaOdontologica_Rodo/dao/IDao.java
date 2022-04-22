package com.example.clinicaOdontologica_Rodo.dao;

import com.example.clinicaOdontologica_Rodo.dominio.Turno;

import java.util.List;

public interface IDao <T>{
    List<T>ListarElementos();
    T buscarlo(int id);
    T buscarEmail(String email);
    T guardar(Turno elemento);
    T actualizar(Turno elemento);
    void eliminar(int id);

}
