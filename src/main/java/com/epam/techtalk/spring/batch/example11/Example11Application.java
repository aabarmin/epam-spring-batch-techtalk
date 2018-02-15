package com.epam.techtalk.spring.batch.example11;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example11Application {
    public static void main(String[] args) throws Exception {
        final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("example11/example11.xml");

        final JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        final Job sequentialJob = context.getBean("example11Job", Job.class);
        jobLauncher.run(sequentialJob, new JobParameters());
    }
}
