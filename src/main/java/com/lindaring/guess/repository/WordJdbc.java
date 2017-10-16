package com.lindaring.guess.repository;

import com.lindaring.guess.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordJdbc {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Word> findRandomLimit(int enabled, int limit) {
        String sql = String.format("SELECT word_id, word, enabled FROM word WHERE enabled = %d ORDER BY RAND() LIMIT %d", enabled, limit);
        List<Word> result = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Word(rs.getInt("word_id"), rs.getString("word"), rs.getInt("enabled"))
        );
        return result;
    }
    
}
