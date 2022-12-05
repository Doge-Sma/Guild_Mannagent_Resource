package com.guild.mannagent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guild.mannagent.repository.AventureiroRepository;
import com.guild.mannagent.entity.Aventureiro;

import java.util.List;
import java.util.Optional;

@Service
public class AventureiroService {
    @Autowired
    private AventureiroRepository aventureiroRepository;

/* cadastrar aventureiro
atualizar aventureiro
listar aventureiro */

public List<Aventureiro> listAventureiros(){
    return aventureiroRepository.findAll();
}

public Aventureiro createAventureiro (Aventureiro aventureiro){
    return this.aventureiroRepository.save(aventureiro);
}

public Aventureiro updateAventureiro (Aventureiro aventureiro, Long aventureiroId){
    Optional<Aventureiro> aventureiroTemp = this.aventureiroRepository.findById(aventureiroId);
        if(aventureiroTemp.isPresent()){
            Aventureiro a = aventureiroTemp.get();
            a.setNome(aventureiro.getNome());
            a.setClasse(aventureiro.getClasse());
            a.setCarteira(aventureiro.getCarteira());
            a.setRank(aventureiro.getRank());
            return this.aventureiroRepository.save(a);
        }
        return null;
}

}
