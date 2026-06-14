package com.ergane.api.repository;

import com.ergane.api.model.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {

    List<Categoria> findAllByUsuarioId(String usuarioId);
    Optional<Categoria> findByIdAndUsuarioId(String id, String usuarioId);

}