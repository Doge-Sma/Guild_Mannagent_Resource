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

import com.guild.mannagent.dto.MissaoDTO;
import com.guild.mannagent.entity.Missao;
import com.guild.mannagent.services.MissaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

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

    @ApiOperation(value = "Find Missao by Id")
    @GetMapping("/{id}")
    public ResponseEntity<MissaoDTO> buscarMissaoPorId(@PathVariable Long id){
        return ResponseEntity.ok(convertDTO(missaoService.buscarMissaoPorId(id)));
    }

    @ApiOperation(value = "Find Missoes by Guilda id")
    @GetMapping("/guilda/{id}")
    public ResponseEntity<List<MissaoDTO>> buscarMissoesPorGuildaId(@PathVariable Long id){
        return ResponseEntity.ok(convertListDTO(missaoService.encontrarMissaoPorGuildaId(id)));
    }

    @ApiOperation(value = "Find Missoes by Status from a guild Id")
    @GetMapping("{status}/guilda/{id}")
    public ResponseEntity<List<MissaoDTO>> buscarMissoesPorStatusPorGuilda(@PathVariable String status, @PathVariable Long id){
        return ResponseEntity.ok(convertListDTO(missaoService.encontrarMissaoPorStatus(status, id)));
    }

    @ApiOperation(value ="Save Missao")
    @PostMapping
    public ResponseEntity<MissaoDTO> salvarMissao(@Valid @RequestBody MissaoDTO missaoDTO){
        Missao missao = convertEntity(missaoDTO);
        Missao salvo = missaoService.salvarMissao(missao);
        return new ResponseEntity<MissaoDTO>(convertDTO(salvo),HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update Missao")
    @PutMapping("/{id}")
    public ResponseEntity<MissaoDTO> atualizarMissao(@Valid @RequestBody MissaoDTO missaoDTO, @PathVariable Long id){
        Missao missao = convertEntity(missaoDTO);
        Missao atualizada = missaoService.alterarMissao(missao, id);
        return ResponseEntity.ok(convertDTO(atualizada));
    }



    public List<MissaoDTO> convertListDTO(List<Missao> missoes){
        List<MissaoDTO> save = new ArrayList<>();
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
