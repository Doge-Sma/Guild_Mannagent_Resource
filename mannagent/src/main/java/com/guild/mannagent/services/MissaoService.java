package com.guild.mannagent.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guild.mannagent.entity.Missao;
import com.guild.mannagent.repository.MissaoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MissaoService {
    MissaoRepository missaoRepository;

    public List<Missao> listarMissoes(){
        return missaoRepository.findAll();
    }
}
