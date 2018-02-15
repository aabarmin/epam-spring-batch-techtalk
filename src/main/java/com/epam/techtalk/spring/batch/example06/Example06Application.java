package com.epam.techtalk.spring.batch.example06;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example06Application {
    public static void main(String[] args) throws Exception {
        final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("example06/example06.xml");

        final JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        final Job sequentialJob = context.getBean("example06Job", Job.class);
        jobLauncher.run(sequentialJob, new JobParameters());
    }
}
