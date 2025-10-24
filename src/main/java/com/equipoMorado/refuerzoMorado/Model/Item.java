package com.equipoMorado.refuerzoMorado.Model;

import com.equipoMorado.refuerzoMorado.Model.Productos.Producto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Item")
public class Item {
    @Id
    private String id;
    @DBRef
    private Producto producto;
    private int cantidadProducto;
    private double precio;
}
