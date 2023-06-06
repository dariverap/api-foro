package com.example.foro.api.model.topìco;

import com.example.foro.api.model.curso.Curso;
import com.example.foro.api.model.respuesta.Respuesta;
import com.example.foro.api.model.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record DatosRegistroTopico(String titulo,String mensaje,Long autor_id,Long curso_id ) {


}
