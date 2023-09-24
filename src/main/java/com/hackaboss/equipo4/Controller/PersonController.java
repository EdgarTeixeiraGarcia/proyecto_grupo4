package com.hackaboss.equipo4.Controller;


import com.hackaboss.equipo4.DTO.PersonDTO;
import com.hackaboss.equipo4.DTO.PersonObjectDTO;
import com.hackaboss.equipo4.Entities.Person;
import com.hackaboss.equipo4.Entities.PersonObject;
import com.hackaboss.equipo4.IService.IPersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private IPersonsService service;

    @GetMapping()
    public List<PersonDTO> all() {
        List<Person> persons = service.all();
        return persons.stream().map(Person::toDTO).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Optional<PersonDTO> show(@PathVariable Long id){

        Optional<Person> op = service.findById(id);
        if(op.isEmpty()){
            System.out.println("No existe el id");
            return Optional.of(null);
        }else{
            return Optional.of(op.get().toDTO());
        }
    }

    @PostMapping()
    public void save(@RequestBody Person person){
        service.save(person);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Person person) {
        service.update(id, person);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
