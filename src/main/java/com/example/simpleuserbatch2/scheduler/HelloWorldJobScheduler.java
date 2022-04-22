package com.example.simpleuserbatch2.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@EnableScheduling
public class HelloWorldJobScheduler {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job helloWorldJob;


    //@Scheduled(fixedRate = 30 * 1000)
    //@Scheduled(cron="*/30 * * * * *")
    //@Scheduled(initialDelay = 30 * 1000, fixedDelay = 30 * 1000)
    @Scheduled(initialDelay = 30 * 1000, fixedRate = 30 * 1000)
    public void runJob() throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addString("time", String.valueOf(System.nanoTime()))
                .toJobParameters();
        log.info("Starting Scheduled Job");
        jobLauncher.run(helloWorldJob, params);
    }
}
