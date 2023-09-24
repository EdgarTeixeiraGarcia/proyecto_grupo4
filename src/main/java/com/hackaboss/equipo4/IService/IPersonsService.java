package com.hackaboss.equipo4.IService;

import com.hackaboss.equipo4.Entities.Person;
import com.hackaboss.equipo4.Entities.PersonObject;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IPersonsService {
    // Método encargado de devolver la lista con todos los re
    List<Person> all();

    // Método encargado de devolver un registro por el ID
    Optional<Person> findById(Long id);

    // Método encargado de guardar los datos del registro
    Person save(Person persons);

    // Método encargado de modificar los datos del registro
    void update(Long id, Person persons);

    // Método encargado de elimiar un registro
    void delete(Long id);

}
