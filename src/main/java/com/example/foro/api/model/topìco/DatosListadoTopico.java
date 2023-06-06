package com.example.foro.api.model.topìco;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosListadoTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, StatusTopico statusTopico, Long autorId, Long cursoId) {
    public DatosListadoTopico (Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getfechaCreacion(),topico.getStatus(),topico.getAutor().getId(),topico.getCurso().getId());
    }
}
