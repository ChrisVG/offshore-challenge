package com.partnerships.interview.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Event
 *
 * @author christian.valencia
 * @since 02/13/2019
 */
@Entity(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date date;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Venue venue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", venue=" + venue +
                '}';
    }
}
