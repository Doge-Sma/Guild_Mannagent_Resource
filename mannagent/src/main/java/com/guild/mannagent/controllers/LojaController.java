package com.guild.mannagent.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/lojas")
@AllArgsConstructor
@Api(description = "Loja Services HTTP methods", tags = "Loja Services")
public class LojaController {
    
}
