package com.epam.techtalk.spring.batch.example05;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCitationMapper implements RowMapper<Citation> {
    @Override
    public Citation mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Citation citation = new Citation();
        citation.setId(rs.getInt("id"));
        citation.setOriginalText(rs.getString("original_text"));
        citation.setQuoteText(rs.getString("quote_text"));
        citation.setAuthor(rs.getString("author"));
        return citation;
    }
}
