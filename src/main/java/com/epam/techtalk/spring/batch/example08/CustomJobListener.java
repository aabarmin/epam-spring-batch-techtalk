package com.epam.techtalk.spring.batch.example08;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class CustomJobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Job is going to start");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("Job is finished");
    }
}
