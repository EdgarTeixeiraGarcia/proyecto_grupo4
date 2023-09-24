package com.hackaboss.equipo4.IRepository;

import java.util.List;

import com.hackaboss.equipo4.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemsRepository extends JpaRepository<Item, Long> {

    //Construir métodos personalizados - en este espacio se puede construir sql native.

    /**
     ** Mostrar el total de objetos de una persona.
     ***/
    @Query(value = "SELECT COUNT(DISTINCT(id_item)) FROM person_item WHERE id_person = :idPerson", nativeQuery = true)
    Integer getTotalItemsPerson(@Param("idPerson") Long idPerson);

    /**
     ** Mostrar el total de objetos dentro de la empresa.
     ***/
    @Query(value = "SELECT COUNT(*) FROM item WHERE state IS true", nativeQuery = true)
    Integer getTotalCompanyItems();

    /**
     ** Mostrar lista de objetos de un tipo.
     ***/
    @Query(value = "SELECT * FROM item WHERE id_type = :idType", nativeQuery = true)
    List<Item> getItemsByType(@Param("idType") Long idType);

}
