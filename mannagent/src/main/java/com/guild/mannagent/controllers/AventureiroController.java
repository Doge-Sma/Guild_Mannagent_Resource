package com.guild.mannagent.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.mannagent.dto.AventureiroDTO;
import com.guild.mannagent.entity.Aventureiro;
import com.guild.mannagent.services.AventureiroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/aventureiros")
@AllArgsConstructor
@Api(description = "Aventureiro Services HTTP methods", tags = "Aventureiro Services")
public class AventureiroController {

    AventureiroService aventureiroService;
    ModelMapper modelMapper;
    
    @ApiOperation(value = "Find all Aventureiros")
    @GetMapping
    public ResponseEntity<List<AventureiroDTO>> findallAventureiros(){
        return ResponseEntity.ok(convertListDTO(aventureiroService.listAventureiros()));
    }



    public List<AventureiroDTO> convertListDTO(List<Aventureiro> aventureiros){
        List<AventureiroDTO> save = new ArrayList();
        aventureiros.forEach(aventureiro ->{
            save.add(convertDTO(aventureiro));
        });

        return save;
    }

    public AventureiroDTO convertDTO(Aventureiro aventureiro){
        return modelMapper.map(aventureiro, AventureiroDTO.class);
    }

    public Aventureiro convertEntity(AventureiroDTO aventureiroDTO){
        return modelMapper.map(aventureiroDTO, Aventureiro.class);
    }

}
