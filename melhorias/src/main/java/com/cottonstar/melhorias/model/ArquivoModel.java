package com.cottonstar.melhorias.model;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArquivoModel {

    private String id;
    private String nome;              // nome do arquivo
    private String tipo;              // extensão ou tipo MIME
    private byte[] conteudo;          // conteúdo do arquivo
    private LocalDateTime dataUpload;
    private UsuarioModel uploader;    // quem fez o upload
}
