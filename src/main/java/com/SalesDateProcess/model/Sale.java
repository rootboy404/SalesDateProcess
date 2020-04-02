package com.SalesDateProcess.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    private String id;
    private List<Item> itemList;
    private String name;
    private BigDecimal saleValue;
}
