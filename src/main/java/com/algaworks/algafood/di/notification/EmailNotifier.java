package com.algaworks.algafood.di.notification;

import com.algaworks.algafood.di.modelo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NotifierType(UrgenceLevelEnum.LOW)
@Component
public class EmailNotifier implements Notifier {

	@Autowired
	private NotifierProperties properties;


	@Override
	public void notify(Client client, String message) {
		System.out.println("Host: " + properties.getServerHost());
		System.out.println("Port: " + properties.getServerPort());
		System.out.printf("Notifying %s via email %s: %s\n",
				client.getName(), client.getEmail(), message);
	}

}
