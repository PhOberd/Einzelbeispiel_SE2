package com.example.einzelbeispiel_se2;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class ControllerCalc extends AppCompatActivity implements View.OnClickListener{

    private TextView matNr=findViewById(R.id.matNr);
    private Button btn=findViewById(R.id.sendBtn);
    private TextView calcOutTxtField=findViewById(R.id.CalcOut);

    @Override
    public void onClick(View view) {
        String newMatNr=countSort(matNr.toString());
        calcOutTxtField.setText(newMatNr);

    }

    private String countSort(String matNr){
        int[] appearences = new int[10];
        int[] sorted = new int[matNr.length()];
        int number = Integer.parseInt(matNr);

        for (int i = 0; i < sorted.length; i++) {
            appearences[number % 10]++;
            number = number / 10;
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
        return Arrays.toString(sorted);
    }
}
