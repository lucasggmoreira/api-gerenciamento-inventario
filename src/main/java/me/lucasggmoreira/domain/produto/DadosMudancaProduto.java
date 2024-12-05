package me.lucasggmoreira.domain.produto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosMudancaProduto(
        String nome,
        @Nullable
        @PositiveOrZero
        Double preco,
        @PositiveOrZero
        @Nullable
        Integer quantidade
) {
}
