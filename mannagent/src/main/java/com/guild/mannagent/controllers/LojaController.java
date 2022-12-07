package com.guild.mannagent.controllers;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.mannagent.dto.LojaDTO;
import com.guild.mannagent.entity.Loja;
import com.guild.mannagent.services.LojaService;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/lojas")
@AllArgsConstructor
@Api(description = "Loja Services HTTP methods", tags = "Loja Services")
public class LojaController {
    LojaService lojaService;
    ModelMapper modelMapper;

    public List<LojaDTO> convertListDTO(List<Loja> lojas){
        List<LojaDTO> save = new ArrayList();
        lojas.forEach(loja ->{
            save.add(convertDTO(loja));
        });

        return save;
    }

    public LojaDTO convertDTO(Loja loja){
        return modelMapper.map(loja, LojaDTO.class);
    }

    public Loja convertEntity(LojaDTO lojaDTO){
        return modelMapper.map(lojaDTO, Loja.class);
    }
}
