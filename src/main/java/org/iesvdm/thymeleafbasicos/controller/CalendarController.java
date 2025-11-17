package org.iesvdm.thymeleafbasicos.controller;


import ch.qos.logback.core.util.Loader;
import org.iesvdm.thymeleafbasicos.DTO.CallendarDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Month;
import java.util.*;


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
        Map<String, Integer> mapMeses = Map.ofEntries(
                Map.entry("enero", 0),
                Map.entry("febrero", 1),
                Map.entry("marzo", 2),
                Map.entry("abril", 3),
                Map.entry("mayo", 4),
                Map.entry("junio", 5),
                Map.entry("julio", 6),
                Map.entry("agosto", 7),
                Map.entry("septiembre", 8),
                Map.entry("octubre", 9),
                Map.entry("noviembre", 10),
                Map.entry("diciembre", 11)
        );

        String mes = callendarDTO.getMes();
        int anio = callendarDTO.getAnio();
        int numMes = 0;
        Calendar calendar = Calendar.getInstance();

        if(mapMeses.containsKey(mes)){
            numMes = mapMeses.get(mes);
        }
        calendar.set(anio,numMes,1);
        // Día de la semana del primer día del mes (ajustado para lunes = 0)
        int primerDia = calendar.get(Calendar.DAY_OF_WEEK) - 2;
        if (primerDia < 0) primerDia = 6;  // Domingo → 6

        int diasMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Generar lista de semanas
        List<List<Integer>> semanas = new ArrayList<>();
        List<Integer> semanaActual = new ArrayList<>(Collections.nCopies(7, null));

        int dia = 1;
        // Primera semana con huecos
        for (int i = primerDia; i < 7 && dia <= diasMes; i++) {
            semanaActual.set(i, dia++);
        }
        semanas.add(semanaActual);

        // Semanas siguientes
        while (dia <= diasMes) {
            semanaActual = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                if (dia <= diasMes) {
                    semanaActual.add(dia++);
                } else {
                    semanaActual.add(null);
                }
            }
            semanas.add(semanaActual);
        }

        // Pasar variables al HTML
        model.addAttribute("mesSeleccionado", mes);
        model.addAttribute("anioSeleccionado", anio);
        model.addAttribute("semanas", semanas);

        // También necesitas la lista de meses para el select
        List<String> mesesList = new ArrayList<>(mapMeses.keySet());
        model.addAttribute("meses", mesesList);






        return "calendario";
    }
}

