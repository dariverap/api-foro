package com.example.foro.api.model.topìco;

import com.example.foro.api.model.curso.Curso;
import com.example.foro.api.model.respuesta.Respuesta;
import com.example.foro.api.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Usuario autor;
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	@OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Respuesta> respuestas = new ArrayList<>();

	public Topico(String titulo, String mensaje, Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.curso = curso;
	}

	public Topico(DatosRegistroTopico datosRegistroTopico) {
		this.titulo=datosRegistroTopico.titulo();
		this.mensaje=datosRegistroTopico.mensaje();
		this.autor=new Usuario(datosRegistroTopico.autor_id());
		this.curso=new Curso(datosRegistroTopico.curso_id());
	}

	public Topico(Topico topico) {

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public void setStatus(StatusTopico status) {
		this.status = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
		if( datosActualizarTopico.titulo()!=null) {
			this.titulo = datosActualizarTopico.titulo();
		}
		if( datosActualizarTopico.mensaje()!=null) {
			this.mensaje = datosActualizarTopico.mensaje();
		}
		if( datosActualizarTopico.statusTopico()!=null) {
			this.status = datosActualizarTopico.statusTopico();
		}
		if( datosActualizarTopico.curso_id()!=null) {
			this.curso.setId(datosActualizarTopico.curso_id());
		}
	}
}
