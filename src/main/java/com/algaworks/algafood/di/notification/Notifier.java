package com.algaworks.algafood.di.notification;

import com.algaworks.algafood.di.modelo.Client;

public interface Notifier {
    void notify(Client client, String message);
}
