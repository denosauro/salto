package com.denosauro.cardcontroller.dto;

import lombok.Data;

@Data
public class CardRequest {
    private String guestName;
    private int cardsAmount = 1;
    private String room;
    private Long startDate;
    private Long endDate;
}
