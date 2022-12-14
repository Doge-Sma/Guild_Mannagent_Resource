package com.guild.mannagent.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long id;
    @NotBlank
    private String nome;
    @Min(value = 0)
    private Long valor;
    @NotNull
    private Long rank;
}
