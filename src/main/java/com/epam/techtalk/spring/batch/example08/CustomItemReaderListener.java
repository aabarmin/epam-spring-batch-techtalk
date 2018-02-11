package com.epam.techtalk.spring.batch.example08;

import org.springframework.batch.core.ItemReadListener;

public class CustomItemReaderListener implements ItemReadListener<String> {
    private int readTotal = 0;

    @Override
    public void beforeRead() {

    }

    @Override
    public void afterRead(String item) {
        System.out.println("Item was read");
        readTotal++;
    }

    @Override
    public void onReadError(Exception ex) {

    }

    public int getReadTotal() {
        return readTotal;
    }
}
