package aluraforum.com.example.aluraforum.controller;

import aluraforum.com.example.aluraforum.domain.dto.Cadastro;
import aluraforum.com.example.aluraforum.service.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cadastro")
@SecurityRequirement(name = "bearer-key")
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity efetuarCadastro(@RequestBody @Valid Cadastro dados, UriComponentsBuilder uriComponentsBuilder) {
        var usuario = usuarioService.cadastrarNovoUsuario(dados);
        var uri = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getClass()).toUri();

        return ResponseEntity.created(uri).body(usuario);

    }

}
