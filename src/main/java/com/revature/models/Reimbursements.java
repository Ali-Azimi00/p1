package com.revature.models;


import javax.persistence.*;

@Entity
@Table(name= "reimbursements")
public class Reimbursements {

    @Id
    @Column(name = "reimb_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private String description;


    private int user_id_fk; //must add one-to-many relationship to

    @ManyToOne
    private Statuses status_id_fk;

    public Reimbursements() {
    }

    public Reimbursements(int amount, String description, int user_id_fk, Statuses status_id_fk) {
        this.amount = amount;
        this.description = description;
        this.user_id_fk = user_id_fk;
        this.status_id_fk = status_id_fk;
    }

//    public Reimbursements(int id, int amount, String description, int user_id_fk, Statuses status) {
//        this.id = id;
//        this.amount = amount;
//        this.description = description;
//        this.user_id_fk = user_id_fk;
//        this.status_id_fk = status;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Statuses getStatus() {
        return status_id_fk;
    }

    public void setStatus(Statuses status_id_fk) {
        this.status_id_fk = status_id_fk;
    }

    @Override
    public String toString() {
        return "Reimbursements{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", user_id_fk=" + user_id_fk +
                ", status_id_fk=" + status_id_fk +
                '}';
    }
}

