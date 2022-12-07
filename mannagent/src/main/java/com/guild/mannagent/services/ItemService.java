package com.guild.mannagent.services;

import com.guild.mannagent.entity.Aventureiro;
import com.guild.mannagent.entity.Item;
import com.guild.mannagent.repository.AventureiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guild.mannagent.repository.ItemRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {
    @Autowired
    private  ItemRepository itemRepository;
    @Autowired
    private AventureiroRepository aventureiroRepository;

/*
Comprar Item -> ver se tem money na carteira de aventureiro
Equipar Item -> update
Buscar item de aventureiro -> precisa de list
Cadastrar Item
Melhorar Item
*/

    public List<Item> listarItens(){
        return  itemRepository.findAll();
    }

    public Item buyItem(Long aventureiroId, Long itemId){
        Optional<Aventureiro> aventureiroOptional = this.aventureiroRepository.findById(aventureiroId);
        if(!aventureiroOptional.isPresent()){
            return null; //adicionar tratamento de erros, o erro tem ser 404, user not found
        }
        Optional<Item> itemOptional = this.itemRepository.findById(itemId);
        if(!itemOptional.isPresent()){
            return null; //adicionar tratamento de erros, o erro tem ser 404
        }
        Aventureiro aventureiro = aventureiroOptional.get();
        Item item = itemOptional.get();
        if (aventureiro.getCarteira()>=item.getValor()){
            return null; //diminuir valor da carteira teria que setar a qual inventario o item pertence
        }

        return null;
    }

    
}
