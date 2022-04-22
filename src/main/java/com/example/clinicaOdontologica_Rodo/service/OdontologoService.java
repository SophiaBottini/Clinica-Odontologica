package com.example.clinicaOdontologica_Rodo.service;

import com.example.clinicaOdontologica_Rodo.dao.IDao;
import com.example.clinicaOdontologica_Rodo.dominio.Odontologos;
import com.example.clinicaOdontologica_Rodo.dominio.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements OdontologoServiceInterface{

    private IDao<Odontologos> odontologosIDao;

    public OdontologoService(IDao<Odontologos> odontologoIDao) {
        this.odontologosIDao = odontologoIDao;
    }

    @Override
    public List<Odontologos> ListarOdontologos() {
        return null;
    }

    @Override
    public Odontologos buscarXId(int id) {
        return odontologosIDao.buscarlo(id);
    }
}
