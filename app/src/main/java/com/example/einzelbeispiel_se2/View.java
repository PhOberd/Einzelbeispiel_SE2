package com.example.einzelbeispiel_se2;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

public class View extends AppCompatActivity{

    public View() {
        Button sendBtn = findViewById(R.id.sendBtn);
        Button calcBtn = findViewById(R.id.CalcBtn);

        ControllerServerCon servContr= new ControllerServerCon();
        sendBtn.setOnClickListener(servContr);

        ControllerCalc calcContr=new ControllerCalc();
        calcBtn.setOnClickListener(calcContr);
    }
}
