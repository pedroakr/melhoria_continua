package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.dto.UsuarioCreateDTO;
import com.cottonstar.melhorias.dto.UsuarioDTO;
import com.cottonstar.melhorias.model.Usuario;
import com.cottonstar.melhorias.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioDTO> criarUsuario(@Valid @RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioDTO novoUsuario = usuarioService.criar(usuarioCreateDTO);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    // --- CORREÇÃO APLICADA AQUI ---
    /*@GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarTodos();

        // Converte a lista de Entidades para uma lista de DTOs
        List<UsuarioDTO> usuariosDTO = usuarios.stream()
                .map(UsuarioDTO::new) // Utiliza o construtor do DTO
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuariosDTO);
    }*/

    /*@GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(usuario -> ResponseEntity.ok(new UsuarioDTO(usuario))) // Converte a Entidade para DTO
                .orElseGet(() -> ResponseEntity.notFound().build());
    }*/
}