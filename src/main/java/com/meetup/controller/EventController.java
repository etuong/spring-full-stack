package com.meetup.controller;

import com.meetup.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
}
