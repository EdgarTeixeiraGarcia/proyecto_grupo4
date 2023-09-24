package com.hackaboss.equipo4.Service;

import com.hackaboss.equipo4.Entities.Item;
import com.hackaboss.equipo4.IRepository.IItemsRepository;
import com.hackaboss.equipo4.IService.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ItemService implements IItemsService {

    @Autowired
    private IItemsRepository repository;

    @Override
    public List<Item> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public void update(Long id, Item item) {

        Optional<Item> op = repository.findById(id);

        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
            Item itemUpdate = op.get();
            itemUpdate.setDescription(item.getDescription());
            itemUpdate.setReason(item.getReason());
            itemUpdate.setState(item.getState());
            itemUpdate.setIdType(item.getIdType());

            repository.save(itemUpdate);
        }

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Integer getTotalItemsPerson(Long idPerson) {
        return repository.getTotalItemsPerson(idPerson);
    }

    @Override
    public Integer getTotalCompanyItems() {
        return repository.getTotalCompanyItems();
    }

    @Override
    public List<Item> getItemsByType(Long idType) {
        return repository.getItemsByType(idType);
    }

}
