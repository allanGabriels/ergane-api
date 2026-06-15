package com.ergane.api.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "vendas")
public class Venda {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Indexed
    @Field("usuario_id")
    private String usuarioId;

    @Field("nome_cliente")
    private String nomeCliente;

    @Field("cpf_cliente")
    private String cpfCliente;

    @Field("metodo_pagamento")
    private String metodoPagamento;

    @Field(name = "valor_total", targetType = FieldType.DECIMAL128)
    private BigDecimal valorTotal;

    @Field(name = "valor_recebido", targetType = FieldType.DECIMAL128)
    private BigDecimal valorRecebido;

    @Field(name = "troco", targetType = FieldType.DECIMAL128)
    private BigDecimal troco;

    @GeoSpatialIndexed
    @Field("localizacao")
    private GeoJsonPoint localizacao;

    @Singular
    @Field("itens")
    private List<ItemVenda> itens;

    @CreatedDate
    @Field("data_hora")
    private LocalDateTime dataHora;

}