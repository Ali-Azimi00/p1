package com.revature.services;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.StatusDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Reimbursements;
import com.revature.models.Statuses;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReimbursementService {

    private final ReimbursementDAO reimbursementDAO;
    private final StatusDAO statusDAO;
    private final UserDAO userDAO;


    @Autowired
    public ReimbursementService(ReimbursementDAO reimbursementDAO, StatusDAO statusDAO, UserDAO userDAO) {
        this.reimbursementDAO = reimbursementDAO;
        this.statusDAO = statusDAO;
        this.userDAO = userDAO;
    }

    public List<Reimbursements> getAllTickets(){
//     System.out.println(statusDAO.findAll());
//        User u = new User();
//        System.out.println(u.getId());
        return  reimbursementDAO.findAll();
    }

    public Reimbursements createTicket(int id, Reimbursements r){
        User u = new User();
        u.setId(id);
        r.setUser(u);
//        Status s = statusDAO.getById(r.getStatus().getId());
//        System.out.println(s)
//        r.setStatus(s);
//        System.out.println(r);
//
        Statuses s= new Statuses();
        s.setId(1);
        System.out.println(s);
        r.setStatus(s);
//
//        User u = userDAO.getById(r.getUser().getId());
//        System.out.println(u);
//        r.setUser(u);
//        System.out.println(r);

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

