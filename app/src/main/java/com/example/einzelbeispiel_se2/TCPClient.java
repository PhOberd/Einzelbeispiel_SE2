package com.example.einzelbeispiel_se2;
import java.io.*;
import java.net.*;

public class TCPClient {

    public String sendRequest(String matNr) throws IOException {
        String modifiedMatNr;

        Socket clientSocket=new Socket("se2-isys.aau.at",53212);

        DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(matNr+'\n');

        modifiedMatNr=inFromServer.readLine();

        clientSocket.close();

        return modifiedMatNr;
    }
}
