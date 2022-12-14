package com.guild.mannagent.controllers;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.mannagent.dto.GuildaDTO;
import com.guild.mannagent.entity.Guilda;
import com.guild.mannagent.services.GuildaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

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

    @ApiOperation(value = "Find Guilda by ID")
    @GetMapping("/{id}")
    public ResponseEntity<GuildaDTO> buscarGuildaPorId(@PathVariable Long id){
        return ResponseEntity.ok(convertDTO(guildaService.buscarGuildaPorId(id)));
    }

    @ApiOperation(value = "Save new Guilda")
    @PostMapping
    public ResponseEntity<GuildaDTO> salvarGuilda(@Valid @RequestBody GuildaDTO guildaDTO){
        Guilda guilda = convertEntity(guildaDTO);
        Guilda salvo = guildaService.cadastrarGuilda(guilda);
        return new ResponseEntity<GuildaDTO>(convertDTO(salvo), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an Guilda")
    @PutMapping("/{id}")
    public ResponseEntity<GuildaDTO> atualizarGuilda(@Valid @RequestBody GuildaDTO guildaDTO, @PathVariable Long id){
        Guilda guilda = convertEntity(guildaDTO);
        Guilda atualizado = guildaService.updateGuilda(id, guilda);
        return new ResponseEntity<GuildaDTO>(convertDTO(atualizado), HttpStatus.ACCEPTED);
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
