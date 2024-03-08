package org.codeer.ICES4HU.Service;

import java.util.Date;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailService {
    public void sendMail(String from, String to, String subject, String body) {
        var now = new Date();
        log.info("A mail is sent at " + now + "\nFrom: " + from + "\nTo: " + to + "\n" +
                "Subject: \n" + subject + "\n" + "Body: \n" + body + "\n");
    }
}
