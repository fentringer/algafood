package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ClientActivationService {

	@Autowired
	private ApplicationEventPublisher publisher;

	public void activate(Client client) {
		client.activate();
		publisher.publishEvent(new ActivationClientEvent(client));
	}
}


