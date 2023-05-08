package com.scheduler;


import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class FeederScheduler {
    private static GpioPinDigitalOutput gpioPinDigitalOutput_02 = null;

    final GpioController gpio = GpioFactory.getInstance();

    @Scheduled(cron = "#{@schedulerFeederCron}")
    public void run() throws InterruptedException {
        System.out.println("Running feeder scheduler...." + new Date());
        if (gpioPinDigitalOutput_02 == null) {
            gpioPinDigitalOutput_02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
        }
        gpioPinDigitalOutput_02.low();
        TimeUnit.MILLISECONDS.sleep(150);
        gpioPinDigitalOutput_02.high();
        System.out.println(gpioPinDigitalOutput_02.getState().getName());
    }
}
