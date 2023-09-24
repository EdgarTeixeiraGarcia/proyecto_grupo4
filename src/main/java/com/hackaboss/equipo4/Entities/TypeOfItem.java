package com.hackaboss.equipo4.Entities;

import javax.persistence.*;

import com.hackaboss.equipo4.DTO.TypeOfItemDTO;
import com.hackaboss.equipo4.Entities.Component.GenericId;

@Entity
@Table(name = "type_of_item")
public class TypeOfItem extends GenericId {

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfItemDTO toDTO() {
        return new TypeOfItemDTO(
                this.getId(),
                this.getName());
    }

}
