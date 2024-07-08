package aluraforum.com.example.aluraforum.domain.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateCurso(@NotNull Long id,
                          String nome,
                          String categoria,
                          Boolean ativo) {
}
