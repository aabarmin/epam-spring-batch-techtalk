package com.epam.techtalk.spring.batch.example05;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class JdbcItemWriter implements ItemWriter<String> {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void write(List<? extends String> items) throws Exception {
        final List<Object[]> values = new ArrayList<>();
        for (String item : items) {
            values.add(new Object[]{ item });
        }
        jdbcTemplate.batchUpdate("INSERT INTO quotes_table (`original_text`) VALUES (?)", values);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
