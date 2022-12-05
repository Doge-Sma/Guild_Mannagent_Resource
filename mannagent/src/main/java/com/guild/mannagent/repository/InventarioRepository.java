package com.guild.mannagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guild.mannagent.entity.Inventario;

public interface InventarioRepository extends JpaRepository <Inventario, Long>{
    
}
