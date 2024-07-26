package me.lucasggmoreira.InventarioProdutos;

import me.lucasggmoreira.modelos.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio extends JpaRepository<Produto, Long> {
}
