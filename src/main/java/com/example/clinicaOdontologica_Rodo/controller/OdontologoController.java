package com.example.clinicaOdontologica_Rodo.controller;

import com.example.clinicaOdontologica_Rodo.dominio.Odontologos;
import com.example.clinicaOdontologica_Rodo.dominio.Paciente;
import com.example.clinicaOdontologica_Rodo.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OdontologoController {
    OdontologoService odontologoService;

    @Autowired
    OdontologoController(OdontologoService odontologoService) {
        this.odontologoService=odontologoService;
    }

    @GetMapping(value = "/odontologo")
    public String traerOdontologos(Model model, @RequestParam(name = "id")int id){
        Odontologos odontologos = odontologoService.buscarXId(id);
        model.addAttribute("apellido",odontologos.getApellido());
        model.addAttribute("nombre",odontologos.getNombre());
        model.addAttribute("matricula",odontologos.getMatricula());
        return "odontologo";
    }




}
