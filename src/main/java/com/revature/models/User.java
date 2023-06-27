package com.revature.models;



import javax.management.relation.Role;
import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    private Roles roles;

//    @ManyToMany
//    private List<Role> roles;

    public User(){

    }

    public User(String firstName, String lastName, String username, String password,  Roles roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.roles = roles;
//        this.roles = roles;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

//    public List<Role> getRoles() {
//
//        return roles;
//
//    }
//
//
//    public void setRoles(List<Role> roles) {
//
//        this.roles = roles;
//
//    }

    @Override

    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roles=" + roles +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
//                ", roles=" + roles +
                '}';

    }

}