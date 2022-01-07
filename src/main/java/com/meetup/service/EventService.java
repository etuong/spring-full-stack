package com.meetup.service;

import com.meetup.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> findAll();

    Event findOne(Long id);

    Event save(Event event);
}
