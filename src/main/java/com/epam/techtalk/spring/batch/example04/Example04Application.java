package com.epam.techtalk.spring.batch.example04;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example04Application {
    public void run() throws Exception {
        final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("example04/example04.xml");

        final JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        final Job jobWithAdapterTasklet = context.getBean("example04Job", Job.class);
        jobLauncher.run(jobWithAdapterTasklet, new JobParameters());

        final Job jobWithCustomTasklet = context.getBean("example05Job", Job.class);
        jobLauncher.run(jobWithCustomTasklet, new JobParameters());
    }

    public static void main(String[] args) throws Exception {
        new Example04Application().run();
    }
}
