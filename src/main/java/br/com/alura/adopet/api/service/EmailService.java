package br.com.alura.adopet.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    public void enviar(String sendFrom, String sendTo, String assunto, String mensagem) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(sendFrom);
        email.setTo(sendTo);
        email.setSubject(assunto);
        email.setText(mensagem);
        emailSender.send(email);
    }
}
