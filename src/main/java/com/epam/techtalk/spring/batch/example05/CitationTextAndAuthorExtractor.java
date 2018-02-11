package com.epam.techtalk.spring.batch.example05;

import org.springframework.batch.item.ItemProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CitationTextAndAuthorExtractor implements ItemProcessor<Citation, Citation> {
    private final Pattern PATTERN = Pattern.compile(".*“(.*)” — (.*)");

    @Override
    public Citation process(Citation item) throws Exception {
        final Matcher matcher = PATTERN.matcher(item.getOriginalText());
        if (matcher.find()) {
            item.setQuoteText(matcher.group(1));
            item.setAuthor(matcher.group(2));
        }
        return item;
    }
}
