package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.Certificado;
import com.cottonstar.melhorias.repository.CertificadoMelhoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CertificadoMelhoriaService {

    private final CertificadoMelhoriaRepository certificadoRepository;

    public Certificado salvar(Certificado certificado) {
        return certificadoRepository.save(certificado);
    }

    public Optional<Certificado> buscarPorId(String id) {
        return certificadoRepository.findById(id);
    }
}
