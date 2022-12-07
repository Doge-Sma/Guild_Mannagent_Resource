package com.guild.mannagent.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/funcionarios")
@AllArgsConstructor
@Api(description = "Funcionarios Services HTTP methods", tags = "Funcionarios Services")
public class FuncionarioController {
    
}
