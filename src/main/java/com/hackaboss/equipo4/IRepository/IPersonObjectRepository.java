package com.hackaboss.equipo4.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackaboss.equipo4.Entities.PersonObject;

import java.util.List;

@Repository
public interface IPersonObjectRepository extends JpaRepository<PersonObject, Long> {

    /**
     ** Mostrar lista de objetos de un tipo.
     ***/
    @Query(value = "SELECT * FROM person_item WHERE id_person = :idPerson ORDER BY time DESC ", nativeQuery = true)
    List<PersonObject> getPersonReport(@Param("idPerson") Long idPerson);

}
