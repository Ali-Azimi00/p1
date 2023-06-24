package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name="statuses")
public class Statuses {

    @Id
    @Column(name="status_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //makes the field serial
    private int Id;

    @Column(unique = true, nullable = false)
    private String status_name;

    public Statuses() {
    }

    public Statuses(String status_name) {
        this.status_name = status_name;
    }

//    public Statuses(int id, String status_name) {
//        Id = id;
//        this.status_name = status_name;
//    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    @Override
    public String toString() {
        return "Statuses{" +
                "Id=" + Id +
                ", status_name='" + status_name + '\'' +
                '}';
    }
}
