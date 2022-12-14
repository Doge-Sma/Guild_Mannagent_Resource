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

import com.guild.mannagent.dto.InventarioDTO;
import com.guild.mannagent.dto.ItemDTO;
import com.guild.mannagent.entity.Inventario;
import com.guild.mannagent.entity.Item;
import com.guild.mannagent.services.InventarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/inventarios")
@AllArgsConstructor
@Api(description = "Inventario Services HTTP methods", tags = "Inventario Services")
public class InventarioController {
    InventarioService inventarioService;
    ModelMapper modelMapper;


    @ApiOperation(value = "Find all Inventarios")
    @GetMapping
    public ResponseEntity<List<InventarioDTO>> listarInventarios (){
        return ResponseEntity.ok(convertListDTO(inventarioService.listarInventarios()));
    }

    @ApiOperation(value = "Buscar Item de Aventureiro")
    @GetMapping("/aventureiro/{id_Aventureiro}/item/{id_Item}")
    public ResponseEntity<ItemDTO> buscarItemDoAventureiro(@PathVariable Long id_Aventureiro, @PathVariable Long id_Item){
        return ResponseEntity.ok(convertItemDTO(inventarioService.buscarItem(id_Aventureiro, id_Item)));
    }

    @ApiOperation(value = "Listar todos os itens equipados de um aventureiro")
    @GetMapping("/inventarios/aventureiro/{id}/equipado")
    public ResponseEntity<List<ItemDTO>> listarItensEquipados(@PathVariable Long id){
        return ResponseEntity.ok(convertListItemDTO(inventarioService.listarItensEquipados(id)));
    }

    @ApiOperation(value = "Listar todos os itens de um aventureiro")
    @GetMapping("/inventarios/aventureiro/{id}/")
    public ResponseEntity<List<ItemDTO>> listarItens(@PathVariable Long id){
        return ResponseEntity.ok(convertListItemDTO(inventarioService.listarItensEquipados(id)));
    }

    @ApiOperation(value = "Melhorar Inventario")
    @PutMapping("{id}")
    public ResponseEntity<InventarioDTO> melhorarInventario(@Valid @PathVariable Long id, @RequestBody InventarioDTO inventarioDTO){
        Inventario inventario = convertEntity(inventarioDTO);
        Inventario salvo = inventarioService.updateInventario(inventario, id);
        return ResponseEntity.ok(convertDTO(salvo));
    }


    
    public List<InventarioDTO> convertListDTO(List<Inventario> inventarios){
        List<InventarioDTO> save = new ArrayList<>();
        inventarios.forEach(inventario ->{
            save.add(convertDTO(inventario));
        });

        return save;
    }

    public InventarioDTO convertDTO(Inventario inventario){
        return modelMapper.map(inventario, InventarioDTO.class);
    }

    public Inventario convertEntity(InventarioDTO inventarioDTO){
        return modelMapper.map(inventarioDTO, Inventario.class);
    }

    public List<ItemDTO> convertListItemDTO(List<Item> itens){
        List<ItemDTO> save = new ArrayList<>();
        itens.forEach(item ->{
            save.add(convertItemDTO(item));
        });

        return save;
    }

    public ItemDTO convertItemDTO(Item item){
        return modelMapper.map(item, ItemDTO.class);
    }


}
