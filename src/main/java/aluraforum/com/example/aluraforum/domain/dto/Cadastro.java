package aluraforum.com.example.aluraforum.domain.dto;

import jakarta.validation.constraints.NotNull;

public record Cadastro(@NotNull String nome,
                       @NotNull String email,
                       @NotNull String senha) {
}