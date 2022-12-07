package com.guild.mannagent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Table(name= "tb_aventureiro")
public class Aventureiro {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "aventureiro_id")
private Long id;

@Column(name = "nome")
private String nome;

@Column(name = "classe")
private String classe;

@Column(name = "carteira")
private Long carteira;

@Column(name = "rank")
private Long rank;

@OneToOne
@JoinColumn(name = "inventario_id")
private Inventario inventario;
    
}
