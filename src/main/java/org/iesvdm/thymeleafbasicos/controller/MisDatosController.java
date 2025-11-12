package org.iesvdm.thymeleafbasicos.controller;

import org.iesvdm.thymeleafbasicos.DTO.MisDatosDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MisDatosController {

    @GetMapping("/datos")
    public String misDatos(Model model, @ModelAttribute MisDatosDTO misDatosDTO){

        model.addAttribute("misDatosDTO",misDatosDTO);

        return "datos";
    }

    @PostMapping("/datos")
    public String misDatosSubmit(Model model,@ModelAttribute MisDatosDTO misDatosDTO){

        model.addAttribute("datos","Su nombre es: "+misDatosDTO.getNombre()+" "+misDatosDTO.getApellido1()+" "+misDatosDTO.getApellido2());

        return "datos";
    }

}
