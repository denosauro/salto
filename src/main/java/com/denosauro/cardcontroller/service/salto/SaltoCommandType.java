package com.denosauro.cardcontroller.service.salto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SaltoCommandType {
    CN("CN");
    
    @Getter
    private String value;
}
