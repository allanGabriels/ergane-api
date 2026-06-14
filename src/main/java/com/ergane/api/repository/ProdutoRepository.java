package com.ergane.api.repository;

import com.ergane.api.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

    List<Produto> findAllByUsuarioId(String usuarioId);
    Optional<Produto> findByIdAndUsuarioId(String id, String usuarioId);
    void deleteByIdAndUsuarioId(String id, String usuarioId);

}