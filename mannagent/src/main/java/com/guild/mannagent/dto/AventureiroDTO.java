package com.guild.mannagent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AventureiroDTO {
    private Long id;
    private String nome;
    private String classe;
    private Long carteira;
    private Long Rank;

}
