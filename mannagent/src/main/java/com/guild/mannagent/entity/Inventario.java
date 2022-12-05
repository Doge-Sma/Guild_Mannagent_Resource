package com.guild.mannagent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
private Long inventarioId;

@Column
private Long rank;

@Column
private Long tamanho;
    
}
