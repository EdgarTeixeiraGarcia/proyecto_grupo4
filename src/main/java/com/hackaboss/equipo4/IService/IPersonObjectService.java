package com.hackaboss.equipo4.IService;

import java.util.List;
import java.util.Optional;

import com.hackaboss.equipo4.Entities.PersonObject;
import org.springframework.data.repository.query.Param;

public interface IPersonObjectService {

    // Método encargado de devolver la lista con todos los re
    List<PersonObject> all();

    // Método encargado de devolver un registro por el ID
    Optional<PersonObject> findById(Long id);

    // Método encargado de guardar los datos del registro
    PersonObject save(PersonObject personObject);

    // Método encargado de modificar los datos del registro
    void update(Long id, PersonObject personObject);

    // Método encargado de elimiar un registro
    void delete(Long id);

    // Método encargado de registar si un objeto entra o sale
    public void register(PersonObject registerEntry, Boolean registerType);

    //Método encargado de traer un informe de los registros de entrada y salida de los objetos de una persona
    List<PersonObject> getPersonReport(@Param("idPerson") Long idPerson);
}
