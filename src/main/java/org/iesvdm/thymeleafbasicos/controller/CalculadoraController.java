package org.iesvdm.thymeleafbasicos.controller;

import org.iesvdm.thymeleafbasicos.DTO.CalculadoraDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalculadoraController {
    @GetMapping("/calculadora")
    public String calculadoraMedia(Model model, @ModelAttribute CalculadoraDTO calculadoraDTO){

        model.addAttribute("calculadoraDTO",calculadoraDTO);

        return "calculadora";
    }

    @PostMapping("/calculadora")
    public String calculadoraSubmit(Model model,@ModelAttribute CalculadoraDTO calculadoraDTO){

       model.addAttribute("calculo","Tu nota media es de: "
                + (calculadoraDTO.getNota1()+ calculadoraDTO.getNota2()+ calculadoraDTO.getNota3())/3);

        return "calculadora";
    }


}
