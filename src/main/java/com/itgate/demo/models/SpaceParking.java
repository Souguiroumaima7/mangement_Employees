package com.itgate.demo.models;

import javax.persistence.*;

@Entity
public class SpaceParking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id ;
    private String title ;
    private String description ;

    @OneToOne
    @JoinColumn(name="id_emp")
    private Employee employee;



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
