package com.guild.mannagent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name= "tb_missao")
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "missao_id")
    private Long missaoId;

    @Column
    private String nome;

    @Column
    private Long rank;
}
