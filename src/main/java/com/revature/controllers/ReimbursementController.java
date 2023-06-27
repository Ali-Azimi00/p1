package com.revature.controllers;

import com.revature.models.Reimbursements;
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

    @GetMapping
    public List<Reimbursements> getAllTicketsHandler(){
        return reimbursementService.getAllTickets();
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
    public Reimbursements updateTicketHandler(@RequestBody Reimbursements r){
        return reimbursementService.updateTicket(r);
    }

    @PutMapping("{id}")
    public Reimbursements updateTicketContentHandler(
            @PathVariable("id") int id,
            @RequestBody  Reimbursements amtDesc
    ){
        return reimbursementService.updateTicketContent(id,amtDesc);
    }


}
