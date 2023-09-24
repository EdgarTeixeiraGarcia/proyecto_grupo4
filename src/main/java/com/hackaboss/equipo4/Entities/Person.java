package com.hackaboss.equipo4.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hackaboss.equipo4.DTO.PersonDTO;
import com.hackaboss.equipo4.Entities.Component.GenericId;

@Entity
@Table(name = "persons")
public class Person extends GenericId {

    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = " first_surname", length = 50, nullable = false)
    private String firstSurname;
    @Column(name = "second_surname", length = 50, nullable = false)
    private String secondSurname;
    @Column(name = "dni", length = 9, nullable = false)
    private String dni;
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;
    @Column(name = "email", length = 100, nullable = false)
    private String email;
    @Column(name = "employee", nullable = false)
    private Boolean employee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmployee() {
        return employee;
    }

    public void setEmployee(Boolean employee) {
        this.employee = employee;
    }
    public PersonDTO toDTO() {
        return new PersonDTO(
                this.getId(),
                this.getName(),
                this.getFirstSurname(),
                this.getSecondSurname(),
                this.getDni(),
                this.getPhone(),
                this.getEmail(),
                this.getEmployee());
    }


}
