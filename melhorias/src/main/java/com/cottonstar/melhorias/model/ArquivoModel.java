package com.cottonstar.melhorias.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_arquivos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArquivoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;              // nome do arquivo
    private String tipo;              // extensão ou tipo MIME
    private byte[] conteudo;          // conteúdo do arquivo
    private LocalDateTime dataUpload;
    private UsuarioModel uploader;    // quem fez o upload
}
