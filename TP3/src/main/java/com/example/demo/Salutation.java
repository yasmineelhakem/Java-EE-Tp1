package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Salutation extends SalutationBase{
    @Override
    public String saluer(){
        return "Bonjour"+compteur++;
    };
}
