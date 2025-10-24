package com.equipoMorado.refuerzoMorado.Service.Interfaces;

import com.equipoMorado.refuerzoMorado.Util.DTOS.Request.UsuariosRequest.RequestAdministradorDTO;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Request.UsuariosRequest.RequestClienteDTO;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Response.UsuariosResponse.ResponseClienteDTO;

public interface UsuarioService {
    void crearCliente(RequestClienteDTO cliente);
    void crearAdmin(RequestAdministradorDTO admin);
    ResponseClienteDTO obtenerCliente(String id);


}
