package aluraforum.com.example.aluraforum.domain.dto;

import jakarta.validation.constraints.NotNull;

public record Autenticacao(@NotNull String email,
                           @NotNull String senha) {
}