package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.model.Melhoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                     // Passa que é controller
@RequestMapping("melhoria")         // Define a rota
public class MelhoriaController {

    public void salvar(Melhoria melhoria){
        System.out.println("Melhoria cadastrada: " + melhoria);
    }
}
