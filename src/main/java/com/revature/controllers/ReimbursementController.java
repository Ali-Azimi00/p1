package com.revature.controllers;

import com.revature.models.Reimbursements;
import com.revature.models.Statuses;
import com.revature.services.ReimbursementService;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("tickets")
public class ReimbursementController {

    private final ReimbursementService reimbursementService;

    public ReimbursementController(ReimbursementService reimbursementService) {
        this.reimbursementService = reimbursementService;
    }

    @GetMapping("manager/{status_name}")
    public List<Reimbursements> getAllTicketsByStatusHandler(@PathVariable("status_name") String status_name){
        return reimbursementService.getAllTicketsByStatus(status_name);
    }

    @GetMapping("user/{id}")
    public List<Reimbursements> getAllTicketsHandler(@PathVariable("id") int id){
        return reimbursementService.getAllTicketsByUserId(id);
    }

    @PostMapping("{id}")
    public Reimbursements createTicketHandler(
            @PathVariable("id") int id,
            @RequestBody Reimbursements r
    )
    {
        return reimbursementService.createTicket(id,r);
    }

    @PutMapping
    public Reimbursements updateTicketStatusHandler(
//            @PathVariable("id") int id,
            @RequestBody Reimbursements r
    ){

        return reimbursementService.updateTicketStatus(r);
    }

    @PutMapping("{id}")
    public Reimbursements updateTicketContentHandler(
            @PathVariable("id") int id,
            @RequestBody  Reimbursements amtDesc
    ){
        return reimbursementService.updateTicketContent(id,amtDesc);
    }



}
