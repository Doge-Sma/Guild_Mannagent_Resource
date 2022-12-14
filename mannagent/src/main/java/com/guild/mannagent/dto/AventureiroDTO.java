package com.guild.mannagent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AventureiroDTO {
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String classe;
    @Min(value = 0)
    private Long carteira;
    @Min(value = 1)
    private Long Rank;

}
