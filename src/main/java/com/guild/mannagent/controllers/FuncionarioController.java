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

import com.guild.mannagent.dto.FuncionarioDTO;
import com.guild.mannagent.entity.Funcionario;
import com.guild.mannagent.services.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
@AllArgsConstructor
@Api(description = "Funcionarios Services HTTP methods", tags = "Funcionarios Services")
public class FuncionarioController {
    FuncionarioService funcionarioService;
    ModelMapper modelMapper;


    @ApiOperation(value = "Find all Funcionarios")
    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios (){
        return ResponseEntity.ok(convertListDTO(funcionarioService.listarFuncionarios()));
    }

    @ApiOperation(value = "Find Funcionario by Id")
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionarioPorId(@PathVariable Long id){
        return ResponseEntity.ok(convertDTO(funcionarioService.encontrarFuncionarioPorId(id)));
    }

    @ApiOperation(value = "Find all Funcionarios of Guilda by Id Guilda")
    @GetMapping("/guilda/{id}")
    public ResponseEntity<List<FuncionarioDTO>> buscarFuncionariosByGuildaId(@PathVariable Long idGuilda){
        return ResponseEntity.ok(convertListDTO(funcionarioService.encontrarFuncionariosPorGuildaID(idGuilda)));
    }

    @ApiOperation(value = "Save new Funcionario")
    @PostMapping
    public ResponseEntity<FuncionarioDTO> salvarFuncionario(@Valid @RequestBody FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = convertEntity(funcionarioDTO);
        Funcionario salvo = funcionarioService.cadastrarFuncionario(funcionario);
        return new ResponseEntity<FuncionarioDTO>(convertDTO(salvo), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update Funcionario")
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> atualizarFuncionario(@Valid @RequestBody FuncionarioDTO funcionarioDTO, @PathVariable Long id){
        Funcionario funcionario = convertEntity(funcionarioDTO);
        Funcionario atualizado = funcionarioService.alterarFuncionario(funcionario, id);
        return ResponseEntity.ok(convertDTO(atualizado));
    }

    public List<FuncionarioDTO> convertListDTO(List<Funcionario> funcionarios){
        List<FuncionarioDTO> save = new ArrayList<>();
        funcionarios.forEach(funcionario ->{
            save.add(convertDTO(funcionario));
        });

        return save;
    }

    public FuncionarioDTO convertDTO(Funcionario funcionario){
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }

    public Funcionario convertEntity(FuncionarioDTO funcionarioDTO){
        return modelMapper.map(funcionarioDTO, Funcionario.class);
    }


}
