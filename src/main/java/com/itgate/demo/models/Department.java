package com.itgate.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id ;
    private String name ;
    private String Description ;




    @OneToMany(mappedBy = "department")
    private Collection<Employee> employee;



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

   /* public Collection<com.itgate.demo.models.Employee> getEmployee() {
        return Employee;
    }

    public void setEmployee(Collection<com.itgate.demo.models.Employee> employee) {
        Employee = employee;
    }*/
}
