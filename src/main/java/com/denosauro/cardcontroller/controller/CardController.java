package com.denosauro.cardcontroller.controller;

import com.denosauro.cardcontroller.dto.CardRequest;
import com.denosauro.cardcontroller.service.salto.SaltoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;


@RestController
@RequestMapping(value = "/card", method = RequestMethod.POST)
public class CardController {

    @Autowired
    private SaltoService service;

    @GetMapping
    public void encodeCard(@RequestBody CardRequest request) throws IOException {
        service.encodeCard(request);
    }
}
