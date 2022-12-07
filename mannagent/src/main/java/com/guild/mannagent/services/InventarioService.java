package com.guild.mannagent.services;

import org.springframework.stereotype.Service;

import com.guild.mannagent.entity.Aventureiro;
import com.guild.mannagent.entity.Inventario;
import com.guild.mannagent.entity.Item;
import com.guild.mannagent.repository.InventarioRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InventarioService {

    private InventarioRepository inventarioRepository;
    private AventureiroService aventureiroService;
    private ItemService itemService;

    public List<Inventario> listarInventarios(){
        return inventarioRepository.findAll();
    }
    
    //Melhorar Inventario
    public Inventario updateInventario (Inventario inventario, Long inventarioId){
        Optional<Inventario> inventarioTemp = this.inventarioRepository.findById(inventarioId);
            if(inventarioTemp.isPresent()){
                Inventario i = inventarioTemp.get();
                i.setTamanho(inventario.getTamanho()+1);
                return this.inventarioRepository.save(i);
            }
            return null;
    }

    public Item buscarItem(Long idAventureiro, Long idItem){
        Inventario iventario = aventureiroService.buscarAventureiroPorId(idAventureiro).getInventario();

        if(iventario.getItens().contains(itemService.buscarItemPorId(idItem))){
            return itemService.buscarItemPorId(idItem);
        }
        return null;
    }

    public List<Item> listarItensdeAventureiro(Long idAventureiro){
        Aventureiro aventureiro = aventureiroService.buscarAventureiroPorId(idAventureiro);
        return (List<Item>) inventarioRepository.findByAventureiro(aventureiro).getItens();
    }

    public List<Item> listarItensEquipados(Long idAventureiro){
        Aventureiro aventureiro = aventureiroService.buscarAventureiroPorId(idAventureiro);
        return (List<Item>) inventarioRepository.findByAventureiro(aventureiro).getItensEquipados();
    }




}
