package me.lucasggmoreira.domain.produto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosCadastroProduto(
        @NotBlank
        String nome,
        @PositiveOrZero
        double preco,
        @PositiveOrZero
        int quantidade
) {
}
