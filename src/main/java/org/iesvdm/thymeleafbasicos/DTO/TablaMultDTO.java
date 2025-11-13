package org.iesvdm.thymeleafbasicos.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TablaMultDTO {
    private int num;
    private String multiplicador = "*";
    private int factor;
    private int resultado;
}
