package org.iesvdm.thymeleafbasicos.controller;

import org.iesvdm.thymeleafbasicos.DTO.Ecuacion2GradoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Controller
public class Ecuacion2GradoController {

    @GetMapping("/ecuacion2Grado")
    public String ecuacion2Grado(Model model, @ModelAttribute Ecuacion2GradoDTO ecuacion2Grado){

        model.addAttribute("ecuacion2GradoDTO",ecuacion2Grado);
        model.addAttribute("ecuacion", null);

        return "ecuacion2Grado";
    }

    @PostMapping("/ecuacion2Grado")
    public String ecuacion2GradoSubmint(Model model,@ModelAttribute Ecuacion2GradoDTO ecuacion2GradoDTO){

        double discriminante = Math.pow(ecuacion2GradoDTO.getB(),2)-4*ecuacion2GradoDTO.getA()*ecuacion2GradoDTO.getC();

        if(discriminante < 0){
            model.addAttribute("ecuacion",false);
        }else{
            double resultado1 =(-ecuacion2GradoDTO.getB()+Math.sqrt(discriminante))/(2*ecuacion2GradoDTO.getA());
            double resultado2 =(-ecuacion2GradoDTO.getB()-Math.sqrt(discriminante))/(2*ecuacion2GradoDTO.getA());
           model.addAttribute("resultado1",resultado1);
           model.addAttribute("resultado2",resultado2);
           model.addAttribute("ecuacion",true);
        }

        return "ecuacion2Grado";
    }


}
