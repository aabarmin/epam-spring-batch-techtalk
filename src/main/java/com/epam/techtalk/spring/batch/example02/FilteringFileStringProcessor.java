package com.epam.techtalk.spring.batch.example02;

import org.springframework.batch.item.ItemProcessor;

public class FilteringFileStringProcessor implements ItemProcessor<String, String> {
    private String heroName;

    @Override
    public String process(String item) throws Exception {
        if (item.contains(heroName)) {
            return item;
        }
        return null;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }
}
