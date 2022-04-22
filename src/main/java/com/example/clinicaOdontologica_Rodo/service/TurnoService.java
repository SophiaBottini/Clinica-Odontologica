package com.example.clinicaOdontologica_Rodo.service;

import com.example.clinicaOdontologica_Rodo.dao.IDao;
import com.example.clinicaOdontologica_Rodo.dominio.Turno;

import java.util.List;

public class TurnoService implements TurnoServiceInterface {
    private IDao<Turno>turnoIDao;

    public TurnoService(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }
    public Turno registrarTurno(Turno turno){
        return turnoIDao.guardar(turno);
    }

    @Override
    public List<Turno> ListarTurnos() {
        return turnoIDao.ListarElementos();
    }

    @Override
    public void eliminar(Integer id) {

    }
}
