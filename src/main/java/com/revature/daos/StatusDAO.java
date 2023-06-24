package com.revature.daos;

import com.revature.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDAO extends JpaRepository<Status,Integer> {

//    List<Statuses> findByStatus (String status);


//    Statuses getByStatus (String statusName);

}
