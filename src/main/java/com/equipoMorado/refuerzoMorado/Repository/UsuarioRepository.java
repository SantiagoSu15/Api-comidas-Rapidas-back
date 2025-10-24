package com.equipoMorado.refuerzoMorado.Repository;

import com.equipoMorado.refuerzoMorado.Model.Usuarios.Cliente;
import com.equipoMorado.refuerzoMorado.Model.Usuarios.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    Optional<Usuario> findByEmail(String email);


    // no olvidar
    //?0 significa primer parametro, el _class es porq es herencia del mongo
    @Query("{ 'email': ?0, '_class': 'com.equipoMorado.model.Usuarios.Cliente' }")
    Optional<Cliente> findClienteByEmail(String email);

    @Query("{ '_class': 'com.equipoMorado.model.Usuarios.Cliente' }")
    Optional<Cliente> findByClienteId(String id);

}
