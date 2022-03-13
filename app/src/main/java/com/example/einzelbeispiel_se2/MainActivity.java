package com.example.einzelbeispiel_se2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity{

    public EditText matNr;
    public Button sendBtn;
    public TextView serverAns;
    public TextView calcOutTxtField;
    public Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //zuordnung von den Bauteilen zu Variablen
        matNr=findViewById(R.id.matNr);
        serverAns=findViewById(R.id.serverAnswer);
        sendBtn =findViewById(R.id.sendBtn);
        calcBtn =findViewById(R.id.CalcBtn);
        calcOutTxtField=findViewById(R.id.CalcOut);

    }
    // wurde in XML hinzugefügt, Counting sort wird verwendet um zu sortieren (Sortierverfahrenswahl durch Eigeninterresse)
    public void onClickCalc(View view) {
        String matNrS=matNr.getText().toString();
        int[] appearences = new int[10];
        int[] sorted = new int[matNrS.length()];
        int matNrI=Integer.parseInt(matNrS);


        for (int i = 0; i < sorted.length; i++) {
            appearences[matNrI % 10]++;
            matNrI = matNrI / 10;
        }
        int ind=0;
        for (int i = 0; i < appearences.length;i=i+2) {
            for (int j = 0; j < appearences[i];j++) {
                sorted[ind++] = i;
            }
        }
        for (int i = 1; i < appearences.length;i=i+2) {
            for (int j = 0; j < appearences[i];j++) {
                sorted[ind++] = i;
            }
        }
        calcOutTxtField.setText(Arrays.toString(sorted));
    }
    //wird aufgerufen wenn zum Server gesendet wird, Server wird in Thread aufgerufen
    public void onClickSend(View view){
        TCPClient client=new TCPClient(matNr.getText().toString(),serverAns);
        new Thread(client).start();

    }
}