package com.programacion.videojuegos.services;

import com.programacion.videojuegos.entities.Videojuegos;
import com.programacion.videojuegos.repositories.RepositorioVideojuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioVideojuego implements ServicioBase<Videojuegos>{
    @Autowired
    private RepositorioVideojuego repositorio;

    @Override
    @Transactional
    public List<Videojuegos> findAll() throws Exception {
        try{
            return this.repositorio.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Videojuegos findById(long id) throws Exception {
        try{
            Optional<Videojuegos> opt = this.repositorio.findById(id);
            return opt.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Videojuegos saveOne(Videojuegos entity) throws Exception {
        try{
            return this.repositorio.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Videojuegos updateOne(Videojuegos entity, long id) throws Exception {
        try{
            Optional<Videojuegos> opt = this.repositorio.findById(id);
            Videojuegos videojuego = opt.get();
            videojuego = this.repositorio.save(entity);
            return videojuego;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try{
            Optional <Videojuegos> opt = this.repositorio.findById(id);
            if(!opt.isEmpty()){
                Videojuegos videojuego = opt.get();
                videojuego.setActivo(!videojuego.isActivo());
                this.repositorio.save(videojuego);
            }else {
                throw new Exception();
            }
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Videojuegos> findAllByActivo() throws Exception{
        try {
            return this.repositorio.findAllByActivo();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Videojuegos findByIdAndActivo(long id) throws Exception {
        try {
            Optional<Videojuegos> opt = this.repositorio.findByIdAndActivo(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Videojuegos> findByTitle(String q) throws Exception{
        try{
            return this.repositorio.findByTitle(q);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
