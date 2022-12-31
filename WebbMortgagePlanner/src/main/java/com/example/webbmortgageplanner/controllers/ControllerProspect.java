package com.example.webbmortgageplanner.controllers;

import com.example.webbmortgageplanner.repositories.ProspectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerProspect {

    @Autowired
    private ProspectRepo prospectRepo;

    /**
     * Mapping GET request to the index page.
     * Adds all prospects from prospectrepo/db to the model and view object
     * to be presented.
     * */

    @GetMapping("/")
    public ModelAndView index() {

        System.out.println("GET request for index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("allProspects", prospectRepo.findAll());

        return modelAndView;
    }
}
