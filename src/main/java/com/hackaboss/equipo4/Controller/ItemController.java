package com.hackaboss.equipo4.Controller;

import com.hackaboss.equipo4.DTO.ItemDTO;
import com.hackaboss.equipo4.Entities.Item;
import com.hackaboss.equipo4.IService.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private IItemsService service;

    @GetMapping()
    public List<ItemDTO> all() {
        List<Item> items = service.all();
        return items.stream().map(Item::toDTO).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Optional<ItemDTO> show(@PathVariable Long id){

        Optional<Item> op = service.findById(id);
        if(op.isEmpty()){
            System.out.println("No existe el id");
            return Optional.of(null);
        }else{
            return Optional.of(op.get().toDTO());
        }
    }

    @PostMapping()
    public void save(@RequestBody Item item){
        service.save(item);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Item item) {
        service.update(id, item);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/total_items_person/{idPersona}")
    public Integer getTotalItemsPerson(@PathVariable Long idPersona){
        return service.getTotalItemsPerson(idPersona);
    }
    @GetMapping("/total_items_company")
    public Integer getTotalCompanyItems(){
        return service.getTotalCompanyItems();
    }
    @GetMapping("/items_by_type/{idType}")
    public List<ItemDTO> getItemsByType(@PathVariable Long idType){
        List<Item> items = service.getItemsByType(idType);

        return items.stream().map(Item::toDTO).collect(Collectors.toList());
    }
}
