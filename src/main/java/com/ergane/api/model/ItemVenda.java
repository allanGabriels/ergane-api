package com.ergane.api.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemVenda {

    @Field("produto_id")
    private String produto_id;

    @Field("nome")
    private String nome;

    @Field("quantidade")
    private Integer quantidade;

    @Field(name = "preco_unitario", targetType = FieldType.DECIMAL128)
    private BigDecimal precoUnitario;

    @Field(name = "subtotal", targetType = FieldType.DECIMAL128)
    private BigDecimal subtotal;

}