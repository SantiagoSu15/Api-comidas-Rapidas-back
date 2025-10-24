package com.equipoMorado.refuerzoMorado.Util.Mappers.Response.Usuarios;

import com.equipoMorado.refuerzoMorado.Model.Usuarios.Cliente;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Response.UsuariosResponse.ResponseClienteDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClienteResponseMapper {
    ResponseClienteDTO toResponseClienteDTO(Cliente cliente);
    Cliente toCliente(ResponseClienteDTO responseClienteDTO);
}
