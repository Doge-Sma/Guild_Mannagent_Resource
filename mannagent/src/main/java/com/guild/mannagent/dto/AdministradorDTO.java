package com.guild.mannagent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorDTO {
    public Long id;
    @NotBlank
    public String nome;
    @NotBlank
    public String senha;
    @Email
    public String email;
}
