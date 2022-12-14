package com.guild.mannagent.repository;

import com.guild.mannagent.entity.Guilda;
import com.guild.mannagent.entity.Missao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository <Missao,Long>{
    public List<Missao> findByGuilda(Guilda guilda);
}
