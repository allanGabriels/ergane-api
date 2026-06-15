package com.ergane.api.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "categorias")
@CompoundIndex(name = "usuario_nome_idx", def = "{'usuarioId': 1, 'nome': 1}", unique = true)
public class Categoria {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field("nome")
    private String nome;

    @Indexed
    @Field("usuario_id")
    private String usuarioId;

}