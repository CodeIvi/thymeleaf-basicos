package org.iesvdm.thymeleafbasicos.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AjedrezDTO {
    private int[] fila ={1,2,3,4,5,6,7,8};
    private int[] columna = {1,2,3,4,5,6,7,8};
}
