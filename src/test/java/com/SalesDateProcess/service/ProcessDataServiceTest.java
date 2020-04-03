package com.SalesDateProcess.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ProcessDataServiceTest {


    @Test
    public void givenThatDataWhenProcessThisDataWhenReturnDataResume() throws IOException {
        //GIVEN
        List<String> data = Arrays.asList("001ç1234567891234çAndreç500",
                "001ç3245678865434çDanielç300.99",
                "002ç2345675434544345çJose da SilvaçRural",
                "002ç2345675433444345çEduardo PereiraçRural",
                "003ç10ç[1-10-100,2-30-2.50]çAndre",
                "003ç08ç[1-34-10,2-33-1]çDaniel");
        //WHEN
        ProcessDataService processDataService = new ProcessDataService(new SalesmanService(new ArrayList<>()), new ClientService(new ArrayList<>()),
                new SaleService(new ArrayList<>(), new ItemService()));
        processDataService.processData(data, "teste.dat");

        Path path = Paths.get(System.getProperty("user.home").concat("/data/out/").concat("teste.done.dat"));
        List<String> testeDone = Files.lines(path).collect(Collectors.toList());

        //WHEN
        assertThat(path.getFileName().toString()).isEqualTo("teste.done.dat");
        assertThat(testeDone).isEqualTo(Arrays.asList("Analysis of file data analysis teste",
                "Client quantity: 2",
                "Salesman quantity: 2",
                "More Expansive Salesman: 10",
                "The Worst seller: Daniel"));
    }
}
