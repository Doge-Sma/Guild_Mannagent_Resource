package com.guild.mannagent.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/inventarios")
@AllArgsConstructor
@Api(description = "Inventario Services HTTP methods", tags = "Inventario Services")
public class InventarioController {
    
}
