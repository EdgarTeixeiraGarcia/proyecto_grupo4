package com.hackaboss.equipo4.Controller;

import com.hackaboss.equipo4.DTO.ItemDTO;
import com.hackaboss.equipo4.DTO.TypeOfItemDTO;
import com.hackaboss.equipo4.Entities.TypeOfItem;
import com.hackaboss.equipo4.IService.ITypeOfObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("type_of_item")
public class TypeOfItemController {

    @Autowired
    private ITypeOfObjectService service;

    @GetMapping()
    public List<TypeOfItemDTO> all() {
        List<TypeOfItem> items = service.all();
        return items.stream().map(TypeOfItem::toDTO).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Optional<TypeOfItemDTO> show(@PathVariable Long id){

        Optional<TypeOfItem> op = service.findById(id);
        if(op.isEmpty()){
            System.out.println("No existe el id");
            return Optional.of(null);
        }else{
            return Optional.of(op.get().toDTO());
        }
    }

    @PostMapping()
    public void save(@RequestBody TypeOfItem typeOfItem){

        service.save(typeOfItem);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody TypeOfItem typeOfItem) {
        service.update(id, typeOfItem);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}
