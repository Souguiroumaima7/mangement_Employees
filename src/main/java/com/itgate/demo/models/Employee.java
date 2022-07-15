package com.itgate.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Employee extends User{


    private String salaire ;
    private String name ;


    @ManyToOne
    @JoinColumn(name="id_dep")
    private Department department;


@OneToOne(mappedBy = "employee")
private SpaceParking spaceParking ;






    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public SpaceParking getSpaceParking() {
        return spaceParking;
    }

    public void setSpaceParking(SpaceParking spaceParking) {
        this.spaceParking = spaceParking;
    }
}
