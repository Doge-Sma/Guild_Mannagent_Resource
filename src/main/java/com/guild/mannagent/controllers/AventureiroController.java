package com.guild.mannagent.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.mannagent.dto.AventureiroDTO;
import com.guild.mannagent.entity.Aventureiro;
import com.guild.mannagent.services.AventureiroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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

    @ApiOperation(value = "Find Aventureiro by Id")
    @GetMapping("/{id}")
    public ResponseEntity<AventureiroDTO> encontrarAventureiroPorId(@PathVariable Long id){
        return ResponseEntity.ok(convertDTO(aventureiroService.buscarAventureiroPorId(id)));
    }

    @ApiOperation(value = "Save Aventureiro")
    @PostMapping
    public ResponseEntity<AventureiroDTO> salvarAventureiro(@Valid @RequestBody AventureiroDTO aventureiroDTO){
        Aventureiro aventureiro = convertEntity(aventureiroDTO);
        Aventureiro salvo = aventureiroService.createAventureiro(aventureiro);
        return new ResponseEntity<AventureiroDTO>(convertDTO(salvo), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update Aventureiro")
    @PutMapping("/{id}")
    public ResponseEntity<AventureiroDTO> atualizarAventureiro(@Valid @RequestBody AventureiroDTO aventureiroDTO, @PathVariable Long id){
        Aventureiro aventureiro = convertEntity(aventureiroDTO);
        Aventureiro atualizado = aventureiroService.updateAventureiro(aventureiro, id);
        return ResponseEntity.ok(convertDTO(atualizado));
    }





    public List<AventureiroDTO> convertListDTO(List<Aventureiro> aventureiros){
        List<AventureiroDTO> save = new ArrayList<>();
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
