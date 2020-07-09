package com.denosauro.cardcontroller.service.salto;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class SaltoClient {

    public static void execute(String hostname, int port, SaltoCommand saltoCommand) throws IOException {

        Socket socket = new Socket(hostname, port);

        try {
            OutputStream output = socket.getOutputStream();
            DataOutputStream writer = new DataOutputStream(output);

            InputStream input = socket.getInputStream();
            DataInputStream reader = new DataInputStream(input);

            byte[] message = new byte[saltoCommand.serialize().length];

            int j = 0;

            for (Byte b : saltoCommand.serialize())
                message[j++] = b;

            System.out.println("Command : " + Arrays.toString(message));

            System.out.println("len = " + message.length);

            writer.writeInt(SaltoConstants.ENQ);

            int answer = reader.read();

            if (answer == SaltoConstants.ACK) {
                writer.write(message, 0, message.length);
                System.out.println("Command send is done!");
            }

            answer = reader.read();

            if (answer == SaltoConstants.ACK) {
                System.out.println("PMS request accepted and being processed");
            }

        } catch (IOException e) {
            if (socket != null && !socket.isClosed()) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.err);
                }
            }
        }
    }
}
