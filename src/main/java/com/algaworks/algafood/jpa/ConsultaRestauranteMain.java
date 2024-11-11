package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;


public class ConsultaRestauranteMain {

    public static void main(String[] args){
        ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class).web(WebApplicationType.NONE).run(args);
        RestauranteRepositoryImpl restauranteRepository = context.getBean(RestauranteRepositoryImpl.class);
        List<Restaurante> restaurantes = restauranteRepository.listar();

        for (Restaurante restaurante : restaurantes){
            System.out.println(restaurante.getNome() +"  "+ restaurante.getCozinha().getNome()
            );
        }
    }
}
