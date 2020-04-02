package com.SalesDateProcess.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProcessDataService {

    public static final String IDENTIFIER_SALESMAN = "001";
    public static final String IDENTIFIER_CLIENT = "002";
    public static final String IDENTIFIER_SALES = "003";
;

    private SalesmanService salesmanService;
    private ClientService clientService;
    private SaleService saleService;


    public ProcessDataService(SalesmanService salesmanService, ClientService clientService, SaleService saleService) {
        this.salesmanService = salesmanService;
        this.clientService = clientService;
        this.saleService = saleService;
    }

    public void processData(List<String> data, String nameFileData) throws IOException {
        if (!data.isEmpty()) {
            data.stream().forEach(this::parseDate);
            ResumeDataService resumeDataService = new ResumeDataService();
            resumeDataService.createResumeFile(nameFileData.replaceAll(".dat",""),clientService.getQuantityClient(),salesmanService.getQuantitySalesman(),saleService.getIdMoreExpensiveSale(),saleService.getWorstSeller());
        }
    }

    private void parseDate(String dateLine) {
        if (dateLine.startsWith(IDENTIFIER_SALESMAN)) {
            salesmanService.addSalesman(splitDate(dateLine));
        }

        if (dateLine.startsWith(IDENTIFIER_CLIENT)) {
            clientService.addClient(splitDate(dateLine));
        }

        if (dateLine.startsWith(IDENTIFIER_SALES)) {
            saleService.addSale(splitDate(dateLine));
        }

    }

    private String[] splitDate(String dateLine) {
        return dateLine.split("ç");
    }

}
