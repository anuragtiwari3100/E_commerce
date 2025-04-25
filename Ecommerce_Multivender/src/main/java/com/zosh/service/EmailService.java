package com.zosh.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;

@Service
@RequiredArgsConstructor
public class EmailService {
  private final JavaMailSender javaMailSender;
  public  void  sendVerificationOtpEmail(String  userEmail,String  otp,String subject,String text) throws MessagingException {
    try{
        MimeMessage mimeMessag =  javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessag,"utf-8");
                mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text);
        mimeMessageHelper.setTo(userEmail);
        javaMailSender.send(mimeMessag);


    }catch (MailException e){
        throw   new MailSendException("failed to send email");
    }

  }
}
