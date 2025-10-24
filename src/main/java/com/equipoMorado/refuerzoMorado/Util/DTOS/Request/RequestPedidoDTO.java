package com.equipoMorado.refuerzoMorado.Util.DTOS.Request;

import com.equipoMorado.refuerzoMorado.Model.EstadoPedido;
import com.equipoMorado.refuerzoMorado.Util.DTOS.ItemDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPedidoDTO {
    private String clienteId;
    private List<ItemDTO> items;
    private LocalDate fecha;
    private double precioFinal;
    private EstadoPedido estado;
}
