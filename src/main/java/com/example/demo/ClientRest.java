package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientRest {

    private final ClientDAO dao;
    private final ClientRepository repository;

    @GetMapping(value = "/create")
    public void create(@RequestParam String name){
        dao.create(name);
    }

    @GetMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestParam String name){
        if (dao.update(id, name)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/delete")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<ClientEntity>> getAllClients(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<ClientEntity> getOneClient(@PathVariable Integer id){
        return ResponseEntity.ok(repository.findById(id).get());
    }

}
