package com.guild.mannagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guild.mannagent.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    
}
