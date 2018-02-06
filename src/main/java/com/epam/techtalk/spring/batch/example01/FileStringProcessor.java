package com.epam.techtalk.spring.batch.example01;

import org.springframework.batch.item.ItemProcessor;

public class FileStringProcessor implements ItemProcessor<String, String> {
    @Override
    public String process(String item) throws Exception {
        return null;
    }
}
