package com.epam.techtalk.spring.batch.example04;

public class SomeExternalWorkExecutor {
    public void doSomeWork() throws Exception {
        System.out.println("External work started");
        Thread.sleep(1000);
        System.out.println("External work finished");
    }
}
