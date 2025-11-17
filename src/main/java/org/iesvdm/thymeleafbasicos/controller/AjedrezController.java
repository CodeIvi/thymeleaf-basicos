package org.iesvdm.thymeleafbasicos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.stream.IntStream;

@Controller
public class AjedrezController {
    @GetMapping("/ajedrez")
    public String dibujoAjedrez(Model model) {
        int[] rows = IntStream.rangeClosed(1,8).toArray();
        int[] cols = IntStream.rangeClosed(1,8).toArray();

        model.addAttribute("rows",rows);
        model.addAttribute("cols",cols);

        int ejex =(int)(Math.random()*8)+1;
        int ejey = (int)(Math.random()*8)+1;

        int ejex1 =(int)(Math.random()*8)+1;
        int ejey1 = (int)(Math.random()*8)+1;

        model.addAttribute("x",ejex);
        model.addAttribute("y",ejey);
        model.addAttribute("x1",ejex1);
        model.addAttribute("y1",ejey1);

        return "ajedrez";


    }


}
