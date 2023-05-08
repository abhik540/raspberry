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
public class FeederScheduler {

    private final SystemPropertiesRepository systemPropertiesRepository;
    private static GpioPinDigitalOutput gpioPinDigitalOutput_02 = null;

    @Scheduled(cron = "#{@schedulerFeederCron}")
    public void run() throws InterruptedException {
        try {
            System.out.println("Running feeder scheduler...." + new Date());
            if (gpioPinDigitalOutput_02 == null) {
                gpioPinDigitalOutput_02 = GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.GPIO_02);
            }
            gpioPinDigitalOutput_02.low();
            TimeUnit.MILLISECONDS.sleep(150);
            gpioPinDigitalOutput_02.high();
            System.out.println(gpioPinDigitalOutput_02.getState().getName());
            systemPropertiesRepository.save(SystemProperties.builder()
                    .systemKey("feeder")
                    .systemValue(new Date().toString())
                    .build());
        } catch (Exception e) {
            systemPropertiesRepository.save(SystemProperties.builder()
                    .systemKey("feeder-error")
                    .systemValue(new Date().toString())
                    .build());
        }
    }
}
