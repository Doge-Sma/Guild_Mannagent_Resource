package com.guild.mannagent.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guild.mannagent.entity.Guilda;
import com.guild.mannagent.entity.Missao;
import com.guild.mannagent.exception.MissaoNotFoundException;
import com.guild.mannagent.repository.MissaoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MissaoService {
    MissaoRepository missaoRepository;
    GuildaService guildaService;

    public List<Missao> listarMissoes(){
        return missaoRepository.findAll();
    }

    public Missao buscarMissaoPorId(Long id){
        return missaoRepository.findById(id).orElseThrow(() -> new MissaoNotFoundException("Missao " + id + " não encontrada"));
    }

    public Missao salvarMissao(Missao missao){
        return missaoRepository.save(missao);
    }

    public Missao alterarMissao(Missao missao, Long id){
        Optional<Missao> missaoTemp = missaoRepository.findById(id);

        if(missaoTemp.isPresent()){
            Missao atualizada = missaoTemp.get();
            atualizada.setNome(missao.getNome());
            atualizada.setRank(missao.getRank());
            atualizada.setStatus(missao.getStatus());
            atualizada.setGuilda(missao.getGuilda());
            return missaoRepository.save(atualizada);
        }
        return null;
    }


    public List<Missao> encontrarMissaoPorGuildaId(Long id){
        Guilda guilda = guildaService.buscarGuildaPorId(id);
        return missaoRepository.findByGuilda(guilda);
    }

    public List<Missao> encontrarMissaoPorStatus(String status, Long idGuilda){
        List<Missao> missoes = encontrarMissaoPorGuildaId(idGuilda);
        List<Missao> encontradas = new ArrayList<>();
        missoes.forEach(missao ->{
            if(missao.getStatus().equals(status)){
                encontradas.add(missao);
            }
        });

        return encontradas;
    }


}
