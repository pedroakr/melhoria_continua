package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.CertificadoModel;
import com.cottonstar.melhorias.repository.CertificadoMelhoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CertificadoMelhoriaService {

    private final CertificadoMelhoriaRepository certificadoRepository;

    public CertificadoMelhoriaService(CertificadoMelhoriaRepository certificadoRepository) {
        this.certificadoRepository = certificadoRepository;
    }

    public CertificadoModel salvar(CertificadoModel certificado) {
        return certificadoRepository.save(certificado);
    }

    public Optional<CertificadoModel> buscarPorId(String id) {
        return certificadoRepository.findById(id);
    }
}
