package com.equipoMorado.refuerzoMorado.Controller;

import com.equipoMorado.refuerzoMorado.Model.EstadoPedido;
import com.equipoMorado.refuerzoMorado.Service.Interfaces.PedidoService;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Request.RequestPedidoDTO;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Response.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }



    @Operation(summary = "Obtener un pedido por ID", description = "Retorna el pedido correspondiente a un ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido encontrado"),
            @ApiResponse(responseCode = "404", description = "Pedido no encontrado")
    })
    @PostMapping
    public ResponseEntity<ResponsePedidoDTO> crearPedido(@RequestBody RequestPedidoDTO pedidoDTO) {
        ResponsePedidoDTO nuevoPedido = pedidoService.crearPedido(pedidoDTO);
        return ResponseEntity.ok(nuevoPedido);
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<ResponsePedidoDTO> obtenerPedido(@PathVariable String idPedido) {
        ResponsePedidoDTO pedido = pedidoService.obtenerPedido(idPedido);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<ResponsePedidoDTO>> obtenerPedidosPorCliente(@PathVariable String idCliente) {
        List<ResponsePedidoDTO> pedidos = pedidoService.obtenerPedidos(idCliente);
        return ResponseEntity.ok(pedidos);
    }

    @PutMapping("/{idPedido}/pagar")
    public ResponseEntity<ResponsePedidoDTO> pagarPedido(@PathVariable String idPedido) {
        ResponsePedidoDTO pedidoPagado = pedidoService.pagarPedido(idPedido);
        return ResponseEntity.ok(pedidoPagado);
    }

    @PutMapping("/{idPedido}/estado")
    public ResponseEntity<Void> actualizarEstadoPedido(@PathVariable String idPedido,
                                                       @RequestParam EstadoPedido estado) {
        pedidoService.actualizarEstadoPedido(idPedido, estado);
        return ResponseEntity.noContent().build();
    }
}
