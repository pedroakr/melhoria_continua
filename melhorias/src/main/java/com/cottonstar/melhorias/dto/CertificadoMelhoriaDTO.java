/*

        EM DESENVOLVIMENTO

*/

package com.cottonstar.melhorias.dto;

import java.time.LocalDateTime;

public record CertificadoMelhoriaDTO(
        Long id,
        String melhoriaId,
        String tituloMelhoria,
        String responsavel,
        LocalDateTime dataGeracao,
        String urlDownload
) {}