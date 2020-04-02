package com.SalesDateProcess.service;

import com.SalesDateProcess.model.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    public List<Item> parseToItemList(String[] itemList) {
        return Arrays.asList(itemList).stream().map(this::parseToItem).collect(Collectors.toList());
    }

    private Item parseToItem(String value) {
        String[] itemValue = value.split("-");
        return Item.builder().id(itemValue[0]).quantity(Integer.parseInt(itemValue[1])).price(BigDecimal.valueOf(
                Double.parseDouble(itemValue[2]))).build();
    }

    public Boolean valueItemOfSaleIsValid(String itemList) {
        return itemList.chars().allMatch(x -> Character.isDigit(x));
    }
}
