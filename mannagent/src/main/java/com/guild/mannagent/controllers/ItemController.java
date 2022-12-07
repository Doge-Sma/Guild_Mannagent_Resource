package com.guild.mannagent.controllers;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.mannagent.dto.ItemDTO;
import com.guild.mannagent.entity.Item;
import com.guild.mannagent.services.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/itens")
@AllArgsConstructor
@Api(description = "Item Services HTTP methods", tags = "Item Services")
public class ItemController {
    ItemService itemService;
    ModelMapper modelMapper;


    @ApiOperation(value = "Find all Itens")
    @GetMapping
    public ResponseEntity<List<ItemDTO>> listarItens (){
        return ResponseEntity.ok(convertListDTO(itemService.listarItens()));
    }

    @ApiOperation(value = "Encontrar Item por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> encontrarItemPorId(@PathVariable Long id){
        return ResponseEntity.ok(convertDTO(itemService.buscarItemPorId(id)));
    }


    @ApiOperation(value = "Criar Item")
    @PostMapping
    public ResponseEntity<ItemDTO> salvarItem(@RequestBody ItemDTO itemDTO){
        Item item = convertEntity(itemDTO);
        Item salvo = itemService.criarItem(item);
        return new ResponseEntity<ItemDTO>(convertDTO(salvo),HttpStatus.CREATED);
    }

    @ApiOperation(value = "Comprar Item")
    @GetMapping( "/{id_Item}/aventureiros/{id_Aventureiro}/")
    public ResponseEntity<ItemDTO> comprarItem(@PathVariable Long id_Item, @PathVariable Long id_Aventureiro){
        return ResponseEntity.ok(convertDTO(itemService.buyItem(id_Aventureiro, id_Item)));
    }





    public List<ItemDTO> convertListDTO(List<Item> itens){
        List<ItemDTO> save = new ArrayList();
        itens.forEach(item ->{
            save.add(convertDTO(item));
        });

        return save;
    }

    public ItemDTO convertDTO(Item item){
        return modelMapper.map(item, ItemDTO.class);
    }

    public Item convertEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, Item.class);
    }
}
