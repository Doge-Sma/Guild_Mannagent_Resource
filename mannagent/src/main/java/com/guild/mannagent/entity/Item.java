package com.guild.mannagent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name= "tb_item")
public class Item {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "item_id")
private Long inventarioId;

@Column
private String nome;

@Column
private Long rank;

@Column 
private Long valor;

@OneToMany(mappedBy = "item")
private Collection<Inventario> inventario;

}
