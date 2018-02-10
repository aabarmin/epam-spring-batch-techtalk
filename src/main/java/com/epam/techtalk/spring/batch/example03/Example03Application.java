package com.epam.techtalk.spring.batch.example03;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example03Application {
    private long count = 0;

    public void run() throws Exception {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example03/example03.xml");

        final JobLauncher syncJobLauncher = context.getBean("syncJobLauncher", JobLauncher.class);
        final JobLauncher asyncJobLauncher = context.getBean("asyncJobLauncher", JobLauncher.class);

        final Job job = context.getBean("example03Job", Job.class);

        run(syncJobLauncher, job);
        run(asyncJobLauncher, job);
    }

    private void run(JobLauncher jobLauncher, Job job) throws Exception {
        final long startTime = System.nanoTime();

        final JobParametersBuilder builder = new JobParametersBuilder();
        builder.addLong("jobIndex", ++count);
        final JobExecution jobExecution = jobLauncher.run(job, builder.toJobParameters());

        System.out.println(String.format(
                "Started at %s, finished at %s, status is %s",
                startTime,
                System.nanoTime(),
                jobExecution.getStatus()
        ));
    }

    public static void main(String[] args) throws Exception {
        new Example03Application().run();
    }
}
