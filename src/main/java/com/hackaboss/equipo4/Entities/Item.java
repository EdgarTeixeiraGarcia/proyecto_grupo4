package com.hackaboss.equipo4.Entities;

import com.hackaboss.equipo4.DTO.ItemDTO;
import com.hackaboss.equipo4.Entities.Component.GenericId;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item extends GenericId {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_type", nullable = false)
    private TypeOfItem idType;
    @Column(name = " description", length = 150, nullable = false)
    private String description;
    @Column(name = "reason", length = 50, nullable = false)
    private String reason;

    @Column(name = "state", nullable = false)
    private Boolean state;

    public TypeOfItem getIdType() {
        return idType;
    }

    public void setIdType(TypeOfItem idType) {
        this.idType = idType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public ItemDTO toDTO() {
        return new ItemDTO(this.getId(),this.getDescription(),this.getReason(),this.getState(),this.getIdType());
    }

}
