package com.example.clinicaOdontologica_Rodo.controller;

import com.example.clinicaOdontologica_Rodo.dao.OdontologoDaoH2;
import com.example.clinicaOdontologica_Rodo.dao.PacienteDaoH2;
import com.example.clinicaOdontologica_Rodo.dao.TurnoLista;
import com.example.clinicaOdontologica_Rodo.dominio.Odontologos;
import com.example.clinicaOdontologica_Rodo.dominio.Paciente;
import com.example.clinicaOdontologica_Rodo.dominio.Turno;
import com.example.clinicaOdontologica_Rodo.service.OdontologoService;
import com.example.clinicaOdontologica_Rodo.service.PacienteService;
import com.example.clinicaOdontologica_Rodo.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService = new TurnoService(new TurnoLista());
    private PacienteService pacienteService= new PacienteService(new PacienteDaoH2());
    private OdontologoService odontologoService= new OdontologoService(new OdontologoDaoH2());

    @PostMapping
    //cuando yo lo reciba tengo que tener el cuerpo de turno y poder registrar una respuesta
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> respuesta;
        //controlar si los id son existentes
        Paciente paciente = pacienteService.buscarlo(turno.getPaciente().getId());
        Odontologos odontologo=odontologoService.buscarXId(turno.getOdontologo().getId());

        //CONTROL
        if (paciente!=null && odontologo!=null){
            //okey podemos agregar el turno
            respuesta=ResponseEntity.ok(turnoService.registrarTurno(turno));
        }
        else{
            respuesta= ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }
    @GetMapping
    public ResponseEntity<List<Turno>> listarTurno(){
        return ResponseEntity.ok(turnoService.ListarTurnos());
    }
}
