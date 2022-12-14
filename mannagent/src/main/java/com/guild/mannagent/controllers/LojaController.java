package com.guild.mannagent.controllers;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.mannagent.dto.ItemDTO;
import com.guild.mannagent.dto.LojaDTO;
import com.guild.mannagent.entity.Item;
import com.guild.mannagent.entity.Loja;
import com.guild.mannagent.services.LojaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/lojas")
@AllArgsConstructor
@Api(description = "Loja Services HTTP methods", tags = "Loja Services")
public class LojaController {
    LojaService lojaService;
    ModelMapper modelMapper;


    @ApiOperation(value = "Find all Lojas")
    @GetMapping
    public ResponseEntity<List<LojaDTO>> listarLojas (){
        return ResponseEntity.ok(convertListDTO(lojaService.listarLojas()));
    }

    @ApiOperation(value = "Buscar Loja por Id")
    @GetMapping("/{id}")
    public ResponseEntity<LojaDTO> buscarLojaPorId(@PathVariable Long id){
        return ResponseEntity.ok(convertDTO(lojaService.buscarLojaPorId(id)));
    }

    @ApiOperation(value = "Listar Itens da Loja")
    @GetMapping("/{id}/itens") 
    public ResponseEntity<List<ItemDTO>> listarItensDaLoja(@PathVariable Long id){
        return ResponseEntity.ok(convertListItemDTO(lojaService.listarItensDaloja(id)));
    }

    @ApiOperation(value = "Atualizar Loja")
    @PutMapping("{id}")
    public ResponseEntity<LojaDTO> atualizarLoja(@Valid @PathVariable Long id, @RequestBody LojaDTO lojaDTO){
        Loja loja = convertEntity(lojaDTO);
        Loja salvo = lojaService.cadastrarLoja(loja);
        return ResponseEntity.ok(convertDTO(salvo));
    }

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

    public List<ItemDTO> convertListItemDTO(List<Item> itens){
        List<ItemDTO> save = new ArrayList();
        itens.forEach(item ->{
            save.add(convertItemDTO(item));
        });

        return save;
    }

    public ItemDTO convertItemDTO(Item item){
        return modelMapper.map(item, ItemDTO.class);
    }
}
