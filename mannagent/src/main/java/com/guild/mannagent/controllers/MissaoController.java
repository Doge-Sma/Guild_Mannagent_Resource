package com.guild.mannagent.controllers;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.mannagent.dto.MissaoDTO;
import com.guild.mannagent.entity.Missao;
import com.guild.mannagent.services.MissaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/missoes")
@AllArgsConstructor
@Api(description = "Missao Services HTTP methods", tags = "Missao Services")
public class MissaoController {
    MissaoService missaoService;
    ModelMapper modelMapper;
    

    @ApiOperation(value = "Find all Missoes")
    @GetMapping
    public ResponseEntity<List<MissaoDTO>> listarMissoes (){
        return ResponseEntity.ok(convertListDTO(missaoService.listarMissoes()));
    }

    public List<MissaoDTO> convertListDTO(List<Missao> missoes){
        List<MissaoDTO> save = new ArrayList();
        missoes.forEach(missao ->{
            save.add(convertDTO(missao));
        });

        return save;
    }

    public MissaoDTO convertDTO(Missao missao){
        return modelMapper.map(missao, MissaoDTO.class);
    }

    public Missao convertEntity(MissaoDTO missaoDTO){
        return modelMapper.map(missaoDTO, Missao.class);
    }
}
