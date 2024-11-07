package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Client;

public class ActivationClientEvent {

    private Client client;

    public ActivationClientEvent(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
