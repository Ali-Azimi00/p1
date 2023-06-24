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
//     System.out.println(statusDAO.findAll());
        return  reimbursementDAO.findAll();
    }

    public Reimbursements createTicket(Reimbursements r){
        return reimbursementDAO.save(r);
    };

    public Reimbursements updateTicket(Reimbursements r){

//        System.out.println("hi " + getAllTickets().get(0).getStatusName());

        if(reimbursementDAO.existsById(r.getReimb_id())){
            System.out.println("Ticket # found and updated");
            return reimbursementDAO.save(r);
        }
        else{
            System.out.println("Ticket #" + r.getReimb_id() + " doesn't exist");
            return null;
        }

    }

    public Reimbursements updateTicketContent(int id,Reimbursements amtDesc) {
        Reimbursements rs = reimbursementDAO.getById(id);
        rs.setAmount(amtDesc.getAmount());
        rs.setDescription(amtDesc.getDescription());
        System.out.println(rs);

        return reimbursementDAO.save(rs);
    }


//    public Reimbursements updateStatus(int ReimbId, int statId){
//
//
//    };




}

