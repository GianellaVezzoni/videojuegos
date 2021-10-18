package com.programacion.videojuegos.services;

import com.programacion.videojuegos.entities.Videojuegos;

import javax.transaction.Transactional;
import java.util.List;

public interface ServicioBase<E> {
    List<E> findAll() throws Exception;
    E findById(long id) throws Exception;
    E saveOne(E entity) throws Exception;
    E updateOne(E entity, long id) throws Exception;
    boolean deleteById(long id) throws Exception;
}
