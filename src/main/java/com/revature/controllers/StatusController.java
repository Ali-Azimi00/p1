package com.revature.controllers;

import com.revature.models.Statuses;
import com.revature.services.StatusServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("statuses")
public class StatusController {

    private final StatusServices statusServices;

    @Autowired
    public StatusController(StatusServices statusServices) {
        this.statusServices = statusServices;
    }

    @GetMapping
    public List<Statuses> getAllStatuses (){
            return statusServices.getAllStatuses();
    };


}
