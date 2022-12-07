package com.guild.mannagent.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.mannagent.dto.AdministradorDTO;
import com.guild.mannagent.entity.Administrador;
import com.guild.mannagent.services.AdministradorService;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/administradores")
@AllArgsConstructor
@Api(description = "Admin Services HTTP methods", tags = "Admin Services")
public class AdministradorController {
    AdministradorService administradorService;
    ModelMapper modelMapper;
    
    @GetMapping
    public ResponseEntity<List<AdministradorDTO>> listarAdministradores (){
        return ResponseEntity.ok(convertListDTO(administradorService.listarAdministradores()));
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
