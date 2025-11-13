package org.iesvdm.thymeleafbasicos.controller;

import org.iesvdm.thymeleafbasicos.DTO.TablaMultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TablaMultController {

    @GetMapping("/tablaMult")
    public String tablaMult(Model model, @ModelAttribute TablaMultDTO tablaMultDTO) {

        model.addAttribute("tablaMultDTO", tablaMultDTO);

        return  "tablaMult";
    }

    @PostMapping("/tablaMult")
    public String tablaMultSubmit(Model model,@ModelAttribute TablaMultDTO tablaMultDTO){
        List<TablaMultDTO> tabla = new ArrayList<>();
        for(int i = 0;i<=10;i++){
           tabla.add(new TablaMultDTO(   tablaMultDTO.getNum(),
                                         tablaMultDTO.getMultiplicador(),
                                tablaMultDTO.getFactor()+i,
                                tablaMultDTO.getNum() * i));
        }
        model.addAttribute("tabla",tabla);
        return "tablaMult";
    }

}
