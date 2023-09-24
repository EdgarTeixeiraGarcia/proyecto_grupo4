package com.hackaboss.equipo4.IService;

import com.hackaboss.equipo4.Entities.Item;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IItemsService {

    // Método encargado de devolver la lista con todos los re
    List<Item> all();

    // Método encargado de devolver un registro por el ID
    Optional<Item> findById(Long id);

    // Método encargado de guardar los datos del registro
    Item save(Item item);

    // Método encargado de modificar los datos del registro
    void update(Long id, Item item);

    // Método encargado de elimiar un registro
    void delete(Long id);

    // Método encargado mostrar el total de items de una persona
    Integer getTotalItemsPerson(@Param("idPerson") Long idPerson);

    // Método encargado de mostrar el total de items en la empresa
    Integer getTotalCompanyItems();

    // Método encargado de mostrar el total de items de un tipo
    List<Item> getItemsByType(@Param("idType") Long idType);
}
