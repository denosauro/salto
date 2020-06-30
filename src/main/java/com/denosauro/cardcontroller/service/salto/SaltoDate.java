package com.denosauro.cardcontroller.service.salto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;

@EqualsAndHashCode
@ToString
public class SaltoDate {
    private static final String PATTERN = "hhmmddMMyy";
    
    @Getter
    private String value;
    
    private SaltoDate(String date) {
        this.value = date;
    }
    
    public static SaltoDate of(Date date) {
        return new SaltoDate(new SimpleDateFormat(PATTERN).format(date));
    }
    
    public static void main(String ...args) {
        System.out.println(SaltoDate.of(new Date()));
    }
}
