package aluraforum.com.example.aluraforum.service;

import aluraforum.com.example.aluraforum.domain.dto.Cadastro;
import aluraforum.com.example.aluraforum.domain.dto.Usuario;
import aluraforum.com.example.aluraforum.domain.dto.UpdateUsuario;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;


public class UsuarioService {
    public Object cadastrarNovoUsuario(Cadastro dados) {
        return dados;
    }

    public void delete(long id) {
        System.out.println("Usuário excluído");
    }

    public Object update(UpdateUsuario usuario) {
        return usuario;
    }

    public List<Usuario> list(Pageable id) {
        return List.of();
    }

    public Object detail(Long id) {
        return id;
    }
}
