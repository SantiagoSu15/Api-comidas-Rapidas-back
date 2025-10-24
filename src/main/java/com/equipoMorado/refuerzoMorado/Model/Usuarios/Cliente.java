package com.equipoMorado.refuerzoMorado.Model.Usuarios;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Cliente extends Usuario {
    private String telefono;
    private String direccion;
}
