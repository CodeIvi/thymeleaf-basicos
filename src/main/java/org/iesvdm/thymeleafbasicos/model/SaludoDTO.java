package org.iesvdm.thymeleafbasicos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaludoDTO {
    //DTO = Data Transfer Object, subcategoria de Beans o POJOs.
    //para re
    private String nombre;
    private String idioma;
}
