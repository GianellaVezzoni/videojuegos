package com.programacion.videojuegos.repositories;

import com.programacion.videojuegos.entities.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstudio extends JpaRepository<Estudio, Long> {

}
