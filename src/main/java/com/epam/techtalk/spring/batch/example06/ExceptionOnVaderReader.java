package com.epam.techtalk.spring.batch.example06;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.util.Iterator;
import java.util.stream.Stream;

public class ExceptionOnVaderReader implements ItemReader<String> {
    private Iterator<String> iterator;

    public void init() throws Exception {
        final ClassPathResource resource = new ClassPathResource("source.txt");
        final Stream<String> lines = Files.lines(resource.getFile().toPath());
        iterator = lines.iterator();
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (iterator.hasNext()) {
            final String next = iterator.next();
            if (next.contains("Vader")) {
                throw new VaderException("Vader is here!");
            }
            return next;
        }
        return null;
    }
}
