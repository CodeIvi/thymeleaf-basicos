package org.iesvdm.thymeleafbasicos.controller;

import org.iesvdm.thymeleafbasicos.DTO.CalculadoraDTO;
import org.iesvdm.thymeleafbasicos.DTO.SaludoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaludoController {

    //ENDPOINT
    @GetMapping("/saludos")

    public String saludos(Model model, @ModelAttribute SaludoDTO saludoDTO) {

        //(@ModelAttribute SaludoDTO saludoDTO) reemplaza a -V
        // SaludoDTO saludoDTO = new SaludoDTO();
        //model.addATribute("SaludoDTO",saludoDTO);
        model.addAttribute("saludoDTO", saludoDTO);


        return "saludos";
    }

    @PostMapping("/saludos")
    public String saludosSubmit(Model model, @ModelAttribute SaludoDTO saludoDTO) {

        if(saludoDTO.getIdioma().equals("es")) {
            model.addAttribute("saludo", "Hola" + saludoDTO.getNombre() + "!!");
        }else if(saludoDTO.getIdioma().equals("en")){
            model.addAttribute("saludo", "Hello" + saludoDTO.getNombre() + "!!");
        }else if (saludoDTO.getIdioma().equals("fr")){
            model.addAttribute("saludo", "Bonjour" + saludoDTO.getNombre() + "!!");
        }
        return "saludos";

    }
}

