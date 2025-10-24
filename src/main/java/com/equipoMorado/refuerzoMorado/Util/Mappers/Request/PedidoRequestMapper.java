package com.equipoMorado.refuerzoMorado.Util.Mappers.Request;

import com.equipoMorado.refuerzoMorado.Model.Item;
import com.equipoMorado.refuerzoMorado.Model.Pedido;
import com.equipoMorado.refuerzoMorado.Model.Usuarios.Cliente;
import com.equipoMorado.refuerzoMorado.Repository.UsuarioRepository;
import com.equipoMorado.refuerzoMorado.Service.Implementaciones.UsuarioServiceImp;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Request.RequestPedidoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PedidoRequestMapper {
    Pedido toClass(RequestPedidoDTO pedidoDTO);

    RequestPedidoDTO toDTO(Pedido pedido);

    default List<Item> mapItemIdsToItems(List<String> itemIds) {
        if (itemIds == null) {
            return null;
        }
        return itemIds.stream()
                .map(id -> {
                    Item item = new Item();
                    item.setId(id);
                    return item;
                })
                .collect(Collectors.toList());
    }
}
