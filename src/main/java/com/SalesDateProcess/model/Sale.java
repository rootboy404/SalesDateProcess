package com.SalesDateProcess.model;

import lombok.*;

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
