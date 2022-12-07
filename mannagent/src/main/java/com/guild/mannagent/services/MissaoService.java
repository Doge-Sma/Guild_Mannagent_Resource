package com.guild.mannagent.services;

import org.springframework.stereotype.Service;

import com.guild.mannagent.repository.MissaoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MissaoService {
    MissaoRepository missaoRepository;
}
