package com.equipoMorado.refuerzoMorado.Model.Productos;


import com.equipoMorado.refuerzoMorado.Model.Productos.Enums.Bebidas;
import com.equipoMorado.refuerzoMorado.Model.Productos.Enums.Tamaño;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bebida extends Producto {
    private boolean conHielo;
    private Bebidas tipoBebida;
    private Tamaño tamaño;
}
