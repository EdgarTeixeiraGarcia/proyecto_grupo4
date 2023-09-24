package com.hackaboss.equipo4.Controller;


import com.hackaboss.equipo4.DTO.PersonObjectDTO;
import com.hackaboss.equipo4.Entities.Item;
import com.hackaboss.equipo4.Entities.PersonObject;
import com.hackaboss.equipo4.IService.IItemsService;
import com.hackaboss.equipo4.IService.IPersonObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("person_object")
public class PersonObjectController {

    @Autowired
    private IPersonObjectService service;

    @Autowired
    private IItemsService itemService;

    @GetMapping()
    public List<PersonObjectDTO> all() {
        List<PersonObject> personObjects = service.all();
        return personObjects.stream().map(PersonObject::toDTO).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Optional<PersonObjectDTO> show(@PathVariable Long id){

        Optional<PersonObject> op = service.findById(id);
        if(op.isEmpty()){
            System.out.println("No existe el id");
            return Optional.of(null);
        }else{
            return Optional.of(op.get().toDTO());
        }
    }

    @PostMapping()
    public void save(@RequestBody PersonObject personObject){
        service.save(personObject);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody PersonObject personObject) {
        service.update(id, personObject);
    }

    @PutMapping("/register_enter/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void registerEnter(@PathVariable Long id) {
        Optional<PersonObject> op = service.findById(id);

        if(op.isEmpty()){
            System.out.println("No existe el id de ObjetoPersona");
        }else {
            PersonObject personObject = op.get();
            Optional<Item> op2 = itemService.findById(personObject.getIdItem().getId());
            if(op2.isEmpty()){
                System.out.println("No existe el id del item");
            }else {
                Item newItem = op2.get();
                newItem.setState(true);
                itemService.save(newItem);
                service.register(personObject, true);
            }
        }
    }

    @PutMapping("/register_exit/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void registerExit(@PathVariable Long id) {
        Optional<PersonObject> op = service.findById(id);

        if(op.isEmpty()){
            System.out.println("No existe el id de ObjetoPersona");
        }else {
            PersonObject personObject = op.get();
            Optional<Item> op2 = itemService.findById(personObject.getIdItem().getId());
            if(op2.isEmpty()){
                System.out.println("No existe el id del item");
            }else {
                Item newItem = op2.get();
                newItem.setState(false);
                itemService.save(newItem);
                service.register(personObject, false);
            }
        }
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/report/{idPerson}")
    public List<PersonObjectDTO> getPersonReport(@PathVariable Long idPerson)  {
        List<PersonObject> personObject = service.getPersonReport(idPerson);
        return personObject.stream().map(PersonObject::toDTO).collect(Collectors.toList());
    }
}
