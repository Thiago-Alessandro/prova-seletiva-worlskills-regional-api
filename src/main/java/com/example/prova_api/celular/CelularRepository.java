package com.example.prova_api.celular;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelularRepository extends JpaRepository<Celular, Long> {

    Celular findByDescricao(String descricao);

}
