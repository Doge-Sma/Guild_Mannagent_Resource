package com.guild.mannagent.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guild.mannagent.entity.Guilda;
import com.guild.mannagent.repository.GuildaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GuildaService {
    GuildaRepository guildaRepository;

    public Guilda cadastrarGuilda(Guilda guilda){
        return guildaRepository.save(guilda);
    }

    public List<Guilda> listarGuildas(){
        return guildaRepository.findAll();
    }

    public Guilda buscarGuildaPorId(Long id){
        return guildaRepository.findById(id).get();
    }
}
