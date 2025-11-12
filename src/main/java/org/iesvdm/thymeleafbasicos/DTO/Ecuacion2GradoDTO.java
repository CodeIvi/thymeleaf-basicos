package org.iesvdm.thymeleafbasicos.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Ecuacion2GradoDTO {
    private int a;
    private int b;
    private int c;
}
