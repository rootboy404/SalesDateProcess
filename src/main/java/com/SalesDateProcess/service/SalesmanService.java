package com.SalesDateProcess.service;

import com.SalesDateProcess.model.Salesman;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SalesmanService{

    private List<Salesman> salesmanList;

    public SalesmanService(List<Salesman> listSalesman) {
        this.salesmanList = listSalesman;
    }

    public void addSalesman( String[] valueSalesman) {
            if (valueSalesmanIsValid(valueSalesman)) {
                salesmanList.add(Salesman.builder().cpf(valueSalesman[1])
                    .name(valueSalesman[2]).salary(BigDecimal.valueOf(Double.parseDouble(valueSalesman[3]))).build());
        }
    }

    private Boolean valueSalesmanIsValid(String[] valueSalesman) {
        if (valueSalesman.length == 4) {
           return salaryIsNumeric(valueSalesman[3]);
        }
        return Boolean.FALSE;
    }

    private Boolean salaryIsNumeric(String salary) {
        return salary.matches("^\\d+(\\.\\d+)?");
    }

    public Integer getQuantitySalesman() {
        return salesmanList.size();
    }

}
