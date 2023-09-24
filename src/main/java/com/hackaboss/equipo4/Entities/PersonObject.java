package com.hackaboss.equipo4.Entities;

import javax.persistence.*;

import com.hackaboss.equipo4.DTO.PersonObjectDTO;
import com.hackaboss.equipo4.Entities.Component.GenericId;

import java.time.LocalDateTime;

@Entity
@Table(name = "person_item")
public class PersonObject extends GenericId {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_person", nullable = false)
    private Person idPerson;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_item", nullable = false)
    private Item idItem;
    
    @Column(name = "time", nullable = false)
    private LocalDateTime time;
    
    @Column(name = "register_type", nullable = false)
    private Boolean registerType;


    
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





	public PersonObjectDTO toDTO() {
        return new PersonObjectDTO(
                this.getId(),
                this.getTime(),
                this.getRegisterType(),
				this.getIdPerson(),
				this.getIdItem());
    }
}
