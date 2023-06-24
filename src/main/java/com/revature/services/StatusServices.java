package com.revature.services;

import com.revature.daos.StatusDAO;
import com.revature.models.Statuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServices {

    private final StatusDAO statusDAO;

    @Autowired
    public StatusServices(StatusDAO statusDAO) {
        this.statusDAO = statusDAO;
    };

    public List<Statuses> getAllStatuses(){
        List<Statuses> statuses = statusDAO.findAll();

        return statuses;
    };
//
//    public Statuses updateStatus(Statuses s){
//       return statusDAO.save(s);
//    };
//



}
