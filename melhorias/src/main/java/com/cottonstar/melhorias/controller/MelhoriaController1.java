package com.cottonstar.melhorias.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MelhoriaController1 {

    // Usuario passa TITULO, TIPO e DEPARTAMENTO
    @RequestMapping("/cadastrar-melhoria")
    public String cadastrarMelhoria(){
        return "Cadastrado";
    }
}