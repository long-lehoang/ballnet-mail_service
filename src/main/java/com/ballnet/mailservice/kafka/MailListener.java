package com.ballnet.mailservice.kafka;

import com.ballnet.mailservice.model.User;
import com.ballnet.mailservice.service.IMailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MailListener {

  private final IMailService mailService;

  @KafkaListener(topics = "registration", groupId = "${kafka.group}")
  public void listenGroupFoo(User user) {
    //TODO
    System.out.println("Received Message in group foo: " + user);
    mailService.send("","","");
  }

}
