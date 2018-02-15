package com.epam.techtalk.spring.batch.example10;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example10Application {
    public static void main(String[] args) throws Exception {
        final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("example10/example10.xml");

        final JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        final Job sequentialJob = context.getBean("example10Job", Job.class);
        jobLauncher.run(sequentialJob, new JobParameters());
    }
}
