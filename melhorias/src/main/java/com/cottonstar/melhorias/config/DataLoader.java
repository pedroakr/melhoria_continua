package com.cottonstar.melhorias.config;

import com.cottonstar.melhorias.model.Supervisao;
import com.cottonstar.melhorias.model.Usuario;
import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.PerfilAcesso;
import com.cottonstar.melhorias.repository.SupervisaoRepository;
import com.cottonstar.melhorias.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(
            UsuarioRepository usuarioRepository,
            SupervisaoRepository supervisaoRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            // --- Bloco de criação de usuários (sem alteração) ---
            if (usuarioRepository.findByEmail("admin@empresa.com").isEmpty()) {
                // ... (código de criação do admin)
            }
            if (usuarioRepository.findByEmail("teste@empresa.com").isEmpty()) {
                // ... (código de criação do colaborador)
            }

            // --- BLOCO DE SUPERVISÃO CORRIGIDO ---
            if (supervisaoRepository.count() == 0) {
                // Instancia para o Auditoria
                Supervisao auditoria = new Supervisao();
                auditoria.setNomeSupervisor("Carlos Chagas");
                auditoria.setEmailSupervisor("supervisor.auditoria@empresa.com");
                auditoria.setDepartamento(Departamento.AUDITORIA);
                supervisaoRepository.save(auditoria);

                // Instancia para a TI
                Supervisao ti = new Supervisao();
                ti.setNomeSupervisor("Ada Lovelace");
                ti.setEmailSupervisor("supervisor.ti@empresa.com");
                ti.setDepartamento(Departamento.TI);
                supervisaoRepository.save(ti);

                // Instancia para a Produção
                Supervisao producao = new Supervisao();
                producao.setNomeSupervisor("Henry Ford");
                producao.setEmailSupervisor("supervisor.producao@empresa.com");
                producao.setDepartamento(Departamento.PRODUCAO);
                supervisaoRepository.save(producao);

                System.out.println("✅ Regras de supervisão carregadas no banco de dados.");
            }
        };
    }
}