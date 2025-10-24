package com.equipoMorado.refuerzoMorado.Model;


import com.equipoMorado.refuerzoMorado.Model.Usuarios.Cliente;
import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Pedido")
public class Pedido {
    @Id
    private String id;
    @DBRef
    private Cliente cliente;
    private List<Item> items;
    private LocalDate fecha;
    @NonNull
    private double precioFinal;
    private EstadoPedido estado;

}
