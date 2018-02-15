package com.epam.techtalk.spring.batch.example01;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example01Application {
    public static void main(String[] args) throws Exception {
        final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("example01/example01.xml");

        final JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        final Job job = context.getBean("example01Job", Job.class);

        final JobExecution execution = jobLauncher.run(job, new JobParameters());
        System.out.println(execution.getStatus());
    }
}
