package com.guild.mannagent.controllers;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.mannagent.dto.FuncionarioDTO;
import com.guild.mannagent.entity.Funcionario;
import com.guild.mannagent.services.FuncionarioService;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/funcionarios")
@AllArgsConstructor
@Api(description = "Funcionarios Services HTTP methods", tags = "Funcionarios Services")
public class FuncionarioController {
    FuncionarioService funcionarioService;
    ModelMapper modelMapper;


    public List<FuncionarioDTO> convertListDTO(List<Funcionario> funcionarios){
        List<FuncionarioDTO> save = new ArrayList();
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
