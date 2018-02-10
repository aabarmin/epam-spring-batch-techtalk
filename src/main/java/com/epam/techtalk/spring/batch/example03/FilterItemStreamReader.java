package com.epam.techtalk.spring.batch.example03;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.stream.Stream;

public class FilterItemStreamReader implements ItemStreamReader<String> {
    private Iterator<String> iterator;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        try {
            final ClassPathResource resource = new ClassPathResource("source.txt");
            final Stream<String> lines = Files.lines(resource.getFile().toPath());
            iterator = lines.iterator();
        } catch (IOException e) {
            throw new ItemStreamException(e);
        }
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {

    }

    @Override
    public void close() throws ItemStreamException {

    }
}
