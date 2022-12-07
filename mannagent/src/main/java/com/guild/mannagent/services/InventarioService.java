package com.guild.mannagent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guild.mannagent.entity.Inventario;
import com.guild.mannagent.repository.InventarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

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


}
