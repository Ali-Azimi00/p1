//package com.revature.security;
//
//import com.revature.daos.UserDAO;
//import com.revature.models.Roles;
//import com.revature.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserDAO userDAO;
//
//    @Autowired
//    public CustomUserDetailsService(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User u = userDAO.findByUsername(username); //TODO add .orElstThrow()
//
//        return new org.springframework.security.core.userdetails.User(
//                u.getUsername(),u.getPassword(), mapRoleToAuthority(u.getRoles())
//        );
//
//    }
//
//    private Collection<GrantedAuthority> mapRoleToAuthority(Roles role){
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//
//        grantedAuthorities.add(new SimpleGrantedAuthority(role.getTitle()));
//
//        return grantedAuthorities;
//    }
//}
