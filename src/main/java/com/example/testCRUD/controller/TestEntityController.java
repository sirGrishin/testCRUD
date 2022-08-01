package com.example.testCRUD.controller;

import com.example.testCRUD.model.TestEntity;
import com.example.testCRUD.service.TestEntityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Ilya Grishin
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestEntityController {

    private final TestEntityService service;

    @PostMapping
    ResponseEntity<TestEntity> create(@RequestBody TestEntity entity){
        return ResponseEntity.ok().body(service.create(entity));
    }


    @PutMapping("/{id}")
    ResponseEntity<TestEntity> update(@PathVariable("id") UUID id, @RequestBody TestEntity entity){
        return ResponseEntity.ok().body(service.update(id,entity));
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") UUID id){
       service.delete(id);
    }


    @GetMapping("/{id}")
    ResponseEntity<TestEntity> get(@PathVariable("id") UUID id){
        return ResponseEntity.ok().body(service.get(id));
    }

    @GetMapping
    Page<TestEntity> getAll(@PageableDefault(size = Integer.MAX_VALUE) Pageable page){
        return service.getAll(page);
    }
}
