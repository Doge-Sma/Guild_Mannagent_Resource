package com.guild.mannagent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guild.mannagent.repository.AventureiroRepository;

@Service
public class AventureiroService {
    @Autowired
    private AventureiroRepository aventureiroRepository;
}
