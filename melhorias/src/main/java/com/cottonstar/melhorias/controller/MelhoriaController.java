package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.service.MelhoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastrar-melhoria")
public class MelhoriaController {

    //---------------------
    private final MelhoriaService melhoriaService;

    public MelhoriaController(MelhoriaService melhoriaService) {
        this.melhoriaService = melhoriaService;

    }
    //---------------------

    // PEGA INFO E LISTA
    @GetMapping
    public List<Melhoria> getAll() {
        return melhoriaService.getAll();
    }

    // ENVIA INFO
    @PostMapping
    public Melhoria creat(@RequestBody Melhoria melhoria) {
        return melhoriaService.save(melhoria);
    }
}
