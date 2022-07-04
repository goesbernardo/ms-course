package com.example.hrworker.resource;

import com.example.hrworker.domain.Worker;
import com.example.hrworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;


    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){

        List<Worker> list = repository.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById (@PathVariable("id") long id){

        Worker worker = repository.findById(id).get();
        return ResponseEntity.ok(worker);
    }
}
