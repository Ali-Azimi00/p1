package com.revature.daos;

import com.revature.models.Reimbursements;
import com.revature.models.Statuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Currency;
import java.util.List;

@Repository
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
