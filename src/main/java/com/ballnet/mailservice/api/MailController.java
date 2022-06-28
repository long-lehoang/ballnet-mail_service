package com.ballnet.mailservice.api;

import com.ballnet.mailservice.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {
  private final MailService mailService;
}
