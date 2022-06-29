package com.ballnet.mailservice.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@AllArgsConstructor
@Slf4j
public class MailService implements IMailService{
  private final JavaMailSender emailSender;

  @Override
  public void send(String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("noreply@baeldung.com");
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    emailSender.send(message);
  }

  @Override
  public void send(String to, String subject, String text, String pathToAttachment) throws MessagingException {
    MimeMessage message = emailSender.createMimeMessage();

    MimeMessageHelper helper = new MimeMessageHelper(message, true);

    helper.setFrom("noreply@baeldung.com");
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(text);

    FileSystemResource file
        = new FileSystemResource(new File(pathToAttachment));
    helper.addAttachment("Invoice", file);

    emailSender.send(message);
  }
}
