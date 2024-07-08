package aluraforum.com.example.aluraforum.controller;

import aluraforum.com.example.aluraforum.domain.dto.Curso;
import aluraforum.com.example.aluraforum.domain.dto.UpdateCurso;
import aluraforum.com.example.aluraforum.service.CursoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/curso")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid Curso curso, UriComponentsBuilder uriBuilder){
        Curso createdCurso = cursoService.create(curso);

        var uri = uriBuilder.path("/curso/{id}").buildAndExpand(createdCurso.id()).toUri();

        return ResponseEntity.created(uri).body(createdCurso);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateCurso curso){
        var updatedCurso = cursoService.update(curso);

        return ResponseEntity.ok(updatedCurso);
    }

    @GetMapping
    public ResponseEntity<List<aluraforum.com.example.aluraforum.domain.model.Curso>> list(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
        return ResponseEntity.ok(cursoService.list(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        return ResponseEntity.ok(cursoService.detail(id));
    }
}

