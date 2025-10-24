package com.equipoMorado.refuerzoMorado.Service.Interfaces;

import com.equipoMorado.refuerzoMorado.Util.DTOS.Response.ResponseProductoDTO;

import java.util.List;

public interface ProductoService {
    List<ResponseProductoDTO> obtenerProductos();
    ResponseProductoDTO obtenerProducto(String id);
}
