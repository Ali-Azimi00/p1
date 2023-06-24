package com.revature.services;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.StatusDAO;
import com.revature.models.Reimbursements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReimbursementService {

    private final ReimbursementDAO reimbursementDAO;

    private final StatusDAO statusDAO;

    @Autowired
    public ReimbursementService(ReimbursementDAO reimbursementDAO, StatusDAO statusDAO) {
        this.reimbursementDAO = reimbursementDAO;
        this.statusDAO = statusDAO;
    }

    public List<Reimbursements> getAllTickets(){
        return  reimbursementDAO.findAll();
    }
    public Reimbursements createTicket(Reimbursements r){
        return reimbursementDAO.save(r);
    };

//    public List<Reimbursements> getAllTickets(){
//        return reimbursementDAO.findAll();
//    }
//
//    public Reimbursements updateTicket(Reimbursements r){
//        return reimbursementDAO.save(r);
//    }

//    public Reimbursements updateStatus(int ReimbId, int statId){
//
//
//    };




}

