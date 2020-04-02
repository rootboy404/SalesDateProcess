package com.SalesDateProcess.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private String cnpj;
    private String name;
    private String businessArea;


}
