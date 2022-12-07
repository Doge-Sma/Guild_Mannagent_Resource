package com.guild.mannagent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guild.mannagent.entity.Item;
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

    public Loja atualizarLoja(Loja loja, Long id){
        Optional<Loja> lojaTemp = lojaRepository.findById(id);
        if(lojaTemp.isPresent()){
            Loja atualizada = lojaTemp.get();

            atualizada.setNome(loja.getNome());
            atualizada.setRank(loja.getRank());

            return lojaRepository.save(atualizada);
        }
        return null;
    }

    public List<Item> listarItensDaloja(Long id){
        return (List<Item>) buscarLojaPorId(id).getItensLojas();
    }


}
