package com.epam.techtalk.spring.batch.example09;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class VaderStepExecutionListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        if (stepExecution.getSkipCount() > 1) {
            return new ExitStatus("VADER");
        }
        return ExitStatus.COMPLETED;
    }
}
