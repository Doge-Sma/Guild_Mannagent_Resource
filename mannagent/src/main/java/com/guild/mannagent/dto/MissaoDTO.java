package com.guild.mannagent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoDTO {
    private Long id;
    @NotBlank
    private String nome;
    @Min(value = 1)
    private Long rank;
    @NotNull
    private Long idGuilda;
}
