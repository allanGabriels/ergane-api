package com.ergane.api.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "produtos")
public class Produto {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Indexed
    @Field("nome")
    private String nome;

    @Field(name = "preco", targetType = FieldType.DECIMAL128)
    private BigDecimal preco;

    @Field(name = "custo_producao", targetType = FieldType.DECIMAL128)
    private BigDecimal custoProducao;

    @Field("estoque")
    private Integer estoque;

    @Singular
    @Indexed
    @Field("categorias")
    private List<CategoriaResumo> categorias;

    @Field("descricao")
    private String descricao;

    @Indexed
    @Field("usuario_id")
    private String usuarioId;

}