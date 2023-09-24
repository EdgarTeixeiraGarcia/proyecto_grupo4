package com.hackaboss.equipo4.DTO;

import com.hackaboss.equipo4.Entities.Item;
import com.hackaboss.equipo4.Entities.Person;

import java.time.LocalDateTime;

public class PersonObjectDTO {
    private Long id;
    private LocalDateTime time;
    private Boolean registerType;
    private Person idPerson;
    private Item idItem;

    public PersonObjectDTO(Long id, LocalDateTime time, Boolean registerType, Person idPerson, Item idItem) {
        this.id = id;
        this.time = time;
        this.registerType = registerType;
        this.idPerson = idPerson;
        this.idItem = idItem;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Boolean getRegisterType() {
        return registerType;
    }

    public void setRegisterType(Boolean registerType) {
        this.registerType = registerType;
    }

    public Person getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Person idPerson) {
        this.idPerson = idPerson;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }
}
