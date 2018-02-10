package com.epam.techtalk.spring.batch.example02;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example02Application {
    public void run() throws Exception {
        final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("example02/example02.xml");

        final JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        final Job job = context.getBean("example02Job", Job.class);

        final JobParameters parameters = getJobParameters();
        final JobExecution execution = jobLauncher.run(job, parameters);
    }

    private JobParameters getJobParameters() {
        final JobParametersBuilder builder = new JobParametersBuilder();
        builder.addString("HeroName", "Yoda");
        return builder.toJobParameters();
    }

    public static void main(String[] args) throws Exception {
        new Example02Application().run();
    }
}
