package com.guild.mannagent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoDTO {
    private Long id;
    private String nome;
    private Long rank;
    private Long idGuilda;
}
