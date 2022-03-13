package com.example.einzelbeispiel_se2;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;


public class ControllerServerCon extends AppCompatActivity implements View.OnClickListener {

    private TextView matNr=findViewById(R.id.matNr);
    private Button btn=findViewById(R.id.sendBtn);
    private TextView serverAns=findViewById(R.id.serverAnswer);
    private TCPClient client=new TCPClient();

    @Override
    public void onClick(View view) {
        String matrNr = matNr.getText().toString();
        try {
            serverAns.setText(client.sendRequest(matrNr));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
