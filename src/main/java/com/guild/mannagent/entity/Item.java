package com.guild.mannagent.entity;

import java.util.Collection;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name= "tb_item")
public class Item {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "item_id")
private Long id;

@Column
@NotBlank
private String nome;

@Column
@NotNull
private Long rank;

@Column 
@Min(value = 0)
private Long valor;

@ManyToOne
@JoinColumn(name = "iventario_id")
private Inventario inventario;

@ManyToOne
@JoinColumn(name = "inventarioEquipado_id")
private Inventario inventarioEquipado;

@ManyToMany
@JoinTable(name = "LojasItens", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "id_Loja"))
private Collection<Loja> lojasPertencentes;

}
