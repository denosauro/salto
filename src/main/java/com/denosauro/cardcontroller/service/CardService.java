package com.denosauro.cardcontroller.service;

import com.denosauro.cardcontroller.dto.CardRequest;

import java.io.IOException;

public interface CardService {
    void encodeCard(CardRequest cardRequest) throws IOException;
}
