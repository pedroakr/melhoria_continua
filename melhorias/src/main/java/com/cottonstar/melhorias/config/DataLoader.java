package com.cottonstar.melhorias.config;

import com.cottonstar.melhorias.model.Usuario;
import com.cottonstar.melhorias.model.enums.PerfilAcesso;
import com.cottonstar.melhorias.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Criação do usuário Admin
            if (usuarioRepository.findByEmail("admin@empresa.com").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setNome("Administrador");
                admin.setUsuario("admin");
                admin.setEmail("admin@empresa.com");
                admin.setSenhaHash(passwordEncoder.encode("123456")); // senha padrão
                admin.setPerfil(PerfilAcesso.ADMIN);

                usuarioRepository.save(admin);

                System.out.println("✅ Usuário admin criado: email=admin@empresa.com | senha=123456");
            }

            // Criação do usuário de teste/colaborador
            if (usuarioRepository.findByEmail("teste@empresa.com").isEmpty()) {
                Usuario colaborador = new Usuario();
                colaborador.setNome("Usuário de Teste");
                colaborador.setUsuario("tester");
                colaborador.setEmail("teste@empresa.com");
                colaborador.setSenhaHash(passwordEncoder.encode("senha123")); // senha padrão de teste
                colaborador.setPerfil(PerfilAcesso.COLABORADOR);

                usuarioRepository.save(colaborador);

                System.out.println("✅ Usuário teste criado: email=teste@empresa.com | senha=senha123");
            }
        };
    }
}
