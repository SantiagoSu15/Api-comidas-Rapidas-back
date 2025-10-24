package com.equipoMorado.refuerzoMorado.Repository;

import com.equipoMorado.refuerzoMorado.Model.EstadoPedido;
import com.equipoMorado.refuerzoMorado.Model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface PedidoRepository extends MongoRepository<Pedido, String> {

    // gte -> mayor o igual
    //menor -> menor o igual
    @Query("{ 'fecha': { $gte: ?0, $lte: ?1 } }")
    List<Pedido> findPedidosByFechaBetween(Date fechaInicio, Date fechaFin);

    //Busca por estado igual a pagado por el and
    @Query("{ 'clienteId': ?0, 'estado': 'PAGADO' }")
    List<Pedido> findPedidosByClienteIdAndEstado(String clienteId);

    List<Pedido> findByClienteIdAndEstado(String clienteId, EstadoPedido estado);



    //cualquiera de los 2 si es true
    @Query("{ $or: [ { 'clienteId': ?0 }, { 'estado': 'PAGADO' } ] }")
    List<Pedido> findPedidosByClienteIdOrEstado(String clienteId);

    List<Pedido> findByClienteIdOrEstado(String clienteId, EstadoPedido estado);

    List<Pedido> findByCliente_Id(String clienteId);
    List<Pedido> findByEstado(EstadoPedido estado);

}
