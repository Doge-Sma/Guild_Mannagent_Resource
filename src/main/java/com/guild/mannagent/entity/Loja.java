package com.guild.mannagent.entity;

import java.util.Collection;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loja {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Loja")
    private Long id;
    @Column
    @NotBlank
    private String Nome;
    @Column
    @Min(value = 1)
    private Long Rank;

    @ManyToMany(mappedBy = "lojasPertencentes")
    private Collection<Item> itensLojas;
    
}
