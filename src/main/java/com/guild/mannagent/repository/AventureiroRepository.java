package com.guild.mannagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guild.mannagent.entity.Aventureiro;

public interface AventureiroRepository extends JpaRepository <Aventureiro, Long> {
    
}
