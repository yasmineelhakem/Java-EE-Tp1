package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SalutationAmicale extends SalutationBase implements InitializingBean, DisposableBean {
    private DataBaseConfiguration dataBaseConfiguration;

    public SalutationAmicale(DataBaseConfiguration dataBaseConfiguration) {
        this.dataBaseConfiguration = dataBaseConfiguration;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after property set");
    }

    @Override
    public String saluer() {
        compteur++;
        return "Bonjour Amical" +compteur + " " + dataBaseConfiguration.getUrl() + " "+ dataBaseConfiguration.getUsername();
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("postConstruct");
    }
    @PreDestroy
    private void predestroy() {
        System.out.println("predestroy");
    }
}
