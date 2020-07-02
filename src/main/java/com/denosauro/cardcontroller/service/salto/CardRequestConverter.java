package com.denosauro.cardcontroller.service.salto;

import com.denosauro.cardcontroller.dto.CardRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
public class CardRequestConverter implements Converter<CardRequest, SaltoCommand> {

    /**
     * Converts CardRequest to salto command
     * Example: STX|CN|1|E|101| | | | | | 1545140402 | 12170402 |ETX LRC
     * @param source
     * @return
     */
    @Override
    public SaltoCommand convert(CardRequest source) {
        SaltoCommand command = new SaltoCommand(SaltoCommandType.CN);
        command.getFields()[0] = String.valueOf(source.getCardsAmount());
        
        if(!StringUtils.isEmpty(source.getRoom())) {
            command.getFields()[2] = source.getRoom();
        }
        
        if(source.getStartDate() != null) {
            command.getFields()[9] = SaltoDate.of(new Date(source.getStartDate())).getValue();
        }

        if(source.getEndDate() != null) {
            command.getFields()[10] = SaltoDate.of(new Date(source.getEndDate())).getValue();
        }
        
        return command;
    }
}
