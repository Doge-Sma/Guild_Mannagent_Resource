package com.guild.mannagent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guild.mannagent.entity.Administrador;
import com.guild.mannagent.entity.Guilda;
import com.guild.mannagent.repository.AdministradorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdministradorService {
    AdministradorRepository administradorRepository;
    GuildaService guildaService;
    
    public Administrador cadastrarAdministrador(Administrador administrador){
        return administradorRepository.save(administrador);
    }

    public List<Administrador> listarAdministradores(){
        return administradorRepository.findAll();
    }

    public Administrador encontrarAdministradorPorId(Long id){
        return administradorRepository.findById(id).get();
    }

    public Administrador atualizarAdministrador(Long id, Administrador administrador){
        Optional<Administrador> administradorTemp = administradorRepository.findById(id);
        if(administradorTemp.isPresent()){
            Administrador atualizado = administradorTemp.get();
            atualizado.setEmail(administrador.getEmail());
            atualizado.setNome(administrador.getNome());
            atualizado.setSenha(administrador.getSenha());

            return administradorRepository.save(atualizado);
        }
        return null;
    }

    public List<Guilda> listarGuildasDeAdministrador(Long id){
        return (List<Guilda>) encontrarAdministradorPorId(id).getGuildas();
    }

    public List<Administrador> listarAdministradoresDaGuilda(Long id){
        return (List<Administrador>) guildaService.buscarGuildaPorId(id).getAdministradores();
    }

    public void deletarAdministrador(Long id){
         administradorRepository.deleteById(id);
    }

    
}
