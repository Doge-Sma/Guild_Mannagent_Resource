package com.guild.mannagent.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guild.mannagent.entity.Funcionario;
import com.guild.mannagent.repository.FuncionarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {
    FuncionarioRepository funcionarioRepository;

    public Funcionario cadastrarFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Funcionario encontrarFuncionarioPorId(Long id){
        return funcionarioRepository.findById(id).get();
    }
}
