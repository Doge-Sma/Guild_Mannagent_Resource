package com.guild.mannagent.entity;

import java.util.Collection;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name= "tb_inventario")
public class Inventario {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "inventario_id")
private Long Id;

@Column
@Min(value = 1)
private Long rank;

@Column
@Min(value = 16)
@Max(value = 32)
private Long tamanho;

@OneToOne
@JoinColumn(name = "id_Aventureiro")
@NotNull
private Aventureiro aventureiro;

@OneToMany(mappedBy = "inventario")
private Collection<Item> itens;

@OneToMany(mappedBy = "inventarioEquipado")
private Collection<Item> itensEquipados;



}
