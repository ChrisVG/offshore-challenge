package com.partnerships.interview.repository;

import com.partnerships.interview.model.Venue;
import org.springframework.data.repository.CrudRepository;

/**
 * EventRepository
 *
 * @author christian.valencia
 * @since 02/13/2019
 */
public interface VenueRepository extends CrudRepository<Venue, Integer> {

}
