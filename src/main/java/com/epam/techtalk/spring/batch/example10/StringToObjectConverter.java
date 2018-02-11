package com.epam.techtalk.spring.batch.example10;

import com.epam.techtalk.spring.batch.example05.Citation;
import org.springframework.batch.item.ItemProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToObjectConverter implements ItemProcessor<String, Citation> {
    private final Pattern PATTERN = Pattern.compile(".*“(.*)” — (.*)");

    @Override
    public Citation process(String item) throws Exception {
        final Citation citation = new Citation();
        final Matcher matcher = PATTERN.matcher(item);
        if (matcher.find()) {
            citation.setQuoteText(matcher.group(1));
            citation.setAuthor(matcher.group(2));
        }
        return citation;
    }
}
