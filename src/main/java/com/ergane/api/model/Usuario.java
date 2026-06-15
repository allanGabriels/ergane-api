package com.ergane.api.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuarios")
public class Usuario {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field("nome")
    private String nome;

    @Indexed(unique = true)
    @Field("cpf")
    private String cpf;

    @CreatedDate
    @Field("data_hora_cadastro")
    private LocalDateTime dataHoraCadastro;

    @Field("senha_hash")
    private String senhaHash;

}