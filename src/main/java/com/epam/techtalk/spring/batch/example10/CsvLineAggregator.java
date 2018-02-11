package com.epam.techtalk.spring.batch.example10;

import com.epam.techtalk.spring.batch.example05.Citation;
import org.springframework.batch.item.file.transform.LineAggregator;

public class CsvLineAggregator implements LineAggregator<Citation> {
    @Override
    public String aggregate(Citation item) {
        return String.format(
                "%s; %s; %s",
                item.getId(),
                item.getAuthor(),
                item.getQuoteText()
        );
    }
}
