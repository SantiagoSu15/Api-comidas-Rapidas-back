package com.equipoMorado.refuerzoMorado.Util.Mappers;

import com.equipoMorado.refuerzoMorado.Model.Item;
import com.equipoMorado.refuerzoMorado.Util.DTOS.ItemDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(target = "productoId", source = "producto.id")
    ItemDTO toDTO(Item item);

    Item toClass(ItemDTO itemDTO);

}