package com.ergane.api.model;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

public record CategoriaResumo(@MongoId(FieldType.OBJECT_ID) String id, @Field("nome") String nome) {

}