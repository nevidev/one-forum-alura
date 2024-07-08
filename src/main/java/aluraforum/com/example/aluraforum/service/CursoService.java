package aluraforum.com.example.aluraforum.service;

import aluraforum.com.example.aluraforum.domain.dto.Curso;
import aluraforum.com.example.aluraforum.domain.dto.UpdateCurso;
import aluraforum.com.example.aluraforum.domain.model.CursoRepository;
import aluraforum.com.example.aluraforum.domain.model.Usuario;
import aluraforum.com.example.aluraforum.domain.model.UsuarioRepository;
import aluraforum.com.example.aluraforum.infra.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Curso create(@Valid Curso curso) {
        isAdmin();

        Curso newCurso = new Curso(null, curso.nome(), curso.categoria(), true);
        return newCurso;
    }

    private void isAdmin() {
        Usuario usuarioLogado = usuarioRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

        if (!usuarioLogado.getPerfil().getNome().equals("ADMIN")) {
            throw new RuntimeException("Acesso negado!");
        }
    }

    public void delete(Long id) {
        isAdmin();

        aluraforum.com.example.aluraforum.domain.model.Curso curso = cursoRepository.getReferenceById(id);
        curso.delete();
    }


    public Curso update(UpdateCurso curso) {
        isAdmin();

        aluraforum.com.example.aluraforum.domain.model.Curso updateCurso = cursoRepository.findById(curso.id())
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + curso.id()));

        updateCurso.update(curso);
        cursoRepository.save(updateCurso);

        return new Curso(updateCurso.id(), updateCurso.getNome(), updateCurso.getCategoria(), updateCurso.getAtivo());
    }


    public List<aluraforum.com.example.aluraforum.domain.model.Curso> list(Pageable paginacao) {
        Page<aluraforum.com.example.aluraforum.domain.model.Curso> page = cursoRepository.findAllByAtivoTrue(paginacao);
        return page.getContent();
    }

    public aluraforum.com.example.aluraforum.domain.model.Curso detail(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + id));
    }

}
