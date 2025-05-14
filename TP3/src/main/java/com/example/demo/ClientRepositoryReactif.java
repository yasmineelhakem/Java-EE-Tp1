package com.example.demo;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;

@Repository
public class ClientRepositoryReactif {
    public static Map<Long, Client> clients = new HashMap<>();

    Mono<Client> save(Client client) {
        clients.put(client.getId(), client);
        return Mono.justOrEmpty(client);
    }
    Mono<Client> findById(Long id) {
        return Mono.justOrEmpty(clients.get(id));
    }
    Flux<Client> findAll() {
        return Flux.fromIterable(clients.values());
    }
    Mono<Client> delete(Long id) {
        return Mono.justOrEmpty(clients.remove(id));
    }
}
