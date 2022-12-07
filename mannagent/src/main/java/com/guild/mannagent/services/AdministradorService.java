package com.guild.mannagent.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guild.mannagent.entity.Administrador;
import com.guild.mannagent.repository.AdministradorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdministradorService {
    AdministradorRepository administradorRepository;
    
    public Administrador cadastrarAdministrador(Administrador administrador){
        return administradorRepository.save(administrador);
    }

    public List<Administrador> listarAdministradores(){
        return administradorRepository.findAll();
    }

    public Administrador encontrarAdministradorPorId(Long id){
        return administradorRepository.findById(id).get();
    }

    
}
