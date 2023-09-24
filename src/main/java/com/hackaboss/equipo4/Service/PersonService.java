package com.hackaboss.equipo4.Service;

import java.util.List;
import java.util.Optional;

import com.hackaboss.equipo4.Entities.Person;
import com.hackaboss.equipo4.Entities.PersonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.hackaboss.equipo4.IRepository.IPersonsRepository;
import com.hackaboss.equipo4.IService.IPersonsService;

@Service
public class PersonService implements IPersonsService {

    @Autowired
    private IPersonsRepository repository;
    @Override
    public List<Person> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Person save(Person persons) {
        return repository.save(persons);
    }

    @Override
    public void update(Long id, Person person) {

        Optional<Person> op = repository.findById(id);

        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
            Person personUpdate = op.get();
            personUpdate.setName(person.getName());
            personUpdate.setFirstSurname(person.getFirstSurname());
            personUpdate.setSecondSurname(person.getSecondSurname());
            personUpdate.setDni(person.getDni());
            personUpdate.setPhone(person.getPhone());
            personUpdate.setEmail(person.getEmail());
            personUpdate.setEmployee(person.getEmployee());

            repository.save(personUpdate);
        }

    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
