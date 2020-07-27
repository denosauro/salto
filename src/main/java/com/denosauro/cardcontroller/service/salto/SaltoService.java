package com.denosauro.cardcontroller.service.salto;

import com.denosauro.cardcontroller.dto.CardRequest;
import com.denosauro.cardcontroller.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaltoService implements CardService {

    private final CardRequestConverter cardConverter;
    private final SaltoProperties saltoProperties;

    @Override
    public void encodeCard(CardRequest cardRequest) throws IOException {
        SaltoClient.execute(saltoProperties.getHost(), saltoProperties.getPort(), Objects.requireNonNull(cardConverter.convert(cardRequest)));
    }
}
