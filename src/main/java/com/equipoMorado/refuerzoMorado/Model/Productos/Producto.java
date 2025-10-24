package com.equipoMorado.refuerzoMorado.Model.Productos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Document(collection = "Producto")
public abstract class Producto {
    @Id
    protected String id;
    protected String desc;
    protected double precio;
}
