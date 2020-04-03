package com.SalesDateProcess.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SalesmanServiceTest {

    @Autowired
    SalesmanService salesmanService;

    @Test
    public void givenThatListOfSalesmanWhenProcessThisDataWhenReturnTotalSalesman() throws Exception {
        //GIVEN
        List<String[]> salesman = Arrays.asList(new String[]{"001", "1234567891234", "Carlos", "800"},
                new String[]{"001", "1234567891234", "Pedro", "4000.40"},
                new String[]{"001", "1234567891234", "Pedro", "1000"}
        );
        //WHEN
        salesman.stream().forEach(salesmanService::addSalesman);
        //WHEN
        assertThat(salesmanService.getQuantitySalesman()).isEqualTo(salesman.size());
    }
}
