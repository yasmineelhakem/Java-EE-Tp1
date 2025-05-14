package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClientControleurReactif {
    @Autowired
    ClientRepositoryReactif repository;


    @RequestMapping(value="/client" ,method= RequestMethod.POST)
    public Mono<Client> save (@RequestBody Client client) {
        return repository.save(client);
    }

    @RequestMapping(value="/client" ,method=RequestMethod.PUT)
    public Mono<Client> update (@RequestBody Client client) {
        return repository.save(client);
    }

    @RequestMapping(value="/client/{id}" ,method=RequestMethod.GET)
    public Mono<Client> get (@PathVariable long id) {
        return repository.findById(id);
    }


    @RequestMapping(value="/client" ,method=RequestMethod.GET)
    public Flux<Client> getAll () {
        return repository.findAll();
    }

    @RequestMapping(value="/client/{id}" ,method=RequestMethod.DELETE)
    public Mono<Client> delete (@PathVariable long id) {
        return repository.delete(id);
    }


}
