package com.epam.techtalk.spring.batch.example08;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Example08Application {
    public static void main(String[] args) throws Exception {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example08/example08.xml");

        final JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        final Job sequentialJob = context.getBean("example08Job", Job.class);
        jobLauncher.run(sequentialJob, new JobParameters());

        final CustomItemReaderListener readerListener = context.getBean("readerListener", CustomItemReaderListener.class);
        System.out.println("Items were read: " + readerListener.getReadTotal());

        final CustomItemWriterListener writerListener = context.getBean("writerListener", CustomItemWriterListener.class);
        System.out.println("Stats:");
        for (Map.Entry<String, Integer> entry : writerListener.getCitationsStats().entrySet()) {
            System.out.println("   " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
