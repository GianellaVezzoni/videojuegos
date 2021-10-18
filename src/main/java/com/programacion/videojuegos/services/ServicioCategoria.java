package com.programacion.videojuegos.services;

import com.programacion.videojuegos.entities.Categoria;
import com.programacion.videojuegos.repositories.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioCategoria implements ServicioBase<Categoria>{
    @Autowired
    private RepositorioCategoria repositorioCategoria;

    @Override
    @Transactional
    public List<Categoria> findAll() throws Exception {
        try{
            return this.repositorioCategoria.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria findById(long id) throws Exception {
        try{
            Optional<Categoria> opt = this.repositorioCategoria.findById(id);
            return opt.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria saveOne(Categoria entity) throws Exception {
        try{
            return this.repositorioCategoria.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria updateOne(Categoria entity, long id) throws Exception {
        try{
            Optional<Categoria> opt = this.repositorioCategoria.findById(id);
            Categoria categoria = opt.get();
            categoria = this.repositorioCategoria.save(entity);
            return categoria;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try{
            Optional<Categoria> opt = this.repositorioCategoria.findById(id);
            if(!opt.isEmpty()){
                Categoria categoria = opt.get();
                categoria.setActivo(!categoria.isActivo());
                this.repositorioCategoria.save(categoria);
            }else {
                throw new Exception();
            }
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
