package com.algaworks.algafood.listener;

import com.algaworks.algafood.di.notification.Notifier;
import com.algaworks.algafood.di.notification.NotifierType;
import com.algaworks.algafood.di.notification.UrgenceLevelEnum;
import com.algaworks.algafood.di.service.ActivationClientEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    @NotifierType(UrgenceLevelEnum.LOW)
    @Autowired
    private Notifier notifier;

    @EventListener
    public void ActivationClientListener(ActivationClientEvent event){
        notifier.notify(event.getClient(), "Your registration in the system has been activated.");
    }
}
