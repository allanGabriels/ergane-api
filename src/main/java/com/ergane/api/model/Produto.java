package com.ergane.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "produtos")
public class Produto {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String nome;
    private BigDecimal preco;
    private BigDecimal custoProducao;
    private Integer estoque;
    private List<String> categorias;
    private String descricao;
    private String usuarioId;

}