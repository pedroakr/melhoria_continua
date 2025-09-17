package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.model.enums.TipoRetorno;
import com.cottonstar.melhorias.repository.MelhoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // A anotação do Lombok gera o construtor necessário
public class MelhoriaService {

    @Autowired
    private MelhoriaRepository melhoriaRepository;

    public void MetodosMelhoria() {

        // Salva uma nova melhoria
        Melhoria = novaMelhoria = new Melhoria(/* Passar os dados que serão salvos da melhoria */);
        melhoriaRepository.save(novaMelhoria);                                                              // Salva a nova melhoria no banco de dados

        // Lista todas as melhorias
        List<Melhoria> todasMelhorias = melhoriaRepository.findAll();

        // Busca uma melhoria pelo ID
        Melhoria melhoriaEncontrada = melhoriaRepository.findById(1).orElse(null);                  // Substituir 1 pelo ID desejado

        // Atualiza uma melhoria existente
        if (melhoriaEncontrada != null) {
            melhoriaEncontrada.setTitulo("Novo Título" /* Passar o titulo */);                                // Atualiza o título da melhoria
            melhoriaEncontrada.setTipoRetorno(TipoRetorno.valueOf("Novo Tipo de Retorno"));            //*Passar o tipo de retorno*/); // Atualiza o tipo de retorno
            melhoriaRepository.save(melhoriaEncontrada);                                                    // Salva as alterações no banco de dados
        }

        // Deleta uma melhoria pelo ID
        melhoriaRepository.deleteById(1 /* Passar ID */);                                                   // Substituir 1 pelo ID da melhoria
    }

    //private final MelhoriaRepository melhoriaRepository;

    // Construtor manual foi removido daqui para evitar duplicidade.

    //public Melhoria criarMelhoria(Melhoria melhoria) {return melhoriaRepository.save(melhoria);}

    //public Optional<Melhoria> buscarPorId(Integer id) {return melhoriaRepository.findById(id);}

    //public List<Melhoria> listarTodas() {return melhoriaRepository.findAll();}

    //public Melhoria atualizarMelhoria(Melhoria melhoria) {return melhoriaRepository.save(melhoria);}

    //public void deletarMelhoria(Integer id) {melhoriaRepository.deleteById(id);}
}