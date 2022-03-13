package com.example.einzelbeispiel_se2;

import android.widget.TextView;

import java.io.*;
import java.net.*;

public class TCPClient extends MainActivity implements Runnable{
    String matNr;
    TextView serverAnswer;
    TCPClient(String matNr, TextView serverAnswer){
        this.matNr=matNr;
        this.serverAnswer=serverAnswer;
    }

    public void sendRequest() throws IOException {
        String serverInput;

        Socket clientSocket=new Socket("se2-isys.aau.at",53212);

        DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(matNr+'\n');

        serverInput=inFromServer.readLine();
        clientSocket.close();
        serverAnswer.setText(serverInput);
    }
    // runnable für Threading
    @Override
    public void run() {
        try{
            sendRequest();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
