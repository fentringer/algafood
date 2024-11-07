package com.algaworks.algafood.di.notification;

import com.algaworks.algafood.di.modelo.Client;
import org.springframework.stereotype.Component;

@NotifierType(UrgenceLevelEnum.HIGH)
@Component
public class SmsNotifier implements Notifier {

	@Override
	public void notify(Client client, String message) {
		System.out.printf("Notifying %s via SMS %s: %s\n",
				client.getName(), client.getPhone(), message);
	}

}


