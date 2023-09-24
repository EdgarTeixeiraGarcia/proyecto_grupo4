package com.hackaboss.equipo4.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaboss.equipo4.Entities.PersonObject;
import com.hackaboss.equipo4.IRepository.IPersonObjectRepository;
import com.hackaboss.equipo4.IService.IPersonObjectService;

@Service
public class PersonObjectService implements IPersonObjectService {

    @Autowired
    private IPersonObjectRepository repository;

    @Override
    public List<PersonObject> all() {
        return repository.findAll();
    }

    @Override
    public Optional<PersonObject> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PersonObject save(PersonObject personObject) {
        personObject.setTime(LocalDateTime.now());
        return repository.save(personObject);
    }

    @Override
    public void update(Long id, PersonObject personObject) {
        Optional<PersonObject> op = repository.findById(id);

        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
            PersonObject personObjectUpdate = op.get();
            personObjectUpdate.setTime(personObject.getTime());
            personObjectUpdate.setRegisterType(personObject.getRegisterType());
            personObjectUpdate.setIdPerson(personObject.getIdPerson());
            personObjectUpdate.setIdItem(personObject.getIdItem());

            repository.save(personObjectUpdate);
        }

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void register(PersonObject registerEntry, Boolean registerType) {
            PersonObject newPersonObject = new PersonObject();
            newPersonObject.setIdItem(registerEntry.getIdItem());
            newPersonObject.setTime(LocalDateTime.now());
            newPersonObject.setIdPerson(registerEntry.getIdPerson());
            newPersonObject.setRegisterType(registerType);

            repository.save(newPersonObject);
    }

    @Override
    public List<PersonObject> getPersonReport(Long idPerson) {

        List<PersonObject>  op = repository.getPersonReport(idPerson);
        System.out.println(op);
        return repository.getPersonReport(idPerson);
    }
}
