package com.denosauro.cardcontroller.service.salto;

import com.denosauro.cardcontroller.dto.CardRequest;
import com.denosauro.cardcontroller.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaltoService implements CardService {
    private final CardRequestConverter cardConverter;
    
    @Override
    public void encodeCard(CardRequest cardRequest) {
        
    }
}
