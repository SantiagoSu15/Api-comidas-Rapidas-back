package com.equipoMorado.refuerzoMorado.Service.Implementaciones;


import com.equipoMorado.refuerzoMorado.Model.Usuarios.Cliente;
import com.equipoMorado.refuerzoMorado.Repository.UsuarioRepository;
import com.equipoMorado.refuerzoMorado.Service.Interfaces.UsuarioService;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Request.UsuariosRequest.RequestAdministradorDTO;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Request.UsuariosRequest.RequestClienteDTO;
import com.equipoMorado.refuerzoMorado.Util.DTOS.Response.UsuariosResponse.ResponseClienteDTO;
import com.equipoMorado.refuerzoMorado.Util.Excepciones.Ex.UsuarioNoEncontradoException;
import com.equipoMorado.refuerzoMorado.Util.Mappers.Response.Usuarios.ClienteResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ClienteResponseMapper clienteResponseMapper;

    @Autowired
    public UsuarioServiceImp(UsuarioRepository usuarioRepository, ClienteResponseMapper clienteResponseMapper) {
        this.usuarioRepository = usuarioRepository;
        this.clienteResponseMapper = clienteResponseMapper;
    }


    public void crearCliente(RequestClienteDTO cliente) {

    }

    public void crearAdmin(RequestAdministradorDTO admin) {

    }

    public ResponseClienteDTO obtenerCliente(String idCliente) {
        Cliente cliente = usuarioRepository.findByClienteId(idCliente)
                .orElseThrow(() -> new UsuarioNoEncontradoException("Cliente no encontrado"));

        return clienteResponseMapper.toResponseClienteDTO(cliente);
    }
}
