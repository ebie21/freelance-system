package com.bennettebrahim.Freelance.System.model;

import jakarta.persistence.*;

@Entity // This tells Spring: "Make a table for this in MySQL"
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // "Hourly" or "Fixed"
    private double pay;

    // IMPORTANT: Spring needs a no-argument constructor
    public Job() {}

    public Job(String name, String type, double pay) {
        this.name = name;
        this.type = type;
        this.pay = pay;
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


}
