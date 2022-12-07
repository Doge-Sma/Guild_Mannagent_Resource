package com.guild.mannagent.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guild.mannagent.entity.Aventureiro;
import com.guild.mannagent.services.AventureiroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/aventureiros")
@AllArgsConstructor
@Api(description = "Admin Services HTTP methods", tags = "Admin Services")
public class AventureiroController {

    AventureiroService aventureiroService;
    
    @ApiOperation(value = "Find all Aventureiros")
    @GetMapping
    public ResponseEntity<List<Aventureiro>> findallAventureiros(){
        return ResponseEntity.ok(aventureiroService.listAventureiros());
    }

}
