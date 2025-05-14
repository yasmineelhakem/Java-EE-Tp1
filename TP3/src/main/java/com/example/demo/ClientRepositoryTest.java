package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = main.class)

public class ClientRepositoryTest {

    @Autowired
    private ClientRepository repository;

    @Test
    public void testRepository() {
        Client client = new Client();
        client.setNom("Tom");
        client.setAge(40);

        repository.save(client);

        assertEquals(1, repository.findAll().size()); // confirm save

        Client loadedClient = repository.findById(client.getId()).get(); // load / read by id

    assertEquals("Tom", loadedClient.getNom());
    assertEquals(40, loadedClient.getAge());

    client.setNom("Peter");//changename
    repository.save(client);//update
        Client updatedClient = repository.findById(client.getId()).get(); // reload by id
        assertEquals("Peter", updatedClient.getNom()); // check name updated correctly
        assertEquals(40, updatedClient.getAge());//check agde unhanged
        repository.delete(client);
        assertEquals(0, repository.findAll().size());//confirm deletion

    }


}
