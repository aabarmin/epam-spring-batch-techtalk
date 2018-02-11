package com.epam.techtalk.spring.batch.example08;

import com.epam.techtalk.spring.batch.example05.Citation;
import org.springframework.batch.core.ItemWriteListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomItemWriterListener implements ItemWriteListener<Citation> {
    private final Map<String, Integer> citationsStats = new HashMap<>();

    @Override
    public void beforeWrite(List<? extends Citation> items) {

    }

    @Override
    public void afterWrite(List<? extends Citation> items) {
        for (Citation item : items) {
            Integer citations = citationsStats.get(item.getAuthor());
            if (citations == null) {
                citations = 0;
            }
            citationsStats.put(item.getAuthor(), ++citations);
        }
    }

    @Override
    public void onWriteError(Exception exception, List<? extends Citation> items) {

    }

    public Map<String, Integer> getCitationsStats() {
        return citationsStats;
    }
}
