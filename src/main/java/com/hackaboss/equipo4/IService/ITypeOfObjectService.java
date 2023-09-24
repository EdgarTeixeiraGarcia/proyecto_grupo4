package com.hackaboss.equipo4.IService;

import java.util.List;
import java.util.Optional;

import com.hackaboss.equipo4.Entities.TypeOfItem;

public interface ITypeOfObjectService {
    // Método encargado de devolver la lista con todos los re
    List<TypeOfItem> all();

    // Método encargado de devolver un registro por el ID
    Optional<TypeOfItem> findById(Long id);

    // Método encargado de guardar los datos del registro
    TypeOfItem save(TypeOfItem typeOfItem);

    // Método encargado de modificar los datos del registro
    void update(Long id, TypeOfItem typeOfItem);

    // Método encargado de elimiar un registro
    void delete(Long id);
}
