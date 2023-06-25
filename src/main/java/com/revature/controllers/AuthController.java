//package com.revature.controllers;
//
//import com.revature.daos.ReimbursementDAO;
//import com.revature.daos.RolesDAO;
//import com.revature.daos.StatusDAO;
//import com.revature.daos.UserDAO;
//import com.revature.dtos.AuthResponseDTO;
//import com.revature.dtos.LoginDTO;
//import com.revature.dtos.RegisterDTO;
//import com.revature.models.Roles;
//import com.revature.models.User;
//import com.revature.security.JwtGenerator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("auth")
//public class AuthController {
//    private final AuthenticationManager authenticationManager;
//    private final UserDAO userDAO;
//    private final RolesDAO rolesDAO;
//    private final ReimbursementDAO reimbursementDAO;
//    private final StatusDAO statusDAO;
//
//    private final PasswordEncoder passwordEncoder;
//
//    private final JwtGenerator jwtGenerator;
//
//    @Autowired
//    public AuthController(AuthenticationManager authenticationManager, UserDAO userDAO,
//                          RolesDAO rolesDAO, ReimbursementDAO reimbursementDAO,
//                          StatusDAO statusDAO, PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator)
//    {
//        this.authenticationManager = authenticationManager;
//        this.userDAO = userDAO;
//        this.rolesDAO = rolesDAO;
//        this.reimbursementDAO = reimbursementDAO;
//        this.statusDAO = statusDAO;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtGenerator = jwtGenerator;
//    }
//
//    @PostMapping("register")
//    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO){
//
//        if(userDAO.existsByUsername(registerDTO.getUsername())){
//            return new ResponseEntity<String>("Username already exists", HttpStatus.BAD_REQUEST);
//        }
//
//        User user = new User();
//        user.setFirstName(registerDTO.getFirstName());
//        user.setLastName(registerDTO.getLastName());
//        user.setUsername(registerDTO.getUsername());
//        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
//
////        Roles r = rolesDAO.getByTitle("employee");
////
////        user.setRoles(r);
//
//        userDAO.save(user);
//
//        return  new ResponseEntity<>("User successfully registered", HttpStatus.CREATED);
//
//    };
//
//    @PostMapping("login")
//    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO){
//
//        Authentication authentication = authenticationManager.authenticate(
//
//                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
//
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//
////        return new ResponseEntity<String>("User successfully signed in!", HttpStatus.OK);
//
//        String token = jwtGenerator.generateToken(authentication);
//
//        return new ResponseEntity<AuthResponseDTO>(new AuthResponseDTO(token), HttpStatus.OK);
//
//    }
//
//}
//
