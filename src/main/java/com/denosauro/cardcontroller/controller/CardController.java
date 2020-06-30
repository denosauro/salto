package com.denosauro.cardcontroller.controller;

import com.denosauro.cardcontroller.dto.CardRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {
    
    @PostMapping
    public void encodeCard(@RequestBody CardRequest request) {
        
    }
}
