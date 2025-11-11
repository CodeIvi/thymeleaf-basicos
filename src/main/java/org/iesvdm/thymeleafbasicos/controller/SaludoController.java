package org.iesvdm.thymeleafbasicos.controller;

import org.iesvdm.thymeleafbasicos.model.SaludoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaludoController {

    //ENDPOINT
    @GetMapping("/saludos")

    public String saludos(Model model, @ModelAttribute SaludoDTO saludoDTO){

        //(@ModelAttribute SaludoDTO saludoDTO) reemplaza a -V
        // SaludoDTO saludoDTO = new SaludoDTO();
        //model.addATribute("SaludoDTO",saludoDTO);
        model.addAttribute("SaludoDTO",saludoDTO);



        return "saludos";
    }

    @PostMapping("/saludos")
    public String saludosSubmit(Model model,@ModelAttribute SaludoDTO saludoDTO){
        model.addAttribute("saludo", "Hola"+ saludoDTO.getNombre()+"!!");

        return "saludos";

    }
}
