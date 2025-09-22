package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.dto.UsuarioCreateDTO;
import com.cottonstar.melhorias.dto.UsuarioDTO;
import com.cottonstar.melhorias.model.Supervisao;
import com.cottonstar.melhorias.model.Usuario;
import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.PerfilAcesso;
import com.cottonstar.melhorias.repository.SupervisaoRepository;
import com.cottonstar.melhorias.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final SupervisaoRepository supervisaoRepository;
    private final PasswordEncoder passwordEncoder;

    // CORREÇÃO 1: O construtor agora injeta todas as três dependências necessárias.
    public UsuarioService(
            UsuarioRepository usuarioRepository,
            SupervisaoRepository supervisaoRepository,
            PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.supervisaoRepository = supervisaoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UsuarioDTO criar(UsuarioCreateDTO usuarioCreateDTO) {
        // Validação de email existente
        if (usuarioRepository.findByEmail(usuarioCreateDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Este email já está em uso.");
        }

        // Extrai o nome de usuário do email
        String email = usuarioCreateDTO.getEmail();
        String nomeDeUsuario = email.split("@")[0];

        // Validação de nome de usuário existente
        if (usuarioRepository.findByUsuario(nomeDeUsuario).isPresent()) {
            throw new RuntimeException("Este nome de usuário (derivado do email) já está em uso.");
        }

        // Mapeamento do DTO para a Entidade
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(usuarioCreateDTO.getNome());
        novoUsuario.setEmail(email);
        novoUsuario.setUsuario(nomeDeUsuario);
        novoUsuario.setPerfil(PerfilAcesso.COLABORADOR);

        Departamento departamento = usuarioCreateDTO.getDepartamento();
        novoUsuario.setDepartamento(departamento);

        // CORREÇÃO 2: Lógica de supervisão limpa, usando o banco de dados.
        Optional<Supervisao> regra = supervisaoRepository.findByDepartamento(departamento);
        regra.ifPresent(supervisao ->
                // Assumindo que a entidade Usuario agora tem um campo do tipo Supervisao
                novoUsuario.setSupervisor(supervisao)
        );

        // Hashing da senha
        String senhaCodificada = passwordEncoder.encode(usuarioCreateDTO.getSenha());
        novoUsuario.setSenhaHash(senhaCodificada);

        // Salva no banco
        Usuario usuarioSalvo = usuarioRepository.save(novoUsuario);

        // Retorna o DTO
        return new UsuarioDTO(usuarioSalvo);
    }

    // --- MÉTODOS DE APOIO (sem alteração) ---
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
}