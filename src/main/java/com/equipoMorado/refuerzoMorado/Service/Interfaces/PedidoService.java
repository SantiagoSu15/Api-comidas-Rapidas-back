package com.equipoMorado.refuerzoMorado.Service.Interfaces;

import com.equipoMorado.refuerzoMorado.Model.EstadoPedido;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Request.RequestPedidoDTO;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Response.ResponsePedidoDTO;

import java.util.List;

public interface PedidoService {
    ResponsePedidoDTO obtenerPedido(String id);
    ResponsePedidoDTO crearPedido(RequestPedidoDTO pedido);
    ResponsePedidoDTO pagarPedido(String id);
    void  actualizarEstadoPedido(String id, EstadoPedido estado);

    List<ResponsePedidoDTO> obtenerPedidos(String idCliente);
}
