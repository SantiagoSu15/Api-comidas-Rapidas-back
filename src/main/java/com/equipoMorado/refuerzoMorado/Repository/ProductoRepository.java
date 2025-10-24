package com.equipoMorado.refuerzoMorado.Repository;

import com.equipoMorado.refuerzoMorado.Model.Productos.Bebida;
import com.equipoMorado.refuerzoMorado.Model.Productos.Enums.Bebidas;
import com.equipoMorado.refuerzoMorado.Model.Productos.Enums.Tamaño;
import com.equipoMorado.refuerzoMorado.Model.Productos.Hamburguesa;
import com.equipoMorado.refuerzoMorado.Model.Productos.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductoRepository extends MongoRepository<Producto, String> {

    @Query("{ '_class': 'com.equipoMorado.model.Productos.Hamburguesa' }")
    List<Hamburguesa> findOnlyHamburguesas();


    @Query("{ 'tamaño': ?0 }")
    List<Producto> findByTamaño(Tamaño tamaño);

    @Query("{ '_class': 'com.equipoMorado.model.Productos.Bebida' }")
    List<Bebida> findByTipoBebida(Bebidas tipoBebida);

}
