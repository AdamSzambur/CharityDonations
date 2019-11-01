package pl.coderslab.charity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.MessageDTO;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.repositories.UserRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;

    public void sendMessage(MessageDTO messageDTO) {

        String title = "CharityDoantions - wiadomość od użytkownika";
        String message = "Wiadomość od <b>"
                +messageDTO.getFirstName()
                + " " + messageDTO.getLastName()
                + "</b> (" + messageDTO.getEmail() + ") <br>"
                + messageDTO.getMessage();
        sendHTMLMessage("szambur@o2.pl", message, title);
    }

    public void sendResetPassword(String email, String serverAddress) {
        User user = userRepository.findByEmail(email);
        String htmlMsg = "Naciśnij <a href='"
                + serverAddress + "/users/reset_password_process?userEmail="
                + email + "&userUUID="
                + user.getUuid().toString()
                + "'>link</a> żeby przejść do strony resetowania hasła";
        String title = "CharityDonations - link do resetowania hasła";

        sendHTMLMessage(email, htmlMsg, title);
    }

    public void sendActiveUser(String email, String serverAddress) {
        User user = userRepository.findByEmail(email);
        String htmlMsg = "Naciśnij <a href=\""
                + serverAddress + "/users/register_process?userEmail="
                + email + "&userUUID="
                + user.getUuid().toString()
                + "\">link</a> żeby aktywować konto";
        String title = "CharityDonations - link do aktywacji konta";
        sendHTMLMessage(email,htmlMsg,title);
    }

    public void sendHTMLMessage(String email, String message, String title) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = message;
        try {
            mimeMessage.setContent(htmlMsg, "text/html;charset=utf-8");
            helper.setTo(email);
            helper.setSubject(title);
            helper.setFrom("szambur@o2.pl");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
