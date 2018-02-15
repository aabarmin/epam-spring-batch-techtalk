package com.epam.techtalk.spring.batch.example01;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class FileStringWriter implements ItemWriter<String> {
    private int counter = 0;

    @Override
    public void write(List<? extends String> items) throws Exception {
        System.out.println("Chunk no: " + ++counter);
        for (String item : items) {
            System.out.println(" -- " + item);
        }
    }
}
