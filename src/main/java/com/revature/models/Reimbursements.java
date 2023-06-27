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

    @ManyToOne
    private User user; //must add one-to-many relationship to

    @ManyToOne
    private Statuses status;

    public Reimbursements() {
    }

    public Reimbursements(int amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public Reimbursements(int amount, String description, User user, Statuses status_id_fk) {
        this.amount = amount;
        this.description = description;
        this.user = user;
        this.status = status_id_fk;
    }

    public Reimbursements(int reimb_id, int amount, String description, User user, Statuses status_id_fk) {
        this.reimb_id = reimb_id;
        this.amount = amount;
        this.description = description;
        this.user = user;
        this.status = status_id_fk;
    }

    public int getReimb_id() {
        return reimb_id;
    }

    public void setReimb_id(int id) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
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
                ", User=" + user +
                ", status=" + status +
                '}';
    }
}

