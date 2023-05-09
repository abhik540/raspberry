package com.config;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.service.SystemPropertiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitBean {

    private final SystemPropertiesService systemPropertiesService;

    @Bean(name = "schedulerFeederCron")
    public String getSchedulerFeederCron() {
        return systemPropertiesService.findByKey("scheduler.feeder.cron").getSystemValue();
    }

    @Bean(name = "schedulerLightCron")
    public String getSchedulerLightCron() {
        return systemPropertiesService.findByKey("scheduler.light.cron").getSystemValue();
    }

    @Bean(name = "schedulerEmailCron")
    public String getSchedulerEmailCron() {
        return systemPropertiesService.findByKey("scheduler.email.cron").getSystemValue();
    }

    @Bean(name = "gpioPinDigitalOutput_02")
    public GpioPinDigitalOutput init02() {
        try {
            return GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.GPIO_02);
        } catch (Exception e) {
            return null;
        }
    }

    @Bean(name = "gpioPinDigitalOutput_01")
    public GpioPinDigitalOutput init01() {
        try {
            return GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.GPIO_01);
        } catch (Exception e) {
            return null;
        }
    }
}
