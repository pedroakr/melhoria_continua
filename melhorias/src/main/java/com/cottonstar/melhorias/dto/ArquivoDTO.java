package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.Arquivo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ArquivoDTO {

    private Long id;
    private String nomeOriginal;
    private String contentType;
    private Long tamanho;
    private LocalDateTime dataUpload;
    private String urlDownload;

    public ArquivoDTO(Arquivo arquivo) {
        this.id = arquivo.getId();
        this.nomeOriginal = arquivo.getNomeOriginal();
        this.contentType = arquivo.getContentType();
        this.tamanho = arquivo.getTamanho();
        this.dataUpload = arquivo.getDataUpload();
        // Monta a URL para o front-end poder baixar o arquivo
        this.urlDownload = "/api/execucao/anexos/" + arquivo.getId();
    }
}
