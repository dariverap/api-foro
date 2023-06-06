package com.example.foro.api.model.topìco;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id , String titulo, String mensaje, StatusTopico statusTopico, Long curso_id ) {
}
