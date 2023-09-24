package com.hackaboss.equipo4.DTO;

import com.hackaboss.equipo4.Entities.TypeOfItem;

public class ItemDTO {
    private Long id;
    private String description;
    private String reason;
    private Boolean state;
    private TypeOfItem idType;

    public ItemDTO(Long id, String description, String reason, Boolean state, TypeOfItem idType) {
        this.id = id;
        this.description = description;
        this.reason = reason;
        this.state = state;
        this.idType = idType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TypeOfItem getIdType() {
        return idType;
    }

    public void setIdType(TypeOfItem idType) {
        this.idType = idType;
    }
}
