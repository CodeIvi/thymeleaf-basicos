package org.iesvdm.thymeleafbasicos.controller;


import ch.qos.logback.core.util.Loader;
import org.iesvdm.thymeleafbasicos.DTO.CallendarDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Controller
public class CalendarController {

    @GetMapping("/calendario")
    public String getCalendar(Model model, @ModelAttribute CallendarDTO callendarDTO) {
        List<String> meses = new ArrayList<>(12);
        Calendar calendar = Calendar.getInstance();
        for (int i= 0;i<12;i++){
            calendar.set(2025,i,1);
            meses.add(calendar.getDisplayName(Calendar.MONTH,Calendar.LONG_FORMAT,new Locale("es")));
        }
        model.addAttribute("meses",meses);
        model.addAttribute("callendarDTO",callendarDTO);

        return "calendario";
    }

    @PostMapping("/calendario")
    public String calendarioSubmit(Model model, @ModelAttribute CallendarDTO callendarDTO) {


        String mes = callendarDTO.getMes();
        int anio = callendarDTO.getAnio();



        return "show-moth";
    }
}

