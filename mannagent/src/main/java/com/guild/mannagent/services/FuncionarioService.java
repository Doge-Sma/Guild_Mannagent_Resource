package com.guild.mannagent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guild.mannagent.entity.Funcionario;
import com.guild.mannagent.entity.Guilda;
import com.guild.mannagent.repository.FuncionarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {
    FuncionarioRepository funcionarioRepository;
    GuildaService guildaService;

    public Funcionario cadastrarFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Funcionario encontrarFuncionarioPorId(Long id){
        return funcionarioRepository.findById(id).get();
    }

    public List<Funcionario> encontrarFuncionariosPorGuildaID(Long id){
        Guilda guilda = guildaService.buscarGuildaPorId(id);
        return funcionarioRepository.findByGuilda(guilda);
    }

    public Funcionario alterarFuncionario(Funcionario funcionario, Long id){
        Optional<Funcionario> funcionarioTemp = funcionarioRepository.findById(id);
        if(funcionarioTemp.isPresent()){
            Funcionario atualizado = funcionarioTemp.get();
            atualizado.setCargo(funcionario.getCargo());
            atualizado.setGuilda(funcionario.getGuilda());
            atualizado.setNome(funcionario.getNome());
            return funcionarioRepository.save(atualizado);
        } 
        return null;
    }


}
