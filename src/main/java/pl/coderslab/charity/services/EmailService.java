package pl.coderslab.charity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.MessageDTO;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(MessageDTO messageDTO) {


        System.out.println(messageDTO.getEmail());

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("szambur@o2.pl");
        msg.setFrom("szambur@o2.pl");

        msg.setSubject("CharityDoantions - wiadomosc pod uzytkownika");
        msg.setText(messageDTO.getFirstName()
                    +" "+messageDTO.getLastName()
                    +" ("+messageDTO.getEmail()+") . Wiadomość : "
                    +messageDTO.getMessage()
        );

        javaMailSender.send(msg);
    }



}
