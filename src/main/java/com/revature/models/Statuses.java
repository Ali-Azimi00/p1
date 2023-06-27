package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name="statuses")
public class Statuses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int status_id;

    @Column(name="status_name",unique = true, nullable = false)
    private String statusName;

    public Statuses(){

    }
    public Statuses(int status_id) {
        this.status_id = status_id;
    }

    public Statuses(String status_name) {
        this.statusName = status_name;
    }
    public Statuses(int status_id, String status_name) {
        this.status_id = status_id;
        this.statusName = status_name;
    }

    public int getId() {
        return status_id;
    }

    public void setId(int id) {
        status_id = id;
    }

    public String getStatus_name() {
        return statusName;
    }

    public void setStatus_name(String status_name) {
        this.statusName = status_name;
    }

    @Override
    public String toString() {
        return "Statuses{" +
                "Id=" + status_id +
                ", status_name='" + statusName + '\'' +
                '}';
    }
}
