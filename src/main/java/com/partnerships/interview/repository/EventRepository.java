package com.partnerships.interview.repository;


import com.partnerships.interview.model.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * EventRepository
 *
 * @author christian.valencia
 * @since 02/13/2019
 */
public interface EventRepository extends CrudRepository<Event, Integer> {

}