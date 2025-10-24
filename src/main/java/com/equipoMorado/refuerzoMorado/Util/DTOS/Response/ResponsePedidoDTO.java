package com.equipoMorado.refuerzoMorado.Util.DTOS.Response;

import com.equipoMorado.refuerzoMorado.Model.EstadoPedido;
import com.equipoMorado.refuerzoMorado.Util.DTOS.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePedidoDTO {
    private String id;
    private String clienteId;
    private List<ItemDTO> items;
    private LocalDate fecha;
    private double precioFinal;
    private EstadoPedido estado;
}
