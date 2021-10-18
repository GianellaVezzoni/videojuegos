package com.programacion.videojuegos.repositories;

import com.programacion.videojuegos.entities.Videojuegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioVideojuego extends JpaRepository<Videojuegos, Long> {
    @Query(value = "SELECT * FROM videojuegos WHERE videojuegos.activo = true", nativeQuery = true)
    List<Videojuegos> findAllByActivo();

    @Query(value = "SELECT * FROM videojuegos WHERE videojuegos.id = :id AND videojuegos.activo = true", nativeQuery = true)
    Optional<Videojuegos> findByIdAndActivo(@Param("id") long id);

    @Query(value = "SELECT * FROM videojuegos WHERE videojuegos.titulo LIKE %:q% AND videojuegos.activo =true", nativeQuery = true)
    List<Videojuegos> findByTitle(@Param("q")String q);
}