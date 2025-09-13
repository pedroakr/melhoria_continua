package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.model.Melhoria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastrar-melhoria")
public class MelhoriaController1 {

    // JOGA TITULO, DESCRIÇÃO, DEPARTAMENTO E STATUS PARA O CORPO DE MELHORIA CONTROLES
    @PostMapping
    public Melhoria salvar(@RequestBody Melhoria melhoria){
        System.out.println("Melhoria recebida: " + melhoria);
        return melhoria;
    }
}