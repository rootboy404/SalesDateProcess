package com.SalesDateProcess.model;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Salesman {

    private String cpf;

    private String name;

    private BigDecimal salary;
}
