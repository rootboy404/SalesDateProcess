package com.SalesDateProcess.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SaleServiceTest {

    @Autowired
    SaleService saleService;

    @Test
    public void givenThatListOfSalesWhenProcessThisDataWhenReturnWorstSeller() {
        //GIVEN
        List<String[]> saleList = getSalesList();

        //WHEN
        saleList.stream().forEach(saleService::addSale);

        //WHEN
        assertThat(saleService.getWorstSeller()).isEqualTo("João");

    }


    @Test
    public void givenThatListOfSalesWhenProcessThisDataWhenReturnIdMoreExpensiveSale() {
        //GIVEN
        List<String[]> saleList = getSalesList();

        //WHEN
        saleList.stream().forEach(saleService::addSale);

        //WHEN
        assertThat(saleService.getIdMoreExpensiveSale()).isEqualTo("10");
    }
    private List<String[]> getSalesList() {
        return Arrays.asList(new String[]{"003", "10", "[1-10-100,2-30-1,3-40-1]", "Pedro"},
                new String[]{"003", "11", "[1-10-100]", "João"},
                new String[]{"003", "12", "[1-10-100,2-50-1]", "Pedro"});
    }


}
