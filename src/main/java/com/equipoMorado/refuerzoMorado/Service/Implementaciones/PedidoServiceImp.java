package com.equipoMorado.refuerzoMorado.Service.Implementaciones;

import com.equipoMorado.refuerzoMorado.Model.EstadoPedido;
import com.equipoMorado.refuerzoMorado.Model.Pedido;
import com.equipoMorado.refuerzoMorado.Model.Usuarios.Cliente;
import com.equipoMorado.refuerzoMorado.Repository.PedidoRepository;
import com.equipoMorado.refuerzoMorado.Service.Interfaces.PedidoService;
import com.equipoMorado.refuerzoMorado.Service.Interfaces.UsuarioService;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Request.RequestPedidoDTO;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Response.ResponsePedidoDTO;
import com.equipoMorado.refuerzoMorado.Util.Mappers.Request.PedidoRequestMapper;
import com.equipoMorado.refuerzoMorado.Util.Mappers.Response.PedidoResponseMapper;
import com.equipoMorado.refuerzoMorado.Util.Mappers.Response.Usuarios.ClienteResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.equipoMorado.refuerzoMorado.Model.EstadoPedido.COMPLETADO;
import static com.equipoMorado.refuerzoMorado.Model.EstadoPedido.PAGADO;

@Service
public class PedidoServiceImp implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoRequestMapper pedidoRequestMapper;
    private final PedidoResponseMapper pedidoResponseMapper;

    @Autowired
    private UsuarioService usuarioServiceImp;
    @Autowired
    private ClienteResponseMapper  clienteResponseMapper;


    @Autowired
    public PedidoServiceImp(PedidoRepository pedidoRepository, PedidoRequestMapper pedidoRequestMapper, PedidoResponseMapper pedidoResponseMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoRequestMapper = pedidoRequestMapper;
        this.pedidoResponseMapper = pedidoResponseMapper;
    }


    public ResponsePedidoDTO obtenerPedido(String idPedido) {
        Pedido p = pedidoRepository.findById(idPedido).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        return pedidoResponseMapper.toDTO(p);

    }


    public ResponsePedidoDTO crearPedido(RequestPedidoDTO pedidoDTO) {
        Pedido pedido = pedidoRequestMapper.toClass(pedidoDTO);
        Cliente cliente = clienteResponseMapper.toCliente(usuarioServiceImp.obtenerCliente(pedidoDTO.getClienteId()));
        pedido.setCliente(cliente);
        return   pedidoResponseMapper.toDTO(pedidoRepository.save(pedido));
    }


    public ResponsePedidoDTO pagarPedido(String idPedido){
        Pedido p = pedidoRepository.findById(idPedido).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        p.setEstado(PAGADO);
        return pedidoResponseMapper.toDTO(pedidoRepository.save(p));
    }



    public void  actualizarEstadoPedido(String idPedido, EstadoPedido estado){
        Pedido p = pedidoRepository.findById(idPedido).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        p.setEstado(estado);
        pedidoRepository.save(p);
    }

    public List<ResponsePedidoDTO> obtenerPedidos(String idCliente){
        List<Pedido> p = pedidoRepository.findByCliente_Id(idCliente);
        return p.stream().map(pedidoResponseMapper::toDTO).collect(Collectors.toList());
    }



}
