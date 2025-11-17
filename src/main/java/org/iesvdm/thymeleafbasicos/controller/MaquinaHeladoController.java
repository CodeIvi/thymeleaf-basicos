package org.iesvdm.thymeleafbasicos.controller;

import org.iesvdm.thymeleafbasicos.DTO.MaquinaHeladosDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class MaquinaHeladoController {

    @GetMapping ("/maquinaHelados")
    public String maquinaHeladoGet (Model model, @ModelAttribute MaquinaHeladosDTO maquinaHeladosDTO){

        model.addAttribute("helado", maquinaHeladosDTO);

        return "maquinaHelados";

    }

    @PostMapping("/maquinaHelados")
    public String maquinaHeladosPost(Model model,@ModelAttribute MaquinaHeladosDTO maquinaHeladosDTO){
        int porcChoco = maquinaHeladosDTO.getPorcChoco();
        int porcFresa = maquinaHeladosDTO.getPorcFresa();
        int porcVainilla = maquinaHeladosDTO.getPorcVainilla();

        if(porcChoco+porcFresa+porcVainilla>100){
            model.addAttribute("error", "La suma de los porcentajes debe ser menor o igual que 100. Por favor, introduzca de nuevo los porcentajes.");
        }else{
            model.addAttribute("helado", maquinaHeladosDTO);
        }

        return ("maquinaHelados");


    }
}
