package com.epam.techtalk.spring.batch.example12;

import com.epam.techtalk.spring.batch.example05.Citation;
import org.springframework.batch.item.ItemProcessor;

public class IdentityCitationProcessor implements ItemProcessor<Citation, Citation> {
    @Override
    public Citation process(Citation item) throws Exception {
        return item;
    }
}
