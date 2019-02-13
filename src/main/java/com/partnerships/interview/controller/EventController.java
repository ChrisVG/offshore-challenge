package com.partnerships.interview.controller;


import com.partnerships.interview.exception.EventDeleteException;
import com.partnerships.interview.exception.EventException;
import com.partnerships.interview.model.Event;
import com.partnerships.interview.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * EventController
 *
 * @author christian.valencia
 * @since 02/13/2019
 */
@RestController
@RequestMapping("/events")
public class EventController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventRepository eventRepository;

    /**
     * Return all the events
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getEvents() {
        try {
            return ResponseEntity.ok(eventRepository.findAll());
        } catch (EventException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * given an id return an event
     *
     * @param id event id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEventsById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(eventRepository.findById(id));
        } catch (EventException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Create an event
     *
     * @param event
     * @return
     */
    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        try {
            return ResponseEntity.ok(eventRepository.save(event));
        } catch (EventException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * update an event
     *
     * @param event
     * @return
     */
    @PutMapping
    public ResponseEntity<?> updateEvent(@RequestBody Event event) {
        try {
            System.out.println(event);
            return ResponseEntity.ok(eventRepository.save(event));
        } catch (EventException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * given an id delete the event
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable(value = "id") Integer id) {
        try {
            eventRepository.delete(eventRepository.findById(id).orElseThrow(EventDeleteException::new));
            return ResponseEntity.ok().build();
        } catch (EventDeleteException e) {
            return ResponseEntity.unprocessableEntity().build();
        }catch (EventException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
