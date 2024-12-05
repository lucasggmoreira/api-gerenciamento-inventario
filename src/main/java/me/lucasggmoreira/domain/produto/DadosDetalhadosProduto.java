package me.lucasggmoreira.domain.produto;

public record DadosDetalhadosProduto(
        Long id,
        String nome,
        double preco,
        int quantidade
)
{

    public DadosDetalhadosProduto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade());
    }

}
