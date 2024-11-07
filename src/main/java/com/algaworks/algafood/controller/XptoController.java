package com.algaworks.algafood.controller;

import com.algaworks.algafood.di.modelo.Client;
import com.algaworks.algafood.di.service.ClientActivationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XptoController {

    private ClientActivationService clientActivationService;

    public XptoController(ClientActivationService clientActivationService) {
        this.clientActivationService = clientActivationService;
    }

    @GetMapping("/uaua")
    @ResponseBody
    public String uaua(){
        Client nando = new Client("Nando", "fernandoentringer@gmail.com", "661 309 194");
        clientActivationService.activate(nando);
        return "uaua";
    }
}
