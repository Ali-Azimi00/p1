package com.revature.daos;

import com.revature.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesDAO extends JpaRepository<Roles,Integer> {


    Roles getByTitle(String employee);
}
