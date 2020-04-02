package com.SalesDateProcess.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @Test
    public void givenThatListOfClientWhenProcessThisDataWhenReturnTotalClient(){
        //GIVEN
            List<String[]> clients = Arrays.asList(new String[]{"002", "2345675434544345", "Paulo", "Rural"},
                    new String[]{"002", "2345675434544345", "Henrique", "Rural"},
                    new String[]{"002", "2345675434544345", "Amanda", "Rural"});
        //WHEN
        clients.stream().forEach(clientService::addClient);
        //WHEN
        assertThat(clientService.getQuantityClient()).isEqualTo(clients.size());
    }
}
