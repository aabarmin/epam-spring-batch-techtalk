package com.epam.techtalk.spring.batch.example07;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example07Application {
    public static void main(String[] args) throws Exception {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example07/example07.xml");

        final JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        final Job sequentialJob = context.getBean("example07Job", Job.class);
        jobLauncher.run(sequentialJob, new JobParameters());
    }
}
