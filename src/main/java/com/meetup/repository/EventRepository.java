package com.meetup.repository;

import com.meetup.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

}