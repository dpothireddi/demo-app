package com.snap.svixpocserver.service.impl;

import com.snap.svixpocserver.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

  private JavaMailSender javaMailSender;

  public EmailServiceImpl( final JavaMailSender javaMailSender ) {
    this.javaMailSender = javaMailSender;
  }

  @Override
  public String send( final String to, final String sub, final String msg ) {
    try {

      // Creating a simple mail message
      SimpleMailMessage mailMessage
              = new SimpleMailMessage();

      // Setting up necessary details
      mailMessage.setFrom( "slack.alerts.rhinos@gmail.com" );
      mailMessage.setTo( to );
      mailMessage.setText( sub );
      mailMessage.setSubject( msg );

      // Sending the mail
      javaMailSender.send( mailMessage );
      return "Mail Sent Successfully...";
    }

    catch ( Exception e ) {
      return "Error while Sending Mail";
    }
  }


}
