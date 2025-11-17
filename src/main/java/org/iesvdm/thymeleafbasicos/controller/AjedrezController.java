package org.iesvdm.thymeleafbasicos.controller;

import org.iesvdm.thymeleafbasicos.DTO.AjedrezDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.stream.IntStream;

@Controller
public class AjedrezController {
    @GetMapping("/ajedrez")
    public String dibujoAjedrez(Model model, @ModelAttribute AjedrezDTO ajedrezDTO) {
        int[] rows = IntStream.rangeClosed(1,8).toArray();
        int[] cols = IntStream.rangeClosed(1,8).toArray();

        model.addAttribute("rows",rows);
        model.addAttribute("cols",cols);

        return "ajedrez";

    }

    @PostMapping("/ajedrez")
    public String ajedrezDibujado(Model model,@ModelAttribute AjedrezDTO ajedrezDTO){

        return "ajedrez";

    }
}
