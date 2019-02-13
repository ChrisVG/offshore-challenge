package com.partnerships.interview.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Date;

/**
 * InterviewApplication
 *
 * @author christian.valencia
 * @since 02/13/2019
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.partnerships.interview"})
@EnableJpaRepositories(basePackages = "com.partnerships.interview.repository")
@EntityScan(basePackages = "com.partnerships.interview.model")
public class InterviewApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(InterviewApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(InterviewApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("Creating events table");
        jdbcTemplate.execute("DROP ALL OBJECTS");
        jdbcTemplate.execute("CREATE TABLE VENUES(" +
                "ID SERIAL, " +
                "NAME VARCHAR(255), " +
                "CITY VARCHAR(255), " +
                "STATE VARCHAR(255))");
        jdbcTemplate.execute("CREATE TABLE EVENTS(" +
                "ID SERIAL, " +
                "NAME VARCHAR(255), " +
                "DATE DATE, " +
                "VENUE_ID INT," +
                "FOREIGN KEY (VENUE_ID) REFERENCES EVENTS(ID))");

        //1
        jdbcTemplate.update("INSERT INTO VENUES(NAME, CITY, STATE) VALUES (?,?,?)",
                "RATE FIELD", "CHICAGO", "IL");
        jdbcTemplate.update("INSERT INTO EVENTS(NAME, DATE, VENUE_ID) VALUES (?,?,?)",
                "CHICAGO WHITE SOX VS. CHICAGO CUBS", new Date(), 1);
        //2
        jdbcTemplate.update("INSERT INTO VENUES(NAME, CITY, STATE) VALUES (?,?,?)",
                "Dodger Stadium", "LOS ANGELES", "CA");
        jdbcTemplate.update("INSERT INTO EVENTS(NAME, DATE, VENUE_ID) VALUES (?,?,?)",
                "SAN FRANCISCO GIANTS VS. LOS ANGELES DODGERS", LocalDateTime.now().plus(3, ChronoUnit.MONTHS).plus(8,ChronoUnit.DAYS), 2);
        //3
        jdbcTemplate.update("INSERT INTO VENUES(NAME, CITY, STATE) VALUES (?,?,?)",
                "Yankee Stadium", "NEW YORK CITY", "NY");
        jdbcTemplate.update("INSERT INTO EVENTS(NAME, DATE, VENUE_ID) VALUES (?,?,?)",
                "NEW YORK YANKEES VS TORONTO BLUE JAYS", LocalDateTime.now().plus(3, ChronoUnit.MONTHS), 3);
    }
}
