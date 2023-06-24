package com.revature.controllers;

import com.revature.models.Reimbursements;
import com.revature.services.ReimbursementService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tickets")
public class ReimbursementController {

    private final ReimbursementService reimbursementService;


    public ReimbursementController(ReimbursementService reimbursementService) {
        this.reimbursementService = reimbursementService;
    }

    @GetMapping
    public List<Reimbursements> getAllTicketsHandler(){
        return reimbursementService.getAllTickets();
    }

    @PostMapping
    public Reimbursements createTicket(@RequestBody Reimbursements r){
        return reimbursementService.createTicket(r);
    }


}
