package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.Certificado;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor // Esta anotação já cria o construtor necessário.
public class CertificadoMelhoriaService {

    private final CertificadoMelhoriaRepository certificadoRepository;

    // Construtor manual removido para resolver o conflito.

    public Certificado salvar(Certificado certificado) {
        return certificadoRepository.save(certificado);
    }

    public Optional<Certificado> buscarPorId(String id) {
        return certificadoRepository.findById(id);
    }
}