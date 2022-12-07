package com.guild.mannagent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

@ManyToOne
@JoinColumn(name = "item_id")
private Item item;

}
