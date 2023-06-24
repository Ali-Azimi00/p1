package com.revature.models;


import javax.persistence.*;

@Entity
@Table(name= "reimbursements")
public class Reimbursements {

    @Id
    @Column(name = "reimb_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reimb_id;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private String description;


    private int user_id_fk; //must add one-to-many relationship to


    @ManyToOne
    private Status status;

    public Reimbursements() {
    }

    public Reimbursements(int amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public Reimbursements(int amount, String description, int user_id_fk, Status status_id_fk) {
        this.amount = amount;
        this.description = description;
        this.user_id_fk = user_id_fk;
        this.status = status_id_fk;
    }

    public Reimbursements(int reimb_id, int amount, String description, int user_id_fk, Status status_id_fk) {
        this.reimb_id = reimb_id;
        this.amount = amount;
        this.description = description;
        this.user_id_fk = user_id_fk;
        this.status = status_id_fk;
    }

    public int getReimb_id() {
        return reimb_id;
    }

    public void getReimb_id(int id) {
        this.reimb_id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id_fk() {
        return user_id_fk;
    }

    public void setUser_id_fk(int user_id_fk) {
        this.user_id_fk = user_id_fk;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    //    public void setStatus(Status status) {
//        return status;
//    }
//    public Status getStatusName() {
//        return status;
//    }

//    public void setStatus(Status status_id_fk) {
//        this.status = status_id_fk;
//    }

    @Override
    public String toString() {
        return "Reimbursments{" +
                "reimb_id=" + reimb_id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", user_id_fk=" + user_id_fk +
                ", status=" + status +
                '}';
    }
}

