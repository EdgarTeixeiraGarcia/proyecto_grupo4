package com.hackaboss.equipo4.IRepository;

import com.hackaboss.equipo4.Entities.Person;
import com.hackaboss.equipo4.Entities.PersonObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonsRepository extends JpaRepository<Person, Long> {

    //Construir métodos personalizados - en este espacio se puede construir sql native.

    /**
     ** Mostrar el total de objetos de una persona.
     ***/
    @Query(value = "SELECT COUNT(DISTINCT(id_item)) FROM person_item WHERE id_person = :idPerson", nativeQuery = true)
    Integer totalObjectsPerson(@Param("idPerson") Long idPerson);

    /**
     ** Mostrar el total de objetos dentro de la empresa.
     ***/
    @Query(value = "SELECT COUNT(*) FROM item WHERE state IS true", nativeQuery = true)
    Integer totalCompanyItems();



}
