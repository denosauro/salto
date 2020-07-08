package com.denosauro.cardcontroller.service.salto;

import com.denosauro.cardcontroller.dto.CardRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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

    public static void main(String ...args) throws IOException {
        System.out.println("result : "+ SaltoDate.of(new Date()));

        CardRequest cardRequest = new CardRequest();
        cardRequest.setCardsAmount(1);
        cardRequest.setGuestName("Roberto");
        cardRequest.setRoom("3");
        cardRequest.setStartDate(15452576402L);
        cardRequest.setEndDate(17984140402L);

        CardRequestConverter cardRequestConverter = new CardRequestConverter();

        SaltoCommand saltoCommand = cardRequestConverter.convert(cardRequest);

        System.out.println(saltoCommand.toString());

        SaltoClient.execute("localhost", 7878, saltoCommand);
    }
}
