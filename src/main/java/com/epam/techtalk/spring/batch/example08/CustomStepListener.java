package com.epam.techtalk.spring.batch.example08;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class CustomStepListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println(String.format(
                "Step %s is going to start",
                stepExecution.getStepName()
        ));
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println(String.format(
                "Step %s is finished",
                stepExecution.getStepName()
        ));
        return stepExecution.getExitStatus();
    }
}
