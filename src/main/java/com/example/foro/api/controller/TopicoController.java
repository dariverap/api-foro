package com.example.foro.api.controller;

import com.example.foro.api.model.topìco.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    //metodo para obtener una lista de los topicos
    @PostMapping
    @Transactional
    public void registrarTopico(@RequestBody List<DatosRegistroTopico> datosRegistroTopicos) {
        List<Topico> topicos = new ArrayList<>();

        for (DatosRegistroTopico datos : datosRegistroTopicos) {
            topicos.add(new Topico(datos));
        }

        topicoRepository.saveAll(topicos);
    }
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listaTopicos(@PageableDefault(size = 10) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);

    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }
}
