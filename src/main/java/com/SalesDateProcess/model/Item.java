package com.SalesDateProcess.model;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String id;
    private Integer quantity;
    private BigDecimal price;
}
