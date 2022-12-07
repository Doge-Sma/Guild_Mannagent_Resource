package com.guild.mannagent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guild.mannagent.entity.Funcionario;
import com.guild.mannagent.entity.Guilda;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    public List<Funcionario> findByGuilda(Guilda guilda);
    
}
