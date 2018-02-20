package com.epam.techtalk.spring.batch.example12;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example12Application {
    public static void main(String[] args) throws Exception {
        final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("example12/example12.xml");

        final JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        final Job sequentialJob = context.getBean("example12Job", Job.class);
        jobLauncher.run(sequentialJob, getJobParameters());
    }

    private static JobParameters getJobParameters() {
        final JobParametersBuilder builder = new JobParametersBuilder();
        builder.addString("HeroNames", "Yoda, Jinn, Obi-Wan, Vader");
        return builder.toJobParameters();
    }
}
