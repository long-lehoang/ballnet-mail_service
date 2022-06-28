package com.ballnet.mailservice.service;

import javax.mail.MessagingException;

public interface IMailService {
  public void send(String to, String subject, String text);
  public void send(String to, String subject, String text, String pathToAttachment) throws MessagingException;
}
