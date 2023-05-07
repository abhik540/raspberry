package com.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Scheduler {

    @Scheduled(cron = "0 0/2 * * * ?")
    public void run() {
        System.out.println("running...." + new Date());
    }
}
