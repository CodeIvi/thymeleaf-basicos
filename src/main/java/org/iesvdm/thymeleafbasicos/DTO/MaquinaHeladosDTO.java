package org.iesvdm.thymeleafbasicos.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaquinaHeladosDTO {
   private int porcChoco;
   private int porcFresa;
   private int porcVainilla;
}
