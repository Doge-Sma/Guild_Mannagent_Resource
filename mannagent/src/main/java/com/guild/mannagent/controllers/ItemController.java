package com.guild.mannagent.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/itens")
@AllArgsConstructor
@Api(description = "Item Services HTTP methods", tags = "Item Services")
public class ItemController {
    
}
