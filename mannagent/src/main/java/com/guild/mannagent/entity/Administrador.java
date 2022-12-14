package com.guild.mannagent.entity;


import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Administrador {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Administrador")
    private Long id;
    @Column
    @NotBlank
    private String nome;
    @Column
    @NotBlank
    private String senha;
    @Column
    @Email
    private String email;

    @ManyToMany
    @JoinTable(name = "GuildasAdministradores", joinColumns = @JoinColumn(name = "id_Administrador"),inverseJoinColumns = @JoinColumn(name = "id_Guilda"))
    private Collection<Guilda> guildas;
}
