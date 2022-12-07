package com.guild.mannagent.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/missoes")
@AllArgsConstructor
@Api(description = "Missao Services HTTP methods", tags = "Missao Services")
public class MissaoController {
    
}
