package aluraforum.com.example.aluraforum.domain.dto;

import lombok.Getter;

@Getter
public record Usuario(Long id,
                      String email,
                      String nome,
                      String perfil,
                      String senha,
                      Boolean ativo) {
}
