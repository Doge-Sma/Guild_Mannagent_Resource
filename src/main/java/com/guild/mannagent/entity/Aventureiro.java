package com.guild.mannagent.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
@NotBlank
private String nome;

@Column(name = "classe")
@NotBlank
private String classe;

@Column(name = "carteira")
@Min(value = 0)
private Long carteira;

@Column(name = "rank")
@Min(value = 1)
private Long rank;

@OneToOne
@JoinColumn(name = "inventario_id")
private Inventario inventario;
    
}
