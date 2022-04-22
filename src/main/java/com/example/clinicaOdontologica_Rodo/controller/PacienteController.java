package com.example.clinicaOdontologica_Rodo.controller;

import com.example.clinicaOdontologica_Rodo.dominio.Paciente;
import com.example.clinicaOdontologica_Rodo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//¿Que se va a encargar?
/*Va a ser el que reciba la solicitud desde la vista,y en base a eso tiene una resolucuion del modelo
*Deberia haber algun metodo que hace un trabajo,que luego vas a tener que pasarloa la vista
 */
/*Procesa alguna consulta que pueda resolver la necesidad de nuestro mkodelo, segun lo que nosotros realizamos*/
@Controller
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @GetMapping("/index")
    //metodo que se va a encargar de resolver la funcion que pide el cliente
    public String traerPacientes(Model model, @RequestParam (name = "email")String email){
        //buscar el paciente con el email
        Paciente paciente=pacienteService.buscarXEmail(email);
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        return "index";
    }
}
