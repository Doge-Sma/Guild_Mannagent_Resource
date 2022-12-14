package com.guild.mannagent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventarioDTO {
    private Long id;
    private Long tamanho; //falta aqui 
    @Min(value = 1)
    private Long rank;
    @NotNull
    private Long idAventureiro;

}
