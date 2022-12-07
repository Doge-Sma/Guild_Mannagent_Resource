package com.guild.mannagent.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guild.mannagent.entity.Loja;
import com.guild.mannagent.repository.LojaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LojaService {
    LojaRepository lojaRepository;

    public Loja cadastrarLoja(Loja loja){
        return lojaRepository.save(loja);
    }

    public List<Loja> listarLojas(){
        return lojaRepository.findAll();
    }

    public Loja buscarLojaPorId(Long id){
        return lojaRepository.findById(id).get();
    }
}
