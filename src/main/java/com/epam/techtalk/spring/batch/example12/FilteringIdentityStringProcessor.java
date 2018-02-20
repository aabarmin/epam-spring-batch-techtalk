package com.epam.techtalk.spring.batch.example12;

import org.springframework.batch.item.ItemProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class FilteringIdentityStringProcessor implements ItemProcessor<String, String> {
    private Collection<String> heroNames = new ArrayList<>();

    @Override
    public String process(String item) throws Exception {
        if (containsAny(item)) {
            return item;
        }
        return null;
    }

    private boolean containsAny(String item) {
        for (String heroName : heroNames) {
            if (item.contains(heroName)) {
                return true;
            }
        }
        return false;
    }

    public void setHeroNames(String heroNamesString) {
        heroNames = Arrays.asList(heroNamesString.split(", "));
    }
}
