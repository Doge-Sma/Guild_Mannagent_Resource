package com.guild.mannagent.entity;

import java.util.Collection;

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
private Long rank;

@Column
private Long tamanho;

@OneToOne
@JoinColumn(name = "id_Aventureiro")
private Aventureiro aventureiro;

@OneToMany(mappedBy = "inventario")
private Collection<Item> itens;

@OneToMany(mappedBy = "inventarioEquipado")
private Collection<Item> itensEquipados;



}
