package com.meetup.service.impl;

import com.meetup.entity.Event;
import com.meetup.repository.EventRepository;
import com.meetup.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAll() {
        List<Event> eventList = (List<Event>) eventRepository.findAll();
        return eventList;
    }

    public Event findOne(Long id) {
        return eventRepository.findById(id).get();
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }
}
