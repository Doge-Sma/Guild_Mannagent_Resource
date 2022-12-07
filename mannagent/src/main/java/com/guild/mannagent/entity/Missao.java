package com.guild.mannagent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Long id;

    @Column
    private String nome;

    @Column
    private Long rank;
}
