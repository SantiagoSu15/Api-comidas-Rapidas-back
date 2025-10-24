package com.equipoMorado.refuerzoMorado.Util.DTOS;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private String id;
    private String productoId;
    private double precio;
    private int cantidadProducto;
}
