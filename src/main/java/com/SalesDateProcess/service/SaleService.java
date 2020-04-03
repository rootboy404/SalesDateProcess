package com.SalesDateProcess.service;

import com.SalesDateProcess.model.Item;
import com.SalesDateProcess.model.Sale;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SaleService {

    private List<Sale> saleList;
    private ItemService itemService;

    public SaleService(List<Sale> saleList, ItemService itemService) {
        this.saleList = saleList;
        this.itemService = itemService;
    }

    public void addSale(String[] valueSale) {
        if (valueSaleIsValid(valueSale)) {
            List<Item> itemList = itemService.parseToItemList(valueSale[2].replaceAll("(\\[)|(\\])", "").split(","));
            saleList.add(Sale.builder().id(valueSale[1])
                    .itemList(itemList)
                    .name(valueSale[3])
                    .saleValue(new BigDecimal(itemList.stream().map(item -> item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                            .collect(Collectors.toList()).stream().mapToDouble(BigDecimal::doubleValue).sum()))
                    .build()
            );
        }
    }

    private Boolean valueSaleIsValid(String[] valueSale) {
        if (valueSale.length == 4) {
            return itemService.valueItemOfSaleIsValid(valueSale[2].replaceAll("[\\W\\.]", ""));
        }
        return Boolean.FALSE;
    }

    public String getIdMoreExpensiveSale() {
        return saleList.isEmpty() ? "No have  Expensive Sale" : saleList.stream().max(Comparator.comparing(sale -> sale.getSaleValue())).get().getId();
    }

    public String getWorstSeller() {
        return saleList.isEmpty() ? "No have WorstSeller" : saleList.stream().collect(Collectors.groupingBy(Sale::getName,
                Collectors.summingDouble(sale -> Double.parseDouble(sale.getSaleValue().toString()))))
                .entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue()
                        .thenComparing(v -> v.getValue())).findFirst().get().getKey();
    }

}
