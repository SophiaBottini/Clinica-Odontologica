package com.example.clinicaOdontologica_Rodo.dao;

import com.example.clinicaOdontologica_Rodo.dominio.Odontologos;
import com.example.clinicaOdontologica_Rodo.dominio.Paciente;
import com.example.clinicaOdontologica_Rodo.dominio.Turno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TurnoLista implements IDao<Turno> {
    private List<Turno>turnos;

    public TurnoLista(){
        turnos=new ArrayList<>();
        //necesito traer un paciente y un odontologo
        PacienteDaoH2 pacienteDaoH2=new PacienteDaoH2();
        OdontologoDaoH2 odontologoDaoH2=new OdontologoDaoH2();
        Paciente paciente=pacienteDaoH2.buscarlo(1);
        Odontologos odontologo=odontologoDaoH2.buscarlo(1);
        Turno turno=new Turno(1,paciente,odontologo, LocalDate.of(2022,03,01));
        turnos.add(turno);
    }


    @Override
    public List<Turno> ListarElementos() {
        //devuelvo directamente la lista de turnos creada
        return turnos;
    }

    @Override
    public Turno buscarlo(int id) {
        //si lo encuentra retorna turno y sino retorna nulo
        for (Turno turno:turnos){
            if (turno.getId()==id){
                return turno;
            }
        }
        return null;
    }

    @Override
    public Turno buscarEmail(String email) {
        return null;
    }

    @Override
    public Turno guardar(Turno elemento) {
        turnos.add(elemento);
        return elemento;
    }

    @Override
    public Turno actualizar(Turno elemento) {
        eliminar(elemento.getId());
        turnos.add(elemento);
        return elemento;
    }

    @Override
    public void eliminar(int id) {
        //si lo encuentra borralo
        for (Turno turno : turnos) {
            if (turno.getId() == id) {
                turnos.remove(turno);
            }
        }

    }
}
