package com.guild.mannagent.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/guildas")
@AllArgsConstructor
@Api(description = "Guilda Services HTTP methods", tags = "Guilda Services")
public class GuildaController {
    
}
