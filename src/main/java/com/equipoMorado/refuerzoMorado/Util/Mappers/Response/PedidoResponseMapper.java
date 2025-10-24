package com.equipoMorado.refuerzoMorado.Util.Mappers.Response;


import com.equipoMorado.refuerzoMorado.Model.Item;
import com.equipoMorado.refuerzoMorado.Model.Pedido;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Response.ResponsePedidoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PedidoResponseMapper {

    Pedido toClass(ResponsePedidoDTO pedidoDTO);

    @Mapping(target = "clienteId", source = "cliente.id")
    ResponsePedidoDTO toDTO(Pedido pedido);

    default List<String> mapItemsToIds(List<Item> items) {
        if (items == null) {
            return null;
        }
        return items.stream()
                .map(Item::getId)
                .collect(Collectors.toList());
    }
}
