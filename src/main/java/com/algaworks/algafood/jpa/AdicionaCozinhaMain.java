package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;


public class AdicionaCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class).web(WebApplicationType.NONE).run(args);
        CozinhaRepositoryImpl cuisineRegistration = context.getBean(CozinhaRepositoryImpl.class);

        Cozinha cuisine1 = new Cozinha();
        cuisine1.setNome("Brasileira");
        cuisine1.setId(1L);

        Cozinha cuisine2 = new Cozinha();
        cuisine2.setNome("Japonesa");
        cuisine2.setId(2L);

        cuisineRegistration.adicionar(cuisine1);
        cuisineRegistration.adicionar(cuisine2);

        List<Cozinha> cuisines = cuisineRegistration.listar();

        for (Cozinha cuisine : cuisines) {
            System.out.println("ID: " + cuisine.getId() + " NAME: " + cuisine.getNome());
        }
    }
}

