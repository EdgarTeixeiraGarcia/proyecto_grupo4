package com.hackaboss.equipo4.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaboss.equipo4.Entities.TypeOfItem;
import com.hackaboss.equipo4.IRepository.ITypeOfObjectRepository;
import com.hackaboss.equipo4.IService.ITypeOfObjectService;

@Service
public class TypeOfObjectService implements ITypeOfObjectService {

    @Autowired
    private ITypeOfObjectRepository repository;
    
    @Override
    public List<TypeOfItem> all() {
        return repository.findAll();
    }

    @Override
    public Optional<TypeOfItem> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public TypeOfItem save(TypeOfItem typeOfItem) {
        return repository.save(typeOfItem);
    }

    @Override
    public void update(Long id, TypeOfItem typeOfItem) {
        Optional<TypeOfItem> op = repository.findById(id);

        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
            TypeOfItem typeOfItemUpdate = op.get();
            typeOfItemUpdate.setName(typeOfItem.getName());

            repository.save(typeOfItemUpdate);
        }

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
