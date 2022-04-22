package com.example.clinicaOdontologica_Rodo.service;

import com.example.clinicaOdontologica_Rodo.dao.IDao;
import com.example.clinicaOdontologica_Rodo.dominio.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements PacientyeServiceInterface{

    private IDao<Paciente> pacienteIDao;
    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }


    //trabajar con el DAO
    @Override
    public List<Paciente> ListarPacientes() {

        return pacienteIDao.ListarElementos();//trae una coleccion
    }

    @Override
    public Paciente buscarXEmail(String email) {
        return pacienteIDao.buscarEmail(email);//busca el mail que paso por parametro y me devuelve un paciente
    }

    @Override
    public Paciente buscarlo(Integer id) {
        return pacienteIDao.buscarlo(id);
    }

}
