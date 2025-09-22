package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.dto.UsuarioCreateDTO;
import com.cottonstar.melhorias.dto.UsuarioDTO;
import com.cottonstar.melhorias.model.Usuario;
import com.cottonstar.melhorias.model.enums.PerfilAcesso;
import com.cottonstar.melhorias.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public UsuarioDTO criar(UsuarioCreateDTO usuarioCreateDTO) {
        // Validação de email existente (continua igual)
        if (usuarioRepository.findByEmail(usuarioCreateDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Este email já está em uso.");
        }

        // REGRA 1: Extrai o nome de usuário do email
        String email = usuarioCreateDTO.getEmail();
        String nomeDeUsuario = email.split("@")[0];

        // Validação de nome de usuário existente (agora usando o valor gerado)
        if (usuarioRepository.findByUsuario(nomeDeUsuario).isPresent()) {
            throw new RuntimeException("Este nome de usuário (derivado do email) já está em uso.");
        }

        // Mapeamento do DTO para a Entidade com as novas regras
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(usuarioCreateDTO.getNome());
        novoUsuario.setEmail(email);
        novoUsuario.setUsuario(nomeDeUsuario); // Atribui o usuário gerado

        // REGRA 2: Define o perfil fixo como COLABORADOR
        novoUsuario.setPerfil(PerfilAcesso.COLABORADOR);

        // Hashing da senha (continua igual)
        String senhaCodificada = passwordEncoder.encode(usuarioCreateDTO.getSenha());
        novoUsuario.setSenhaHash(senhaCodificada);

        // Salva no banco (continua igual)
        Usuario usuarioSalvo = usuarioRepository.save(novoUsuario);

        // Retorna o DTO de resposta (continua igual)
        return new UsuarioDTO(usuarioSalvo);
    }
}