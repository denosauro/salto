package com.denosauro.cardcontroller.controller;

import com.denosauro.cardcontroller.dto.CardRequest;
import com.denosauro.cardcontroller.service.salto.CardRequestConverter;
import com.denosauro.cardcontroller.service.salto.SaltoClient;
import com.denosauro.cardcontroller.service.salto.SaltoProperties;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Objects;

@RestController
@RequestMapping(value = "/card", method = RequestMethod.POST)
public class CardController {

    private final SaltoProperties saltoProperties;

    public CardController(SaltoProperties saltoProperties) {
        this.saltoProperties = saltoProperties;
    }

    @PostMapping
    public void encodeCard(@RequestBody CardRequest request) throws IOException {
        SaltoClient.execute(saltoProperties.getHost(), saltoProperties.getPort(), Objects.requireNonNull(new CardRequestConverter().convert(request)));
    }
}
