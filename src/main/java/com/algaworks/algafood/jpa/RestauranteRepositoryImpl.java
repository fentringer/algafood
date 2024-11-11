package com.algaworks.algafood.jpa;

import com.algaworks.algafood.domain.model.Restaurante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RestauranteRepositoryImpl {

    @PersistenceContext
    private EntityManager manager;

    public List<Restaurante> listar(){
       return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
    }

    public Restaurante buscar(Long id){
        return manager.find(Restaurante.class, id);
    }

    @Transactional
    public Restaurante adicionar(Restaurante restaurante){
        return manager.merge(restaurante);
    }

    @Transactional
    public void remover(Restaurante restaurante){
        restaurante = buscar(restaurante.getId());
        manager.remove(restaurante);
    }
}
