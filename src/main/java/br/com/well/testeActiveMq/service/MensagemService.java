package br.com.well.testeActiveMq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    @Autowired
    private JmsTemplate jms;

    @Autowired
    public MensagemService(JmsTemplate jms) {
        this.jms = jms;
    }

    public void enviar(String mensagem){
        jms.convertAndSend("address.foo:q1",mensagem);
    }

}
