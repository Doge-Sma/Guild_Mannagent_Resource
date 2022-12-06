package com.guild.mannagent.services;

import com.guild.mannagent.entity.Aventureiro;
import com.guild.mannagent.entity.Inventario;
import com.guild.mannagent.entity.Item;
import com.guild.mannagent.repository.AventureiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guild.mannagent.repository.ItemRepository;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private  ItemRepository itemRepository;
    @Autowired
    private AventureiroRepository aventureiroRepository;

/*
Comprar Item -> ver se tem money na carteira de aventureiro
Equipar Item 
Buscar item de aventureiro
Cadastrar Item
Melhorar Item
*/

    public Item buyItem(Long aventureiroId, Long itemId){
        Optional<Aventureiro> aventureiroOptional = this.aventureiroRepository.findById(aventureiroId)
        if(!aventureiroOptional.isPresent()){
            return null; //adicionar tratamento de erros, o erro tem ser 404, user not found
        }
        return null;
    }

    
}
