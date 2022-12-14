package com.guild.mannagent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotBlank
    private String nome;

    @Column
    @Min(value = 1)
    private Long rank;

    @Column
    @NotBlank
    private String status;

    @OneToOne
    @JoinColumn(name = "id_Guilda")
    @NotNull
    private Guilda guilda;

}
