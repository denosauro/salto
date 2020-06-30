package com.denosauro.cardcontroller.service.salto;

import java.nio.charset.StandardCharsets;

public final class SaltoConstants {
    public static final byte STX = 0x2;
    public static final byte ETX = 0x3;
    public static final byte ENQ = 0x5;
    public static final byte ACK = 0x6;
    public static final byte NAK = 0x15;
    
    public static final byte DUMMY_LRC = 0x0D;
    
    public static final byte FIELD_SEPARATOR = "|".getBytes(StandardCharsets.US_ASCII)[0];
}
