package org.iesvdm.thymeleafbasicos.controller;

import org.iesvdm.thymeleafbasicos.DTO.ConversorDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConversorController {

    @GetMapping("/conversor")
    public String conversor(Model model, @ModelAttribute ConversorDTO conversorDTO){

        model.addAttribute("conversorDTO",conversorDTO);

        return "conversor";
    }

    @PostMapping("/conversor")
    public String conversorSubmit(Model model,@ModelAttribute ConversorDTO conversorDTO){
        model.addAttribute("conversor","Valor en euros: "+conversorDTO.getDolares()*0.86+" euros");

        return "conversor";
    }
}
