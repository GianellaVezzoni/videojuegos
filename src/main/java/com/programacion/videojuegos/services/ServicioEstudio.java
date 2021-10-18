package com.programacion.videojuegos.services;

import com.programacion.videojuegos.entities.Estudio;
import com.programacion.videojuegos.repositories.RepositorioEstudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioEstudio implements ServicioBase<Estudio>{
    @Autowired
    private RepositorioEstudio repositorioEstudio;

    @Override
    @Transactional
    public List<Estudio> findAll() throws Exception {
        try{
            return this.repositorioEstudio.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudio findById(long id) throws Exception {
        try{
            Optional<Estudio> opt = this.repositorioEstudio.findById(id);
            return opt.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudio saveOne(Estudio entity) throws Exception {
        try{
            return this.repositorioEstudio.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudio updateOne(Estudio entity, long id) throws Exception {
        try{
            Optional<Estudio> opt = this.repositorioEstudio.findById(id);
            Estudio estudio = opt.get();
            estudio = this.repositorioEstudio.save(entity);
            return estudio;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try{
            Optional<Estudio> opt = this.repositorioEstudio.findById(id);
            if(!opt.isEmpty()){
                Estudio estudio = opt.get();
                estudio.setActivo(!estudio.isActivo());
                this.repositorioEstudio.save(estudio);
            }else {
                throw new Exception();
            }
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
