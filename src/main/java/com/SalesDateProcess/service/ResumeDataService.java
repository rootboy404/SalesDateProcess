package com.SalesDateProcess.service;

import com.SalesDateProcess.fileUtil.WriteFile;

import java.io.IOException;

public class ResumeDataService {


    public static final String TITLE_TEXT_TEMPLATE = "Analysis of file data analysis ";
    public static final String CLIENT_TEXT_TEMPLATE = "Client quantity: ";
    public static final String SALESMAN_TEXT_TEMPLATE = "Salesman quantity: ";
    public static final String MORE_EXPANSIVE_SALES_TEXT_TEMPLATE = "More Expansive Sales: ";
    public static final String WORST_SELLER_TEXT_TEMPLATE = "The Worst seller: ";

    public void createResumeFile(String fileName, Integer quantityClient, Integer quantitySalesman, String idMoreExpensiveSale,
                                 String worstSeller) throws IOException {

        String template = createTemplate(fileName, quantityClient, quantitySalesman, idMoreExpensiveSale, worstSeller);
        WriteFile.WriteFileInDirectory(template, fileName, System.getProperty("user.home").concat("/data/out/"));
    }

    private String createTemplate(String fileName, Integer quantityClient, Integer quantitySalesman, String idMoreExpensiveSale, String worstSeller) {
        return TITLE_TEXT_TEMPLATE.concat(fileName).concat("\n").concat(
                CLIENT_TEXT_TEMPLATE).concat(quantityClient.toString()).concat("\n").concat(
                SALESMAN_TEXT_TEMPLATE).concat(quantitySalesman.toString()).concat("\n").concat(
                MORE_EXPANSIVE_SALES_TEXT_TEMPLATE).concat(idMoreExpensiveSale).concat("\n").concat(
                WORST_SELLER_TEXT_TEMPLATE).concat(worstSeller);
    }

}
