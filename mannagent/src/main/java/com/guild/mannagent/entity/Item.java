package com.guild.mannagent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
