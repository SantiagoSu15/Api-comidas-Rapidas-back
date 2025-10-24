package com.equipoMorado.refuerzoMorado.Model.Usuarios;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document(collection = "Usuario")
public abstract class Usuario {
    @Id
    private String id;
    private String nombre;
    @Email
    private String email;

}
