package com.scheduler;

import com.model.SystemProperties;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.repository.SystemPropertiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class LightScheduler {

    private final SystemPropertiesRepository systemPropertiesRepository;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_01 = null;

    @Scheduled(cron = "#{@schedulerLightCron}")
    public void run() {
        try {
            System.out.println("Running light scheduler...." + new Date());
            if (gpioPinDigitalOutput_01 == null) {
                gpioPinDigitalOutput_01 = GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.GPIO_01);
            }
            gpioPinDigitalOutput_01.low();
            TimeUnit.MILLISECONDS.sleep(150);
            gpioPinDigitalOutput_01.high();
            System.out.println(gpioPinDigitalOutput_01.getState().getName());
            systemPropertiesRepository.save(SystemProperties.builder()
                    .systemKey("light")
                    .systemValue(new Date().toString())
                    .build());
        } catch (Exception e) {
            systemPropertiesRepository.save(SystemProperties.builder()
                    .systemKey("light - error")
                    .systemValue(new Date().toString())
                    .build());
        }
    }
}
