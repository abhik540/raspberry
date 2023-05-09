package com.scheduler;

import com.model.SystemProperties;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.repository.SystemPropertiesRepository;
import com.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class LightScheduler {

    private final SystemPropertiesRepository systemPropertiesRepository;
    private final GpioPinDigitalOutput gpioPinDigitalOutput_01;

    @Scheduled(cron = "#{@schedulerLightCron}")
    public void run() {
        final Session session = EmailUtils.getSession();
        try {
            System.out.println("Running light scheduler...." + new Date());
            gpioPinDigitalOutput_01.low();
            TimeUnit.MILLISECONDS.sleep(150);
            gpioPinDigitalOutput_01.high();
            System.out.println(gpioPinDigitalOutput_01.getState().getName());
            systemPropertiesRepository.save(SystemProperties.builder()
                    .systemKey("light")
                    .systemValue(new Date().toString())
                    .build());
            try {
                final Message message = EmailUtils.buildMessage(session, "Light ON/OFF", new Date().toString(), "sujan.maharjan.2015@gmail.com");
                Transport.send(message);
            } catch (MessagingException me) {
                System.out.println(me.getLocalizedMessage());
            }
        } catch (Exception e) {
            try {
                final Message message = EmailUtils.buildMessage(session, "Light Failure", e.getLocalizedMessage(), "sujan.maharjan.2015@gmail.com");
                Transport.send(message);
            } catch (MessagingException me) {
                System.out.println(me.getLocalizedMessage());
            }
            systemPropertiesRepository.save(SystemProperties.builder()
                    .systemKey("light-error")
                    .systemValue(new Date().toString())
                    .build());
        }
    }
}
