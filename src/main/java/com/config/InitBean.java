package com.config;

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
}
