package com.equipoMorado.refuerzoMorado.Model.Productos;

import com.equipoMorado.refuerzoMorado.Model.Productos.Enums.Tamaño;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Acompañamiento extends Producto{
    private Acompañamiento acompañamiento;
    private Tamaño tamaño;
    private boolean conSalsa;
}
