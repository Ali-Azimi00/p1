package com.revature.services;

import com.revature.daos.RolesDAO;
import com.revature.daos.UserDAO;

import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDAO userDao;
    private final RolesDAO rolesDao;

    @Autowired
    public UserService(UserDAO userDao, RolesDAO rolesDao) {
        this.userDao = userDao;
        this.rolesDao = rolesDao;
    }
//    public User createUser(User u){
//        // Now let's call the DAO methods to actually create the teacher
//        // do I do double of this to make fm and employee
//        User returnedUser = userDao.save(u);
//
//        // If successful we should have a positive Id
//        if (returnedUser.getId() > 0){
//            // TODO create a log for success
//        } else{
//            // TODO create a log for failure
//        }
//
//        return returnedUser;
//    }

    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    public Optional<User> getUserById(int id){
        System.out.println(userDao.findById(id));
        userDao.findById(id);
        System.out.println(userDao.existsById(id));

        if(userDao.existsById(id)){
            User u = userDao.getReferenceById(id);
            return Optional.of(u); //TODO create try/catch if
        }
        else{
            System.out.println("No user with Id# " + id + " exists");
            return null;
        }
    }

    public User createUser (User u){
        return userDao.save(u);
    }

    public User updateUser (User u){
        return userDao.save(u);
    }

    public User updateUserById(int id, User u){
        u.setId(id);
        return userDao.save(u);
    }

//    public User


//    public User getUserById(int id){
//        return userDao.findById(id).orElseThrow(() -> new UserNotFoundException("No user found with id: " + id));
//    }

//    public User updateUser(User u){
//        return userDao.save(u);
//    }

//    public boolean deleteUserById(int id){
//        userDao.deleteById(id);
//
//        if (!userDao.existsById(id)){
//            return true;
//        } else{
//            return false;
//        }
//    }

//    public List<Role> getRolesByUserId(int id){
//
//        Optional<User> returnedUser = userDao.findById(id);
//
//        if (returnedUser.isPresent()){
//            return returnedUser.get().getRoles();
//        } else{
//            throw new UserNotFoundException("No User with id: " + id);
//        }
//    }
    // this might be used for later
//    public User registerForRole(int uid, int rid){
//        User u = getUserById(uid);
//
//        List<Role> roles = u.getRoles();
//
//        Optional<Role> returnedRole = roleDao.findById(rid);
//
//        if (returnedRole.isPresent()){
//            if (!roles.contains(returnedRole.get())){
//                roles.add(returnedRole.get());
//
//                u.setRoles(roles);
//
//                userDao.save(u);
//            }
//        } else{
//            throw new RoleNotFoundException("No Role with id: " + rid);
//        }
//
//        return u;
//    }

//    public User unregisterForRole(int uid, int rid){
//        User u = getUserById(uid);
//
//        List<Role> roles = u.getRoles();
//
//        Optional<Role> returnedRole = roleDao.findById(rid);
//
//        if (returnedRole.isPresent() && roles.contains(returnedRole.get())){
//            roles.remove(returnedRole.get());
//            u.setRoles(roles);
//            userDao.save(u);
//        } else{
//            throw new RoleNotFoundException("No Role with id: " + rid);
//        }
//
//        return u;
//    }

}