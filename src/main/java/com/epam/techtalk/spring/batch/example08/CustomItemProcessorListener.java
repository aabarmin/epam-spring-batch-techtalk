package com.epam.techtalk.spring.batch.example08;

import com.epam.techtalk.spring.batch.example05.Citation;
import org.springframework.batch.core.ItemProcessListener;

public class CustomItemProcessorListener implements ItemProcessListener<Citation, Citation> {
    @Override
    public void beforeProcess(Citation item) {
        System.out.println("Going to process item");
    }

    @Override
    public void afterProcess(Citation item, Citation result) {
        System.out.println("Item was processed");
    }

    @Override
    public void onProcessError(Citation item, Exception e) {

    }
}
