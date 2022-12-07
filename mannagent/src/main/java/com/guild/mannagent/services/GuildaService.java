package com.guild.mannagent.services;

import java.util.List;
import java.util.Optional;

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

    public Guilda updateGuilda(Long id, Guilda guilda){
        Optional<Guilda> guildaTemp = guildaRepository.findById(id);
        if(guildaTemp.isPresent()){
            Guilda guild = guildaTemp.get();
            guild.setNome(guilda.getNome());
            guild.setCarteira(guilda.getCarteira());
            guild.setRank(guilda.getRank());
            return guildaRepository.save(guild);
        }

        return null;
    }


}
