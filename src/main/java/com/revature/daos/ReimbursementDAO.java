package com.revature.daos;

import com.revature.models.Reimbursements;
import com.revature.models.Statuses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Currency;
import java.util.List;

public interface ReimbursementDAO extends JpaRepository<Reimbursements,Integer> {

        List<Reimbursements> findByStatus(Statuses status);

//          boolean existsByReimbersementId(int id);
//
//        List<Reimbursements> getAllTickets();
//
//        Reimbursements createTicket(Reimbursements r);
//
//        Reimbursements changeAmount(int amt);



}
