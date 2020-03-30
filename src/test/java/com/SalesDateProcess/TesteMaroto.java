package com.SalesDateProcess;

import com.SalesDateProcess.model.Salesman;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class TesteMaroto {

    @Test
    public  void teste(){
        Salesman salesman = new Salesman();
        salesman.setSalary(new BigDecimal("29.60"));

        System.out.println(salesman.getSalary());
    }
}
