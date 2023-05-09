package com.scheduler;

import com.service.SystemPropertiesService;
import com.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private final SystemPropertiesService systemPropertiesService;

    @Scheduled(cron = "#{@schedulerEmailCron}")
    public void run() {
        final Session session = EmailUtils.getSession();
        try {
            System.out.println("Running email scheduler...." + new Date());
            String emailTo = systemPropertiesService.findByKey("email.to").getSystemValue();
            String messageText = systemPropertiesService.findByKey("message").getSystemValue();
            String subject = systemPropertiesService.findByKey("subject").getSystemValue();
            if (StringUtils.isEmpty(emailTo) || StringUtils.isEmpty(messageText) || StringUtils.isEmpty(subject)) {
                System.out.println("Skipped email sending");
                return;
            }
            final Message message = EmailUtils.buildMessage(session, subject, messageText, emailTo);
            Transport.send(message);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
