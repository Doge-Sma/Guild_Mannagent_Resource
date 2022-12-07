package com.guild.mannagent.controllers;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.mannagent.dto.AdministradorDTO;
import com.guild.mannagent.dto.GuildaDTO;
import com.guild.mannagent.entity.Administrador;
import com.guild.mannagent.entity.Guilda;
import com.guild.mannagent.services.AdministradorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/administradores")
@AllArgsConstructor
@Api(description = "Admin Services HTTP methods", tags = "Admin Services")
public class AdministradorController {
    AdministradorService administradorService;
    ModelMapper modelMapper;
    
    @ApiOperation(value = "Find all Administradores")
    @GetMapping
    public ResponseEntity<List<AdministradorDTO>> listarAdministradores (){
        return ResponseEntity.ok(convertListDTO(administradorService.listarAdministradores()));
    }

    @ApiOperation(value = "Find Administrador by Id")
    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDTO> buscarAdministradorPorID(@PathVariable Long id){
        return ResponseEntity.ok(convertDTO(administradorService.encontrarAdministradorPorId(id)));
    }

    @ApiOperation(value = "List guildas by Administrador")
    @GetMapping("/{id}/guilda/")
    public ResponseEntity<List<GuildaDTO>> listarGuildasDoAdminsitrador(@PathVariable Long id){
        return ResponseEntity.ok(convertListGuildaDTO(administradorService.listarGuildasDeAdministrador(id)));
    }


    @ApiOperation(value = "List Administradores by Guilda")
    @GetMapping("/guilda/{id}")
    public ResponseEntity<List<AdministradorDTO>> listarAdministradoresDaGuilda(@PathVariable Long id){
        return ResponseEntity.ok(convertListDTO(administradorService.listarAdministradoresDaGuilda(id)));
    }

    @ApiOperation(value = "Save Administrador")
    @PostMapping
    public ResponseEntity<AdministradorDTO> salvarAdministrador(@RequestBody AdministradorDTO administradorDTO){
        Administrador administrador = convertEntity(administradorDTO);
        Administrador salvo = administradorService.cadastrarAdministrador(administrador);
        return new ResponseEntity<AdministradorDTO>(convertDTO(salvo), HttpStatus.CREATED);
    }

    @ApiOperation (value = "Update Administrador")
    @PutMapping("/{id}")
    public ResponseEntity<AdministradorDTO> atualizarAdministrador(@RequestBody AdministradorDTO administradorDTO, @PathVariable Long id){
        Administrador administrador = convertEntity(administradorDTO);
        Administrador atualizado = administradorService.atualizarAdministrador(id, administrador);
        return ResponseEntity.ok(convertDTO(atualizado));
    }

    @ApiOperation(value = "Remove Administrador")
    @DeleteMapping("/{id}")
    public ResponseEntity removerAdministrador(@PathVariable Long id){
        administradorService.deletarAdministrador(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Remove Guilda from Administrador")
    @DeleteMapping("{id_Administrador}/guilda/{id_Guilda}")
    public ResponseEntity removerGuildaDeAdministrador(@PathVariable Long id_Administrador, Long id_Guilda){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }



    public List<GuildaDTO> convertListGuildaDTO(List<Guilda> guildas){
        List<GuildaDTO> save = new ArrayList();
        guildas.forEach(guilda ->{
            save.add(convertGuildaDTO(guilda));
        });

        return save;
    }

    public GuildaDTO convertGuildaDTO(Guilda guilda){
        return modelMapper.map(guilda, GuildaDTO.class);
    }

    public List<AdministradorDTO> convertListDTO(List<Administrador> administradores){
        List<AdministradorDTO> save = new ArrayList();
        administradores.forEach(administrador ->{
            save.add(convertDTO(administrador));
        });

        return save;
    }

    public AdministradorDTO convertDTO(Administrador administrador){
        return modelMapper.map(administrador, AdministradorDTO.class);
    }

    public Administrador convertEntity(AdministradorDTO administradorDTO){
        return modelMapper.map(administradorDTO, Administrador.class);
    }
}
