package com.epam.techtalk.spring.batch.example01;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class FileStringWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> items) throws Exception {

    }
}
