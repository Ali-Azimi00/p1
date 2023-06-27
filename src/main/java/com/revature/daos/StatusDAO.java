package com.revature.daos;

import com.revature.models.Statuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusDAO extends JpaRepository<Statuses,Integer> {

//    List<Statuses> findByStatus (String status);
    Statuses findByStatusName (String status_name);

//    Statuses getByStatus (String statusName);

}
