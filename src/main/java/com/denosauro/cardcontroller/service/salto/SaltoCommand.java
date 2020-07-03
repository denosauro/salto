package com.denosauro.cardcontroller.service.salto;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.Data;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Data
public class SaltoCommand {
    private SaltoCommandType type;
    private String[] fields = new String[15];

    public SaltoCommand(SaltoCommandType type) {
        this.type = type;
    }

    public Byte[] serialize() {
        List<Byte> result = new ArrayList<>();
        result.add(SaltoConstants.STX);
        result.add(SaltoConstants.FIELD_SEPARATOR);

        convertStringAndAdd(result, type.getValue());
        result.add(SaltoConstants.FIELD_SEPARATOR);

        for (String field : fields) {
            if (!StringUtils.isEmpty(field)) {
                convertStringAndAdd(result, field);
            }

            result.add(SaltoConstants.FIELD_SEPARATOR);
        }

        result.add(SaltoConstants.ETX);
        result.add(SaltoConstants.DUMMY_LRC);

        return result.toArray(new Byte[0]);
    }

    private void convertStringAndAdd(List<Byte> result, String field) {
        byte[] fieldBytes = field.getBytes(StandardCharsets.US_ASCII);

        for (byte fieldByte : fieldBytes) {
            result.add(fieldByte);
        }
    }

    public String toString(){
        String result = new String();
        result += "STX";
        result += "|";

        result += type;
        result += "|";

        for (String field : fields) {
            if (!StringUtils.isEmpty(field)) {
                result += field;
            }

            result+= "|";
        }

        result += "ETX";
        result += "LRC";

        return result;
    }
}
