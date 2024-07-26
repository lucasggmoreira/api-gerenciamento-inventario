package me.lucasggmoreira.repository;

import me.lucasggmoreira.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio extends JpaRepository<Produto, Long> {
}
