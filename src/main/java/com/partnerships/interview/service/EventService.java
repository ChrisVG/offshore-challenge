package com.partnerships.interview.service;

import com.partnerships.interview.EventRowMapper;
import com.partnerships.interview.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EventService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public List<Event> getEvents() {
         return jdbcTemplate.query("SELECT * FROM events", new EventRowMapper());
    }
}
