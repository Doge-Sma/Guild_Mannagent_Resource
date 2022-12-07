package com.guild.mannagent.controllers;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.mannagent.dto.GuildaDTO;
import com.guild.mannagent.entity.Guilda;
import com.guild.mannagent.services.GuildaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/guildas")
@AllArgsConstructor
@Api(description = "Guilda Services HTTP methods", tags = "Guilda Services")
public class GuildaController {
    GuildaService guildaService;
    ModelMapper modelMapper;

    @ApiOperation(value = "Find all Guildas")
    @GetMapping
    public ResponseEntity<List<GuildaDTO>> listarGuildas (){
        return ResponseEntity.ok(convertListDTO(guildaService.listarGuildas()));
    }

    public List<GuildaDTO> convertListDTO(List<Guilda> guildas){
        List<GuildaDTO> save = new ArrayList();
        guildas.forEach(guilda ->{
            save.add(convertDTO(guilda));
        });

        return save;
    }

    public GuildaDTO convertDTO(Guilda guilda){
        return modelMapper.map(guilda, GuildaDTO.class);
    }

    public Guilda convertEntity(GuildaDTO guildaDTO){
        return modelMapper.map(guildaDTO, Guilda.class);
    }

}
