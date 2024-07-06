package com.example.prova_api.usuariocelular;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioCelularRepository extends JpaRepository<UsuarioCelular, UsuarioCelularId> {
}
