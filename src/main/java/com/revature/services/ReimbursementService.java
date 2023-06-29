package com.revature.services;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.StatusDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Reimbursements;
import com.revature.models.Statuses;
import com.revature.models.User;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return reimbursementDAO.findAll();
    }

    public List<Reimbursements> getAllTicketsByStatus(String status_name){
        Statuses currentStatus = statusDAO.findByStatusName(status_name);

        System.out.println(reimbursementDAO.findByStatus(currentStatus));

        return reimbursementDAO.findByStatus(currentStatus);
    }

    public List<Reimbursements> getAllTicketsByUserId(int id){
        userDAO.findById(id);

        List<Reimbursements> rList = new ArrayList<>();
        rList = reimbursementDAO.findAll();

        List<Reimbursements> listByUser = new ArrayList<>();

        for(int i=0; i<rList.toArray().length; i++){
            Reimbursements currentR = rList.get(i);
            User currentU = currentR.getUser();

            if(currentU.getId() ==  id){
                listByUser.add(currentR);
            }

        }

        System.out.println(listByUser);
        return  listByUser;
    }

    public Reimbursements createTicket(int id, Reimbursements r){
        User u = new User();
        u.setId(id);
        r.setUser(u);

        Statuses s= new Statuses();
        s.setId(1); //default status is set to pending
        System.out.println(s);
        r.setStatus(s);

        return reimbursementDAO.save(r);
    };

    public Reimbursements updateTicketStatus(Reimbursements r){
        if(reimbursementDAO.existsById(r.getReimb_id())){
            System.out.println("Ticket #" +r.getReimb_id() +" found and status updated");

            int reimb_id = r.getReimb_id();
            Reimbursements rs = reimbursementDAO.getById(reimb_id);
            rs.setStatus(r.getStatus());

            return reimbursementDAO.save(rs);
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

}

