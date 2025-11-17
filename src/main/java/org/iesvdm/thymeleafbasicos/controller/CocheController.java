package org.iesvdm.thymeleafbasicos.controller;

import lombok.AllArgsConstructor;
import org.iesvdm.thymeleafbasicos.DTO.CocheDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CocheController {

    @GetMapping("/coche")
    public String cochesDatos(Model model, @ModelAttribute CocheDTO cocheDTO){

        model.addAttribute("cocheDTO",cocheDTO);

        return "coche";

    }

    @PostMapping("/coche")
    public String ObtenerDatos(Model model,@ModelAttribute CocheDTO cocheDTO){
        String tapiceria = cocheDTO.getTapiceria();
        String material = cocheDTO.getMaterial();

        String resultado = "El color de la tapicería es: "+tapiceria +", y el material es de: "+material;
        model.addAttribute("resultado",resultado);

        return "coche";
    }
}
